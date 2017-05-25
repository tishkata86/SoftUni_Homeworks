package connection;

import persistance.Column;
import persistance.Entity;
import persistance.Id;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.*;

public class EntityManager implements DbContext {

    private Connection connection;

    public EntityManager(Connection connection) {
        this.connection = connection;
    }

    @Override
    public <E> boolean persist(E entity) throws IllegalAccessException, SQLException {
        Field primary = this.getId(entity.getClass());
        primary.setAccessible(true);
        Object value = primary.get(entity);

        this.doCreate(entity, primary);

        if (value == null || (Long) value <= 0) {
            return this.doInsert(entity, primary);

        }

        return doUpdate(entity, primary);
    }

    @Override
    public <E> Iterable<E> find(Class<E> table) throws SQLException, ClassNotFoundException, IllegalAccessException,
            InstantiationException {
        return this.find(table, null);
    }

    @Override
    public <E> Iterable<E> find(Class<E> table, String where) throws SQLException, ClassNotFoundException,
            IllegalAccessException, InstantiationException {
        String tableName = this.getTableName(table);
        String sqlSelect = "SELECT * FROM " + tableName + " WHERE 1=1";
        if (where != null) {
            sqlSelect += " AND " + where;
        }

        List<E> entities = new ArrayList<>();

        ResultSet rs = connection.prepareStatement(sqlSelect).executeQuery();
        while (rs.next()) {
            E entity = table.newInstance();
            this.fillEntity(entity, rs);
            entities.add(entity);
        }

        return Collections.unmodifiableList(entities);
    }

    @Override
    public <E> E findFirst(Class<E> table) throws SQLException, IllegalAccessException, InstantiationException {
        return findFirst(table, null);
    }

    @Override
    public <E> E findFirst(Class<E> table, String where) throws IllegalAccessException, InstantiationException,
            SQLException {
        String tableName = this.getTableName(table);
        String sqlSelect = "SELECT * FROM " + tableName + " WHERE 1=1";
        if (where != null) {
            sqlSelect += " AND " + where;
        }

        ResultSet rs = connection.prepareStatement(sqlSelect).executeQuery();
        rs.first();

        E entity = table.newInstance();

        this.fillEntity(entity, rs);

        return entity;
    }

    private <E> void fillEntity(E entity, ResultSet rs) throws SQLException, IllegalAccessException {
        Field[] fields = entity.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            String fieldName = this.getFieldName(field);
            Object value = Mapper.getFieldValue(field, fieldName, rs);
            field.set(entity, value);
        }
    }

    static class Mapper {

        public static Object getFieldValue(Field field, String fieldName, ResultSet rs) throws SQLException {
            if (field.getType() == Integer.class || field.getType() == int.class) {
                return rs.getInt(fieldName);
            } else if (field.getType() == Long.class || field.getType() == long.class) {
                return rs.getLong(fieldName);
            } else if (field.getType() == String.class) {
                return rs.getString(fieldName);
            } else if (field.getType() == Date.class) {
                return rs.getDate(fieldName);
            }

            return null;
        }
    }

    private <E> String getTableName(Class<E> entity) {
        String tableName = "";

        if (entity.isAnnotationPresent(Entity.class)) {
            Entity entityAnnotation = entity.getAnnotation(Entity.class);
            tableName = entityAnnotation.name();
        }

        if (tableName.equals("")) {
            tableName = entity.getSimpleName();
        }

        return tableName;
    }

    private String getFieldName(Field field) {
        String columnName = "";

        if (field.isAnnotationPresent(Column.class)) {
            Column columnAnnotation = field.getAnnotation(Column.class);
            columnName = columnAnnotation.name();
        }

        if (columnName.equals("")) {
            columnName = field.getName();
        }

        return columnName;
    }

    private Field getId(Class c) {
        return Arrays.stream(c.getDeclaredFields())
                .filter(f -> f.isAnnotationPresent(Id.class))
                .findFirst()
                .orElseThrow(() -> new IllegalAccessError(""));
    }

    private <E> boolean doCreate(E entity, Field primary) throws SQLException {
        String tableName = this.getTableName(entity.getClass());
        String query = "CREATE TABLE IF NOT EXISTS " + tableName + " (";

        String columns = "";

        Field[] fields = entity.getClass().getDeclaredFields();
        int counter = 0;
        for (Field field : fields) {
            field.setAccessible(true);
            columns += " `" + this.getFieldName(field) + "` " + this.getDatabaseType(field);
            if (field.getName().equals(primary.getName())) {
                columns += " PRIMARY KEY AUTO_INCREMENT";
            }
            if (counter < fields.length - 1) {
                columns += ",";
            }
            counter++;
        }

        query += columns + ")";

        return this.connection.prepareStatement(query).execute();
    }

    private String getDatabaseType(Field field) {
        switch (field.getType().getSimpleName().toLowerCase()) {
            case "int":
                return "INT";
            case "string":
                return "VARCHAR(50)";
            case "long":
                return "BIGINT";
            case "date":
                return "DATE";
        }
        return null;
    }

    private <E> boolean doInsert(E entity, Field primary) throws IllegalAccessException, SQLException {
        String tableName = this.getTableName(entity.getClass());
        String query = "INSERT INTO " + tableName + " (";

        String columns = "";
        String values = "";
        int counter = 0;
        Field[] fields = entity.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);

            if (!field.getName().equals(primary.getName())) {
                columns += " `" + this.getFieldName(field) + "`";

                Object value = field.get(entity);
                if (value instanceof java.util.Date) {
                    values += "'" + new SimpleDateFormat("yyyy-MM-dd").format(value) + "'";
                } else {
                    values += "'" + value + "'";
                }

                if (counter < fields.length - 1) {
                    columns += ", ";
                    values += ", ";
                }
            }
            counter++;
        }

        query += columns + ") " +
                "VALUES(" + values + ")";

        return this.connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS).execute();
    }

    private <E> boolean doUpdate(E entity, Field primary) throws IllegalAccessException, SQLException {
        String tableName = this.getTableName(entity.getClass());
        String query = "UPDATE " + tableName + " SET ";
        String where = "WHERE ";

        Field[] fields = entity.getClass().getDeclaredFields();
        int counter = 0;
        for (Field field : fields) {
            field.setAccessible(true);

            if (getFieldName(field).equals(primary.getName())) {
                String primaryColumnName = primary.getName();
                Long primaryColumnValue = (Long) primary.get(entity);
                where += "`" + primaryColumnName + "` = " + primaryColumnValue;
                continue;
            }

            Object value = field.get(entity);
            if (value instanceof Date) {
                query += "`" + getFieldName(field) + "` = '" + new SimpleDateFormat("yyyyMMdd").format(value) + "' ";
            } else {
                query += "`" + getFieldName(field) + "` = '" + value + "' ";
            }

            if (counter < fields.length - 2) {
                query += ", ";
            }
            counter++;
        }


        return this.connection.prepareStatement(query + where).execute();
    }


}

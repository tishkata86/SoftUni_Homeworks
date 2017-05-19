package connection;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

public class EntityManager implements DbContext {

    private Connection connection;
    private Set<Object> persistedEntities;

    public EntityManager(Connection connection) {
        this.connection = connection;
        this.persistedEntities = new HashSet<>();
    }

    @Override
    public <E> boolean persist(E entity) throws IllegalAccessException, SQLException {
        Field primary = this.getId(entity.getClass());
        primary.setAccessible(true);
        Object value = primary.get(entity);

        this.doCreate(entity, primary);

        if (value == null || (Long) value < 0) {
            return this.doInsert(entity, primary);
        }

        return doUpdate(entity, primary);
    }

    @Override
    public <E> Iterable<E> find(Class<E> table) throws SQLException, ClassNotFoundException, IllegalAccessException,
            InstantiationException {
        //TODO: Make the implementation
        return null;
    }

    @Override
    public <E> Iterable<E> find(Class<E> table, String where) throws SQLException, ClassNotFoundException,
            IllegalAccessException, InstantiationException {
        //TODO: Make the implementation
        return null;
    }

    @Override
    public <E> E findFirst(Class<E> table) throws SQLException, IllegalAccessException, InstantiationException {
        //TODO: Make the implementation
        return null;
    }

    @Override
    public <E> E findFirst(Class<E> table, String where) throws SQLException, IllegalAccessException,
            InstantiationException {
        Statement stmt = this.connection.createStatement();
        String query = "SELECT * FROM " + this.getTableName(table) + " WHERE 1 " +
                (where != null ? "AND " + where : "");
        ResultSet rs = stmt.executeQuery(query);
        E entity = table.newInstance();
        rs.next();
        this.fillEntity(table, rs, entity);

        return entity;
    }

    private <E> void fillEntity(Class<E> table, ResultSet rs, E entity) {
        //TODO: Implementation
    }

    private <E> String getTableName(Class<E> entity) {
        //TODO: Make the implementation
        return null;
    }

    private String getField(Field field) {
        //TODO: Make the implementation
        return null;
    }

    private Field getId(Class c) {
        //TODO: Make the implementation
        return null;
    }

    private <E> boolean doCreate(E entity, Field primary) {
        String query = "CREATE TABLE IF NOT EXISTS ";
        //TODO: Make the implementation
        return true;
    }

    private <E> boolean doInsert(E entity, Field primary) throws IllegalAccessException, SQLException {
        String query = "INSERT INTO " + this.getTableName(entity.getClass()) + " ";

        return this.connection.prepareStatement(query).execute();
    }

    private <E> boolean doUpdate(E entity, Field primary) throws IllegalAccessException, SQLException {
        String query = "UPDATE " + this.getTableName(entity.getClass()) + " SET";
        String where = "WHERE 1=1";

        return this.connection.prepareStatement(query + where).execute();
    }

    private String getDbType(Field field, Field primary) {
        field.setAccessible(true);
        if (field.getName().equals(primary.getName())) {
            return "BIGINT PRIMARY KEY AUTO_INCREMENT";
        }

        switch (field.getType().getSimpleName()) {
            case "int":
                return "INT";
            case "String":
                return "VARCHAR(50)";
            //TODO: Custom Implementation
        }

        return null;
    }
}

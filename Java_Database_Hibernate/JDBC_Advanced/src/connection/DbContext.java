package connection;

import java.sql.SQLException;

public interface DbContext {

    <E> boolean persist(E entity)
            throws IllegalAccessException, SQLException;

    <E> Iterable<E> find(Class<E> table)
            throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException;

    <E> Iterable<E> find(Class<E> table, String where)
            throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException;

    <E> E findFirst(Class<E> table)
            throws SQLException, IllegalAccessException, InstantiationException;

    <E> E findFirst(Class<E> table, String where)
            throws SQLException, IllegalAccessException, InstantiationException;

}

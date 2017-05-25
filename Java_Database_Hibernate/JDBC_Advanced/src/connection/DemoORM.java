package connection;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

public class DemoORM {

    public static void main(String[] args) throws SQLException, IllegalAccessException, InstantiationException,
            ClassNotFoundException {

        try {
            Connector.initConnection(
                    "mysql",
                    "root",
                    "1234",
                    "localhost",
                    "3306",
                    "school");
            Connection connection = Connector.getConnection();
            EntityManager em = new EntityManager(connection);

            User user = new User("Joro", 23, new Date());
            em.persist(user);
            user.setId(1);

            user.setName("Ivan");
            em.persist(user);

            User findUser = em.findFirst(User.class);
            System.out.println(findUser.toString());
        } catch (SQLException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

}

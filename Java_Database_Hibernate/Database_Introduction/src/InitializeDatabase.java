import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InitializeDatabase {

    public static final String URL = "jdbc:mysql://localhost:3306/minions_db?useSSL=false&createDatabaseIfNotExist=true";
    public static final String USER = "root";
    public static final String PASS = "1234";

    public static void main(String[] args) {

        try (
                Connection connection = DriverManager.getConnection(URL, USER, PASS);
                Statement statement = connection.createStatement();
                ){

            String useDatabase = "USE minions_db";
            statement.execute(useDatabase);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Initialize {

    public static final String URL = "jdbc:mysql://localhost:3306/minions_db";
    public static final String USER = "root";
    public static final String PASS = "1234";

    public static void main(String[] args) throws SQLException {
        String command =
                "CREATE DATABASE IF NOT EXISTS minions_db;\n" +
                        "USE minions_db;\n" +
                        "\n" +
                        "CREATE TABLE towns(\n" +
                        "  id INT PRIMARY KEY AUTO_INCREMENT,\n" +
                        "  name VARCHAR(50) NOT NULL,\n" +
                        "  country VARCHAR(50) NOT NULL\n" +
                        ");\n" +
                        "\n" +
                        "CREATE TABLE minions(\n" +
                        "  id INT PRIMARY KEY AUTO_INCREMENT,\n" +
                        "  name VARCHAR(50) NOT NULL ,\n" +
                        "  age INT NOT NULL,\n" +
                        "  town_id INT NOT NULL,\n" +
                        "  FOREIGN KEY (town_id) REFERENCES towns(id)\n" +
                        ");\n" +
                        "\n" +
                        "CREATE TABLE villains(\n" +
                        "  id INT PRIMARY KEY AUTO_INCREMENT,\n" +
                        "  name VARCHAR(50) NOT NULL,\n" +
                        "  evilnes_factor ENUM('good','bad','evil','super evil')\n" +
                        ");\n" +
                        "\n" +
                        "CREATE TABLE villains_and_minions(\n" +
                        "  villain_id INT,\n" +
                        "  minion_id INT,\n" +
                        "  FOREIGN KEY (villain_id) REFERENCES villains(id),\n" +
                        "  FOREIGN KEY (minion_id) REFERENCES minions(id)\n" +
                        ");";

        try  {
            Connection connection = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("Connection is successful! Well done.");
        } catch (SQLException e){
            e.printStackTrace();
        }

    }
}

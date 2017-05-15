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
            String createTowns = "CREATE TABLE IF NOT EXISTS towns(\n" +
                    "  id INT PRIMARY KEY AUTO_INCREMENT,\n" +
                    "  name VARCHAR(50) NOT NULL,\n" +
                    "  country VARCHAR(50) NOT NULL\n" +
                    ");";

            String createMinions = "CREATE TABLE IF NOT EXISTS minions(\n" +
                    "  id INT PRIMARY KEY AUTO_INCREMENT,\n" +
                    "  name VARCHAR(50) NOT NULL,\n" +
                    "  town_id INT NOT NULL,\n" +
                    "  FOREIGN KEY (town_id) REFERENCES towns(id)\n" +
                    ");";

            String createVillains = "CREATE TABLE IF NOT EXISTS villains(\n" +
                    "  id INT PRIMARY KEY AUTO_INCREMENT,\n" +
                    "  name VARCHAR(50) NOT NULL,\n" +
                    "  evilness ENUM('good', 'bad', 'evil', 'super evil')\n" +
                    ");";

            String createConstraints = "CREATE TABLE IF NOT EXISTS villains_minions(\n" +
                    "  minion_id INT NOT NULL,\n" +
                    "  villain_id INT NOT NULL,\n" +
                    "  PRIMARY KEY (minion_id, villain_id),\n" +
                    "  FOREIGN KEY (minion_id) REFERENCES minions(id),\n" +
                    "  FOREIGN KEY (villain_id) REFERENCES villains(id)\n" +
                    ");";

            statement.execute(createTowns);
            statement.execute(createMinions);
            statement.execute(createVillains);
            statement.execute(createConstraints);

            String fillTowns = "INSERT INTO towns(name, country)\n" +
                    "  VALUE ('Sofia', 'Bulgaria'),\n" +
                    "  ('Atina', 'Greece'),\n" +
                    "  ('Ankara', 'Turkey'),\n" +
                    "  ('Paris', 'France'),\n" +
                    "  ('Berlin', 'Germany');\n";

            String fillMinions = "INSERT INTO minions(name, town_id)\n" +
                    "  VALUE ('Sasho', 1),\n" +
                    "  ('Ivan', 2),\n" +
                    "  ('Atanaska', 3),\n" +
                    "  ('Georgi', 4),\n" +
                    "  ('Pesho', 5);\n";

            String fillVillains = "INSERT INTO villains(name, evilness)\n" +
                    "  VALUE('Petkan', 'good'),\n" +
                    "  ('Dragan', 'evil'),\n" +
                    "  ('Hasan', 'super evil'),\n" +
                    "  ('Ali Baba', 'good'),\n" +
                    "  ('Sandokan', 'bad');\n";

            String fillConstrains = "INSERT INTO villains_minions(minion_id, villain_id)\n" +
                    "  VALUE(1, 1),\n" +
                    "  (2,1),\n" +
                    "  (1,2),\n" +
                    "  (3,4),\n" +
                    "  (5,1);\n";

            statement.execute(fillTowns);
            statement.execute(fillMinions);
            statement.execute(fillVillains);
            statement.execute(fillConstrains);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

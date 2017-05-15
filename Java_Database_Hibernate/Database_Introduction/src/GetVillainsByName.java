import java.sql.*;

public class GetVillainsByName {

    public static void main(String[] args) {
        try (
                Connection connection = DriverManager.getConnection(
                        InitializeDatabase.URL,
                        InitializeDatabase.USER,
                        InitializeDatabase.PASS);
                Statement statement = connection.createStatement();
                ){

            String addMoreData = "INSERT INTO villains_minions (minion_id, villain_id)\n" +
                    "  VALUE (3, 1),\n" +
                    "  (4, 1),\n" +
                    "  (2, 2),\n" +
                    "  (3, 2),\n" +
                    "  (4, 2);\n";
            statement.execute(addMoreData);

            String selectVillainByNumMinions =
                    "SELECT v.name, COUNT(vm.minion_id) AS minions_count FROM villains AS v" +
                    "  INNER JOIN villains_minions as vm " +
                    "  ON v.id = vm.villain_id" +
                    "    GROUP BY vm.villain_id";
            ResultSet resultSet = statement.executeQuery(selectVillainByNumMinions);
            while (resultSet.next()){
                String name = resultSet.getString(1);
                int minionsNumber = resultSet.getInt(2);
                System.out.println(name + " " + minionsNumber);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

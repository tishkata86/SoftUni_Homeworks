import java.sql.*;
import java.util.Scanner;

public class GetMinionsNames {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int villainId = Integer.parseInt(sc.nextLine());

        try (
                Connection connection = DriverManager.getConnection(
                        InitializeDatabase.URL,
                        InitializeDatabase.USER,
                        InitializeDatabase.PASS);
        ){
            String selectVillainsWithMinions =
                    "SELECT v.name, m.name, m.age  FROM villains AS v\n" +
                            "  LEFT JOIN villains_minions AS vm\n" +
                            "  ON v.id = vm.villain_id\n" +
                            "    LEFT JOIN minions AS m\n" +
                            "    ON vm.minion_id = m.id\n" +
                            "WHERE v.id = ?\n" +
                            "ORDER BY m.age";
            PreparedStatement statement = connection.prepareStatement(selectVillainsWithMinions);
            statement.setInt(1, villainId);
            ResultSet output = statement.executeQuery();
            if (!output.isBeforeFirst() ) {
                System.out.printf("No villain with ID %d exists in the database.", villainId);
            }
            boolean isVillainDisplayed = false;
            int counter = 1;
            String villainName;
            String minionName;
            int minionAge;
            while (output.next()){
                if (!isVillainDisplayed){
                    villainName = output.getString(1);
                    System.out.println("Villain: " + villainName);
                    minionName = output.getString(2);
                    minionAge = output.getInt(3);
                    if (minionName == null){
                        System.out.println("<no minions>");
                        break;
                    }
                    System.out.println((counter++) + ". " + minionName + " " + minionAge);
                    isVillainDisplayed = true;
                } else {
                    minionName = output.getString(2);
                    minionAge = output.getInt(3);
                    System.out.println((counter++) + ". " + minionName + " " + minionAge);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Problem07_FixEmails {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedHashMap<String, String> database = new LinkedHashMap<>();
        String input = sc.nextLine();

        while (!input.contains("stop")) {
            String name = input;
            String email = sc.nextLine();
            String[] emailParts = email.split("\\.");
            if (!emailParts[emailParts.length - 1].equals("us") && !emailParts[emailParts.length - 1].equals("uk")) {
                database.put(name, email);
            }
            input = sc.nextLine();
        }

        for (Map.Entry<String, String> entry : database.entrySet()) {
            System.out.printf("%s -> %s\n", entry.getKey(), entry.getValue());
        }
    }
}

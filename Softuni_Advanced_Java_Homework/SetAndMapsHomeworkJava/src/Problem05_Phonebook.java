import java.util.HashMap;
import java.util.Scanner;

public class Problem05_Phonebook {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        HashMap<String, String> database = new HashMap<>();
        while (!input.equals("search")) {
            String[] details = input.split("-");
            if (details.length > 1) {
                String name = details[0];
                String number = details[1];
                database.put(name, number);
            }
            input = sc.nextLine();
        }
        input = sc.nextLine();
        while (!input.equals("stop")){
            if (database.containsKey(input)){
                System.out.printf("%s -> %s\n", input, database.get(input));
            } else {
                System.out.printf("Contact %s does not exist.\n", input);
            }

            input = sc.nextLine();
        }

    }
}

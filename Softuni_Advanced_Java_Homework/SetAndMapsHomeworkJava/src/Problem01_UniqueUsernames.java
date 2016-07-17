import java.util.LinkedHashSet;
import java.util.Scanner;

public class Problem01_UniqueUsernames {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedHashSet<String> uniqueNames = new LinkedHashSet<>();
        int lines = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < lines; i++) {
            uniqueNames.add(sc.nextLine());
        }

        for (String uniqueName : uniqueNames) {
            System.out.println(uniqueName);
        }
    }
}

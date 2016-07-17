import java.util.Scanner;
import java.util.TreeSet;

public class Problem03_PeriodicTable {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int lines = Integer.parseInt(sc.nextLine());
        TreeSet<String> array = new TreeSet<>();
        for (int i = 0; i < lines; i++) {
            String[] input = sc.nextLine().split("\\s+");
            for (int j = 0; j < input.length; j++) {
                array.add(input[j]);
            }
        }

        for (String element : array) {
            System.out.print(element + " ");
        }
    }
}

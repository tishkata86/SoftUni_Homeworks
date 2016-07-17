import java.util.Scanner;

public class Problem06_CountSubstringOccurrences {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String text = scan.nextLine().toLowerCase();
        String word = scan.nextLine().toLowerCase();
        int lenghtWord = word.length();
        int counter = 0;
        for (int i = 0; i <= text.length() - lenghtWord; i++) {
            if (word.equals(text.substring(i, lenghtWord + i))) {
                counter++;
            }
        }

        System.out.println(counter);
    }
}
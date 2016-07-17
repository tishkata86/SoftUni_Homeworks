import java.util.Scanner;

public class Problem10_UnicodeCharacters {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] text = sc.nextLine().toCharArray();

        for (int i = 0; i < text.length; i++) {
            System.out.print("\\u00" + Integer.toHexString(text[i]));
        }


    }
}

import java.util.Scanner;

public class Problem02_StringLength {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 20; i++) {
            if (i <= text.length() - 1){
                result.append(text.charAt(i));
            } else {
                result.append("*");
            }
        }
        System.out.println(result);
    }
}

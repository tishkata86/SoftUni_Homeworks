import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem01_MatchFullName {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text;
        Pattern pattern = Pattern.compile("[A-Z][a-z]+\\s[A-Z][a-z]+");

        while (!"end".equals(text = sc.nextLine())){
            Matcher matcher = pattern.matcher(text);
            if (matcher.find()){
                System.out.println(text);
            }
        }
    }
}

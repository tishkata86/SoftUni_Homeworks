import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem02_MatchPhoneNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text;
        Pattern firstPattern = Pattern.compile("^(\\s?)(\\+359\\s\\d\\s[\\d]{3}\\s[\\d]{4})\\b");
        Pattern secondPattern = Pattern.compile("^(\\s*?)(\\+359\\-\\d\\-[\\d]{3}\\-[\\d]{4})\\b");

        while (!"end".equals(text = sc.nextLine())){
            Matcher firstMatcher = firstPattern.matcher(text);
            Matcher secondMatcher = secondPattern.matcher(text);
            while (firstMatcher.find()){
                System.out.println(firstMatcher.group(2));
            }
            while (secondMatcher.find()){
                System.out.println(secondMatcher.group(2));
            }
        }
    }
}

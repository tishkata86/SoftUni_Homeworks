import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem03_SeriesOfLetters {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Pattern pattern = Pattern.compile("(.)\\1*");
        String text = sc.nextLine();
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()){
            System.out.print(matcher.group().charAt(0));
        }


    }
}

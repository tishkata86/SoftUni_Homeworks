import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem09_TextFilter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] words = sc.nextLine().split(", ");
        StringBuilder text = new StringBuilder(sc.nextLine());

        for (int i = 0; i < words.length; i++) {
            String searching = words[i];
            String replace = "";
            for (int j = 0; j < searching.length(); j++) {
                replace += "*";
            }
            Pattern pattern = Pattern.compile(searching);
            Matcher matcher = pattern.matcher(text);
            while (matcher.find()) {
                text.replace(matcher.start(), matcher.end(), replace);
            }
        }

        System.out.println(text);
    }
}

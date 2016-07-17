import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem04_ReplaceTag {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Pattern pattern = Pattern.compile("(\\<a)(.+?)(<\\/a>)");
        String text;
        String allText = "";
        while (!"end".equals(text = sc.nextLine())) {
            Matcher matcher = pattern.matcher(text);

            while (matcher.find()) {
                if (matcher.group(2).contains(">")) {
                    String currentString = "";
                    int start = matcher.start(1);
                    int end = matcher.end(3) - 1;
                    String currentMatch = matcher.group(2);
                    if (start > 0) {
                        currentString += text.substring(0, start - 1);
                    }
                    currentString += "[URL";
                    currentString += text.substring(matcher.start(2), matcher.end(2));
                    currentString += "[/URL]";
                    if (end + 1 < text.length()) {
                        currentString += text.substring(end + 1, text.length());
                    }
                    text = currentString;
                }
            }

            allText += text;
        }
        System.out.println(allText);
    }
}

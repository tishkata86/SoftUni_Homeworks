import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem06_SentenceExtractor {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        String word = sc.readLine();
        String text = sc.readLine();
        Pattern pattern = Pattern.compile(String.format("\\b[^.?!]*?\\b%s\\b.*?[!.?]", word));
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            System.out.println(matcher.group(0));
        }


    }
}

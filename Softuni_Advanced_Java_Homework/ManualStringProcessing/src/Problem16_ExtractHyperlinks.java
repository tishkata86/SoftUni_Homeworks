import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem16_ExtractHyperlinks {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> result = new ArrayList<>();
        String line;
        String allText = "";
        while (!"END".equals(line = sc.nextLine())) {
            allText += line;
        }
        Pattern pattern = Pattern.compile("(<a([^>]+)href[\\s]*=\\s*(.*?)</a>)");
        Matcher matcher = pattern.matcher(allText);

        while (matcher.find()) {;
            String match = matcher.group(3);
            StringBuilder sb = new StringBuilder(match);
            String text = "";
            if (match.charAt(0) == '\"') {
                for (int i = 1; i < sb.length(); i++) {
                    if (sb.charAt(i) == '\"') {
                        result.add(text);
                        break;
                    } else {
                        text += sb.charAt(i);
                    }
                }
            } else if (match.charAt(0) == '\'') {
                for (int i = 1; i < sb.length(); i++) {
                    if (sb.charAt(i) == '\'') {
                        result.add(text);
                        break;
                    } else {
                        text += sb.charAt(i);
                    }
                }
            } else {
                for (int i = 0; i < sb.length(); i++) {
                    if (sb.charAt(i) == '>' || sb.charAt(i) == ' ') {
                        result.add(text);
                        break;
                    } else {
                        text += sb.charAt(i);
                    }
                }
            }
        }


        for (String href : result) {
            System.out.println(href);
        }
    }
}

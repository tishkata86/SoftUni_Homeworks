import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem11_SemanticHTML {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Pattern startingPattern = Pattern.compile("(.*?)<(div)(.*?)(id|class)\\s*?=\\s*?\"(header|nav|main|article|section|aside|footer)\"(.*?)>(.*?)");
        Pattern endingPattern = Pattern.compile("(.*?)</div>.*?<!--\\s*?(header|nav|main|article|section|aside|footer)\\s*?-->(.*)");
        String input;

        while (!"END".equals(input = sc.nextLine())) {
            Matcher starting = startingPattern.matcher(input);
            Matcher ending = endingPattern.matcher(input);
            if (starting.find()){
                String group3 =starting.group(3);
                String group5 =starting.group(5);
                String group6 =starting.group(6);
                String output = group5 + group3 + group6;
                output = output.trim();
                output = output.replaceAll("\\s+", " ");
                System.out.printf("%s<%s>\n",starting.group(1) ,output);
            } else if (ending.find()){
                System.out.printf("%s</%s>\n",ending.group(1), ending.group(2));
            } else {
                System.out.println(input);
            }

        }
    }
}

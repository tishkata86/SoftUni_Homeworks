import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem10_UseYourChainsBuddy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String allText = "";
        String result = "";
        Pattern pattern = Pattern.compile("<p>(.*?)</p>");
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()){
            allText += matcher.group(1);
        }

        for (int i = 0; i < allText.length(); i++) {
            if (allText.charAt(i) > 96 && allText.charAt(i) < 110){
                result += (char)(allText.charAt(i) + 13);
            } else if (allText.charAt(i) > 109 && allText.charAt(i) < 123){
                result += (char)(allText.charAt(i) - 13);
            } else if (allText.charAt(i) > 47 && allText.charAt(i) < 58){
                result += allText.charAt(i);
            } else {
                result += " ";
            }
        }

        result = result.replaceAll("\\s+", " ");
        System.out.println(result);

    }
}

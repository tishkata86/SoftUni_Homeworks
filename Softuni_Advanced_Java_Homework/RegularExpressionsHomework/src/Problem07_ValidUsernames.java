import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem07_ValidUsernames {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Pattern pattern = Pattern.compile("(^|\\s|\\\\|/|\\(|\\))([A-Za-z][A-Za-z0-9_]{2,25})\\b");
        String text = sc.nextLine();
        Matcher matcher = pattern.matcher(text);
        List<String> userNames = new ArrayList<>();
        String firstName = "";
        String secondName = "";
        int maxSize = 0;

        while (matcher.find()) {
            userNames.add(matcher.group(2));
        }

        for (int i = 0; i < userNames.size() - 1; i++) {
            int nameOne = userNames.get(i).length();
            int nameTwo = userNames.get(i + 1).length();

            if (nameOne + nameTwo > maxSize){
                maxSize = nameOne + nameTwo;
                firstName = userNames.get(i);
                secondName = userNames.get(i + 1);
            }
        }

        System.out.println(firstName);
        System.out.println(secondName);
    }
}

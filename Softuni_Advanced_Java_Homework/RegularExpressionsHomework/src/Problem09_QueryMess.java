import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem09_QueryMess {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Pattern pattern = Pattern.compile("([^&?]+)=([^&?=]+)");
        LinkedHashMap<String, List<String>> result = new LinkedHashMap<>();
        String input;
        while (!"END".equals(input = sc.nextLine())) {
            StringBuilder text = new StringBuilder(input);
            input = input.replaceAll("%20", " ").replaceAll("\\+", " ");
            Matcher matcher = pattern.matcher(input.toString());
            while (matcher.find()) {
                String pair = matcher.group(1).trim();
                String value = matcher.group(2).trim();
                Pattern newPattern = Pattern.compile("\\s{2,}");

                Matcher newMatcher = newPattern.matcher(pair);
                if (newMatcher.find()){
                    pair = pair.replaceAll("\\s{2,}", " ");
                }

                newMatcher = newPattern.matcher(value);
                if (newMatcher.find()){
                    value = value.replaceAll("\\s{2,}", " ");
                }

                if (!result.containsKey(pair)) {
                    result.put(pair, new ArrayList<>());
                }
                result.get(pair).add(value);
            }

            for (String pairs : result.keySet()) {
                System.out.print(pairs + "=");
                System.out.print(result.get(pairs));
            }
            System.out.println();
            result = new LinkedHashMap<>();
        }
    }
}

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem13_SrabskoUnleashed {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Pattern pattern = Pattern.compile("([A-Za-z\\s]+)\\s@([A-Za-z\\s]+)\\s([0-9]+)\\s([0-9]+)");
        LinkedHashMap<String, LinkedHashMap<String, Integer>> data = new LinkedHashMap<>();
        String input = sc.nextLine();

        while (!input.equals("End")) {
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                String singer = matcher.group(1);
                String venue = matcher.group(2);
                Integer ticketPrice = Integer.parseInt(matcher.group(3));
                Integer ticketCount = Integer.parseInt(matcher.group(4));
                int totalPrice = ticketPrice * ticketCount;

                if (!data.containsKey(venue)) {
                    data.put(venue, new LinkedHashMap<>());
                    data.get(venue).put(singer, totalPrice);
                } else {
                    if (!data.get(venue).containsKey(singer)) {
                        data.get(venue).put(singer, totalPrice);
                    } else {
                        int oldValue = data.get(venue).get(singer);
                        data.get(venue).put(singer, oldValue + totalPrice);
                    }
                }
            }
            input = sc.nextLine();
        }

        data.entrySet().stream().forEach(entry -> {
            System.out.println(entry.getKey());
            entry.getValue().entrySet().stream().sorted((s1, s2) -> s2.getValue().compareTo(s1.getValue())).forEach(singer -> {
                System.out.println("#  " + singer.getKey() + " -> " + singer.getValue());
            });
        });
    }
}

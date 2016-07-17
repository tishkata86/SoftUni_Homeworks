import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class Problem11_LogsAggregator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int lines = Integer.parseInt(sc.nextLine());
        TreeMap<String, Integer> userDuration = new TreeMap<>();
        TreeMap<String, TreeSet<String >> userIps = new TreeMap<>();
        for (int i = 0; i < lines; i++) {
            String[] input = sc.nextLine().split(" ");
            String user = input[1];
            String ip = input[0];
            int duration = Integer.parseInt(input[2]);

            if (!userIps.containsKey(user)){
                userIps.put(user, new TreeSet<>());
                userIps.get(user).add(ip);
                userDuration.put(user, duration);
            } else {
                int oldValue = userDuration.get(user);
                userDuration.put(user, oldValue + duration);
                userIps.get(user).add(ip);
            }
        }

        for (String user : userDuration.keySet()) {
            System.out.print(user + ": " + userDuration.get(user) + " ");
            System.out.print(userIps.get(user));
            System.out.println();
        }

    }
}

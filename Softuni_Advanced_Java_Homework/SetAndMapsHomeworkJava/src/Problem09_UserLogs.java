import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Problem09_UserLogs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeMap<String, LinkedHashMap<String, Integer>> data = new TreeMap<>();
        String input = sc.nextLine();

        while (!input.equals("end")){
            String[] params = input.split("=");
            String[] tempIp = params[1].split(" ");
            String ip = tempIp[0];
            String username = params[3];

            if (!data.containsKey(username)){
                data.put(username, new LinkedHashMap<>());
                data.get(username).put(ip, new Integer(1));
            } else {
                if (!data.get(username).containsKey(ip)){
                    data.get(username).put(ip, new Integer(1));
                } else {
                    int oldValue = data.get(username).get(ip);
                    data.get(username).put(ip, oldValue + 1);
                }
            }

            input = sc.nextLine();
        }

        for (Map.Entry<String, LinkedHashMap<String, Integer>> usernameEntry : data.entrySet()) {
            System.out.println(usernameEntry.getKey() + ": ");
            LinkedHashMap<String, Integer> values = usernameEntry.getValue();
            boolean isFirst = true;
            for (Map.Entry<String, Integer> ipEntry : values.entrySet()) {
                if (isFirst){
                    System.out.printf("%s => %d", ipEntry.getKey(), ipEntry.getValue());
                    isFirst = false;
                } else {
                    System.out.printf(", %s => %d", ipEntry.getKey(), ipEntry.getValue());
                }
            }
            System.out.print(".");
            System.out.println();
        }
    }
}

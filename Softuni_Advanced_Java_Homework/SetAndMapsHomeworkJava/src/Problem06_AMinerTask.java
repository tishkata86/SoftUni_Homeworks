import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Problem06_AMinerTask {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        LinkedHashMap<String, Long> resources = new LinkedHashMap<>();

        while (!input.equals("stop")){
            String resource = input;
            long quantitie = Long.parseLong(sc.nextLine());
            if (!resources.containsKey(resource)){
                resources.put(resource, quantitie);
            } else {
                Long oldValue = resources.get(resource);
                resources.put(resource, oldValue + quantitie);
            }

            input = sc.nextLine();
        }

        for (Map.Entry<String, Long> entry : resources.entrySet()) {
            System.out.printf("%s -> %d\n", entry.getKey(), entry.getValue());
        }
    }
}

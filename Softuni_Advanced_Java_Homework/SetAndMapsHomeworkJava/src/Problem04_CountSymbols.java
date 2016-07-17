import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Problem04_CountSymbols {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        TreeMap<Character, Integer> db = new TreeMap<>();
        for (int i = 0; i < text.length(); i++) {
            if (!db.containsKey(text.charAt(i))){
                db.put(text.charAt(i), new Integer(1));
            } else {
                int oldNum = db.get(text.charAt(i));
                db.put(text.charAt(i), oldNum + 1);
            }
        }

        for (Map.Entry<Character, Integer> entry : db.entrySet()) {
            System.out.printf("%s: %d time/s\n",entry.getKey(), entry.getValue());
        }
    }
}

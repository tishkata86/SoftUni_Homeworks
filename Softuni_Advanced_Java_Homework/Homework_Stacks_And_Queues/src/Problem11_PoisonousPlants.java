import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem11_PoisonousPlants {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        int allPlants = Integer.parseInt(sc.readLine());
        int[] plants = Arrays.stream(sc.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] days = new int[allPlants];
        Stack<Integer> proximityStack = new Stack<>();
        proximityStack.push(0);
        for (int i = 1; i < plants.length; i++) {
            int maxDays = 0;
            while (proximityStack.size() > 0 && plants[proximityStack.peek()] >= plants[i]) {
                maxDays = Math.max(maxDays, days[proximityStack.pop()]);
            }

            if (proximityStack.size() > 0) {
                days[i] = maxDays + 1;
            }

            proximityStack.push(i);
        }
        int max = 0;
        for (int day : days) {
            if (day > max){
                max = day;
            }
        }
        System.out.println(max);
    }
}

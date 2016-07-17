import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class Problem04_FindEvenOrOdd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] commands = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        List<Integer> numbers = new ArrayList<>();
        for (int i = commands[0]; i <= commands[1]; i++) {
            numbers.add(i);
        }
        Predicate<Integer> odd = num -> num % 2 != 0;
        Predicate<Integer> even = num -> num % 2 == 0;
        switch (sc.nextLine()) {
            case "odd":
                for (int i = 0; i < numbers.size(); i++) {
                    if (odd.test(numbers.get(i))){
                        System.out.print(numbers.get(i) + " ");
                    }
                }
                break;
            case "even":
                for (int i = 0; i < numbers.size(); i++) {
                    if (even.test(numbers.get(i))){
                        System.out.print(numbers.get(i) + " ");
                    }
                }
                break;
        }
    }
}

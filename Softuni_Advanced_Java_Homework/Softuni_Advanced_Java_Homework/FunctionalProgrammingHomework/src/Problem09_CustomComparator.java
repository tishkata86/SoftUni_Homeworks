import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.function.Predicate;

public class Problem09_CustomComparator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Predicate<Integer> isOdd = num -> num % 2 != 0;
        Predicate<Integer> isEven = num -> num % 2 == 0;
        int[] numbers = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        numbers = Arrays.stream(numbers).sorted().toArray();
        for (int i = 0; i < numbers.length; i++) {
            if (isEven.test(numbers[i])){
                System.out.print(numbers[i] + " ");
            }
        }
        for (int i = 0; i < numbers.length; i++) {
            if (isOdd.test(numbers[i])){
                System.out.print(numbers[i] + " ");
            }
        }

    }
}

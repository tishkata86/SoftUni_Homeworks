import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;

public class Problem03_CustomMinFunction {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        Integer[] numbers = new Integer[input.length];
        for (int i = 0; i < input.length; i++) {
            numbers[i] = Integer.parseInt(input[i]);
        }
        Function<Integer[], Integer> findMin = array -> {
            int min = array[0];
            for (int i = 1; i < array.length; i++) {
                if (array[i] < min) {
                    min = array[i];
                }
            }
            return min;
        };
        System.out.println(findMin.apply(numbers));

    }
}

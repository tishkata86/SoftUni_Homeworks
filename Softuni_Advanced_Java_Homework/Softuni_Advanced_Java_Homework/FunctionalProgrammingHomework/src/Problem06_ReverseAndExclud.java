import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Problem06_ReverseAndExclud {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split("\\s+");
        Integer[] numbers = new Integer[input.length];
        for (int i = 0; i < input.length; i++) {
            numbers[i] = Integer.parseInt(input[i]);
        }

        int dividedNumber = sc.nextInt();
        sc.nextLine();

        numbers = Reverse(numbers);
        for (Integer number : numbers) {
            if (IsDivide(number, dividedNumber)){
                System.out.print(number + " ");
            }
        }
        System.out.println();
    }

    private static boolean IsDivide(Integer number, int divide) {
        Predicate<Integer> isDivideWithThree = num -> num % divide != 0;
        return isDivideWithThree.test(number);
    }

    private static Integer[] Reverse(Integer[] nums) {
        Function<Integer[], Integer[]> reverse = array -> {
            int counter = 0;
            Integer[] reversedArray = new Integer[array.length];
            for (int i = array.length - 1; i >= 0; i--) {
                reversedArray[counter++] = array[i];
            }
            return reversedArray;
        };
        return reverse.apply(nums);
    }
}

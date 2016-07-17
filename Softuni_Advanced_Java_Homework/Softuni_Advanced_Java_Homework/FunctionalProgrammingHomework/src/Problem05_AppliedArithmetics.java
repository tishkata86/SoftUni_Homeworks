import java.util.Scanner;
import java.util.function.Function;

public class Problem05_AppliedArithmetics {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split("\\s+");
        Integer[] numbers = new Integer[input.length];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(input[i]);
        }

        String newLine;
        while (!"end".equals(newLine = sc.nextLine())) {
            switch (newLine) {
                case "add":
                    Adding(numbers);
                    break;
                case "multiply":
                    Multiply(numbers);
                    break;
                case "subtract":
                    Subtract(numbers);
                    break;
                case "print":
                    for (int i = 0; i < numbers.length; i++) {
                        System.out.print(numbers[i] + " ");
                    }
                    System.out.println();
                    break;
            }

        }

    }

    private static Integer[] Subtract(Integer[] nums) {
        Function<Integer[], Integer[]> subtract = numbers -> {
            for (int i = 0; i < numbers.length; i++) {
                numbers[i]--;
            }
            return numbers;
        };
        return subtract.apply(nums);
    }

    private static Integer[] Multiply(Integer[] nums) {
        Function<Integer[], Integer[]> multiply = numbers -> {
            for (int i = 0; i < numbers.length; i++) {
                numbers[i] *= 2;
            }
            return numbers;
        };
        return multiply.apply(nums);
    }

    private static Integer[] Adding(Integer[] nums) {
        Function<Integer[], Integer[]> add = numbers -> {
            for (int i = 0; i < numbers.length; i++) {
                numbers[i]++;
            }
            return numbers;
        };
        return add.apply(nums);
    }
}

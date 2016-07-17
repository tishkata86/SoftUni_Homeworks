import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

public class Problem08_FindSmallestElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split("\\s+");
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < input.length; i++) {
            numbers.add(Integer.parseInt(input[i]));
        }

        System.out.println(FindMinPosition(numbers));
    }

    private static int FindMinPosition(List<Integer> numbers) {
        Function<List<Integer>, Integer> findMin = array -> {
            int min = 0;
            for (int i = 1; i < array.size(); i++) {
                if (array.get(i) <= array.get(i - 1)){
                    min = i;
                }
            }
            return min;
        };
        return findMin.apply(numbers);
    }
}

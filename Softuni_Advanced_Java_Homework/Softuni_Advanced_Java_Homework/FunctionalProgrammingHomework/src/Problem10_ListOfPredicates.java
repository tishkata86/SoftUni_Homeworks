import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class Problem10_ListOfPredicates {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int endNum = sc.nextInt();
        sc.nextLine();
        List<Integer> allNumbers = new ArrayList<>();
        for (int i = 1; i <= endNum; i++) {
            allNumbers.add(i);
        }
        int[] numberForDivide = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        List<Integer> theArray = new ArrayList<>();
        for (int i = 0; i < numberForDivide.length; i++) {
            int divide = numberForDivide[i];
            Predicate<Integer> isDivide = num -> num % divide == 0;
            List<Integer> tempArray = new ArrayList<>();
            for (int j = 0; j < allNumbers.size(); j++) {
                if (isDivide.test(allNumbers.get(j))){
                    tempArray.add(allNumbers.get(j));
                }
            }

            allNumbers = new ArrayList<>(tempArray);
        }

        for (Integer allNumber : allNumbers) {
            System.out.print(allNumber + " ");
        }

    }
}

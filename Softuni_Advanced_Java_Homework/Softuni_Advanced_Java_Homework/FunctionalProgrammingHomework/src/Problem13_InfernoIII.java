import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;

public class Problem13_InfernoIII {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split("\\s+");
        List<Integer> numbers = new ArrayList<>();
        for (String s : input) {
            numbers.add(Integer.parseInt(s));
        }
        List<Integer> tempNums = new ArrayList<>();
        Stack<List<Integer>> stackNumbers = new Stack<>();
        stackNumbers.push(numbers);

        String line;
        while (!"Forge".equals(line = sc.nextLine())) {
            String[] commands = line.split(";");
            if (commands.length > 2) {
                String excludeOrReverse = commands[0];
                String sumType = commands[1];
                int variable = Integer.parseInt(commands[2]);

                if (excludeOrReverse.equals("Exclude")) {
                    tempNums = CalculatePositions(numbers, sumType, variable);
                    stackNumbers.push(tempNums);
                } else {
                    stackNumbers.pop();
                    tempNums = stackNumbers.peek();
                }
            }
        }
        for (Integer tempNum : tempNums) {
            System.out.print(tempNum + " ");
        }
    }

    private static List<Integer> CalculatePositions(List<Integer> numbers, String sumType, int variable) {
        List<Integer> array = new ArrayList<>();

        for (int i = 0; i < numbers.size(); i++) {
            switch (sumType) {
                case "Sum Left":
                    if (i > 0) {
                        if (numbers.get(i) + numbers.get(i - 1) == variable) {
                            array.add(numbers.get(i - 1));
                        }
                    }
                    break;
                case "Sum Right":
                    if (i < numbers.size() - 1) {
                        if (numbers.get(i) + numbers.get(i + 1) == variable) {
                            array.add(numbers.get(i));
                        }
                    }
                    break;
                case "Sum Left Right":
                    if (i == 0) {
                        if (numbers.get(i) + numbers.get(i + 1) == variable) {
                            array.add(numbers.get(i));
                        }
                    } else if (i == numbers.size() - 1) {
                        if (numbers.get(i) + numbers.get(i - 1) == variable) {
                            array.add(numbers.get(i - 1));
                        }
                    } else {
                        if (numbers.get(i - 1) + numbers.get(i) + numbers.get(i + 1) == variable) {
                            array.add(numbers.get(i - 1));
                        }
                    }
                    break;
            }
        }

        return array;
    }


}

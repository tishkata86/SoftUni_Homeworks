import java.util.ArrayDeque;
import java.util.Scanner;

public class Problem08_RecursiveFibonacci {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int number = Integer.parseInt(sc.nextLine());
        long firstNum = 1;
        long secondNum = 1;
        ArrayDeque<Long> array = new ArrayDeque<>();
        array.add(firstNum);
        array.add(secondNum);

        for (int i = 1; i < number; i++) {
            array.add(firstNum + secondNum);
            array.removeFirst();
            firstNum = secondNum;
            secondNum = array.getLast();
        }

        System.out.println(array.getLast());
    }
}

import java.math.BigDecimal;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Problem05_Calculate_Sequence_With_Queue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = Integer.parseInt(sc.nextLine());
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.addFirst(N);
        for (int i = 0; i < 16; i++) {
            int first = N + 1;
            int second = 2 * N + 1;
            int third = N + 2;

            deque.addLast(first);
            deque.addLast(second);
            deque.addLast(third);
            System.out.print(N + " " + first + " " + second + " " + third + " ");
            deque.pollFirst();

        }

        System.out.println(N + 1);

    }
}

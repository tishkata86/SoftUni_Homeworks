import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Problem04_Basic_Queue_Operations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] params = sc.nextLine().split(" ");
        int lines = Integer.parseInt(params[0]);
        int remove = Integer.parseInt(params[1]);
        int isInQueue = Integer.parseInt(params[2]);
        Queue<Integer> array = new LinkedList<>();

        for (int i = 0; i < lines; i++) {
            array.add(sc.nextInt());
        }

        for (int i = 0; i < remove; i++) {
            array.poll();
        }

        if (array.contains(isInQueue)) {
            System.out.println("true");
        } else {
            int min = 0;
            if (array.size() > 0) {
                min = array.peek();
                for (Integer integer : array) {
                    min = Integer.min(integer, min);
                }
            }
            System.out.println(min);
        }
    }
}

import java.util.Scanner;
import java.util.Stack;

public class Problem03_Maximum_Element {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> array = new Stack<>();
        Stack<Integer> maxove = new Stack<>();
        int lines = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < lines; i++) {
            String[] commands = sc.nextLine().split(" ");

            switch (commands[0]) {
                case "1":
                    int num = Integer.parseInt(commands[1]);
                    array.push(num);
                    if (maxove.empty()){
                        maxove.push(num);
                    } else {
                        if (num > maxove.peek()){
                            maxove.push(num);
                        }
                    }
                    break;
                case "2":
                    if (maxove.peek() == array.peek()){
                        maxove.pop();
                    }
                    array.pop();

                    break;
                case "3":
                    System.out.println(maxove.peek());
                    break;
            }
        }
    }
}

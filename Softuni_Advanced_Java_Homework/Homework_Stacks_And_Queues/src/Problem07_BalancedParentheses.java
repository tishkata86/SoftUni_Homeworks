import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Problem07_BalancedParentheses {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        boolean isTrue = true;
        ArrayDeque<Character> array = new ArrayDeque<>();
        String input = sc.nextLine();

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '(' || input.charAt(i) == '[' || input.charAt(i) == '{') {
                array.add(input.charAt(i));
            } else if (input.charAt(i) == ')' || input.charAt(i) == ']' || input.charAt(i) == '}') {
                if (array.isEmpty()) {
                    isTrue = false;
                    break;
                }
                switch (input.charAt(i)) {
                    case ')':
                        if (array.getLast() == '(') {
                            array.removeLast();
                        } else {
                            isTrue = false;
                        }
                        break;
                    case ']':
                        if (array.getLast() == '[') {
                            array.removeLast();
                        } else {
                            isTrue = false;
                        }
                        break;
                    case '}':
                        if (array.getLast() == '{') {
                            array.removeLast();
                        } else {
                            isTrue = false;
                        }
                        break;
                }
            } else {
                isTrue = false;
            }
        }


        if (isTrue) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}

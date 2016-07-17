import java.util.Scanner;
import java.util.Stack;

public class Problem01_ReverseNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] stringInput = input.split(" ");
        Stack<Integer> intArray = new Stack<>();
        for (int i = 0; i < stringInput.length; i++) {
            intArray.add(Integer.parseInt(stringInput[i]));
        }
        int size = intArray.size();
        for (int i = 0; i < size; i++) {
            System.out.print(intArray.pop() + " ");
        }
    }
}

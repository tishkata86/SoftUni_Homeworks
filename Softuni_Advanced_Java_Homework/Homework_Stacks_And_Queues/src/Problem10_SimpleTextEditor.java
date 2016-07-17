import java.util.Scanner;
import java.util.Stack;

public class Problem10_SimpleTextEditor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int lines = Integer.parseInt(sc.nextLine());
        String text = "";
        Stack<String> strings = new Stack<>();

        for (int i = 0; i < lines; i++) {
            String[] input = sc.nextLine().split("\\s+");
            switch (input[0]) {
                case "1":
                    if (!strings.isEmpty()) {
                        text = strings.peek();
                    } else {
                        text = "";
                    }
                    text += input[1];
                    strings.push(text);
                    break;

                case "2":
                    int count = Integer.parseInt(input[1]);
                    if (!strings.isEmpty()) {
                        text = strings.peek();
                    } else {
                        text = "";
                    }

                    String newText = "";
                    if (count < 0) {
                        strings.push(text);
                    } else if (count > text.length()) {
                        strings.push(newText);
                    } else {
                        int textLenght = text.length() - count;
                        for (int j = 0; j < textLenght; j++) {
                            newText += text.charAt(j);
                        }
                        strings.push(newText);
                    }
                    break;

                case "3":
                    if (!strings.isEmpty()) {
                        text = strings.peek();
                        int index = Integer.parseInt(input[1]) - 1;
                        if (index >= 0 && index < text.length()) {
                            System.out.println(text.charAt(index));
                        }
                    }
                    break;

                case "4":
                    strings.pop();
                    break;
            }

        }
    }

}
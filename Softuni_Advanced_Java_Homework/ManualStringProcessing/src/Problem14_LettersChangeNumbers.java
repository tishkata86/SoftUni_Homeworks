import java.util.Scanner;

public class Problem14_LettersChangeNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double totalSum = 0.0;
        StringBuilder stringBuilder = new StringBuilder();
        String input = sc.nextLine().trim();
        String[] texts = input.split("\\s+");

        for (int i = 0; i < texts.length; i++) {
            Character firstLetter = texts[i].charAt(0);
            Character lastLetter = texts[i].charAt(texts[i].length() - 1);
            stringBuilder.append(texts[i]);
            double number = Double.parseDouble(stringBuilder.substring(1, texts[i].length() - 1).toString());
            double sum = number;

            if (firstLetter > 96 && firstLetter < 123){
                sum *= firstLetter - 96;
            } else {
                sum /= firstLetter - 64;
            }

            if (lastLetter > 96 && lastLetter < 123){
                sum += lastLetter - 96;
            } else {
                sum -= lastLetter - 64;
            }

            totalSum += sum;
            stringBuilder = new StringBuilder();
        }

        System.out.printf("%.2f\n", totalSum);
    }
}

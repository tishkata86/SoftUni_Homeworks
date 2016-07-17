import java.util.Scanner;

public class Problem07_SumBigNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder first = new StringBuilder(sc.nextLine()).reverse();
        StringBuilder second = new StringBuilder(sc.nextLine()).reverse();
        StringBuilder result = new StringBuilder();

        if (first.length() > second.length()) {
            CalcBigNumber(first, second, result);
        } else {
            CalcBigNumber(second, first, result);
        }

        result.reverse();
        boolean isTrue = false;
        int size = result.length();
        for (int i = 0; i < size; i++) {
            if (result.charAt(0) == '0' && isTrue == false){
                result.deleteCharAt(0);
            } else {
                isTrue = true;
            }
        }
        System.out.println(result);
    }

    private static StringBuilder CalcBigNumber(StringBuilder first, StringBuilder second, StringBuilder result) {
        int resultNumber = 0;
        int reminder = 0;
        for (int i = 0; i < second.length(); i++) {
            if (reminder == 1) {
                resultNumber++;
                reminder = 0;
            }
            int firstNum = Character.getNumericValue(first.charAt(i));
            int secondNum = Character.getNumericValue(second.charAt(i));
            resultNumber += firstNum + secondNum;
            reminder = resultNumber / 10;
            resultNumber %= 10;
            result.append(resultNumber);

            resultNumber = 0;
        }
        for (int i = second.length(); i < first.length(); i++) {
            int firstNum = Character.getNumericValue(first.charAt(i));
            if (reminder == 1) {
                resultNumber++;
                reminder = 0;
            }
            resultNumber += firstNum;
            reminder = resultNumber / 10;
            resultNumber %= 10;
            result.append(resultNumber);
            resultNumber = 0;
        }
        if (reminder == 1) {
            result.append(reminder);
        }
        return result;
    }
}

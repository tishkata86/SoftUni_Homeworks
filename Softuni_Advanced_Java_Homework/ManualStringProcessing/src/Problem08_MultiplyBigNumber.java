import java.util.Scanner;

public class Problem08_MultiplyBigNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder number = new StringBuilder(sc.nextLine()).reverse();
        int multiplier = Integer.parseInt(sc.nextLine());
        int reminder = 0;
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < number.length(); i++) {
            int summedNum = 0;
            if (reminder > 0){
                summedNum += reminder;
            }
            int num = Character.getNumericValue(number.charAt(i));
            summedNum += num * multiplier;
            reminder = summedNum / 10;
            summedNum %= 10;
            result.append(summedNum);
        }

        if (reminder > 0){
            result.append(reminder);
        }

        result.reverse();
        boolean isTrue = false;
        int size = result.length();
        for (int i = 0; i < size; i++) {
            if (result.charAt(0) == '0' && isTrue == false){
                result.deleteCharAt(0);
                if (i == size - 1){
                    result.append(0);
                }
            } else {
                isTrue = true;
            }
        }
        System.out.println(result);
    }
}

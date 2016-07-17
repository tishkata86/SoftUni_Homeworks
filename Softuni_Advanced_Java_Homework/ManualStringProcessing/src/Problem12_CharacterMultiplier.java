import java.util.Scanner;

public class Problem12_CharacterMultiplier {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] text = sc.nextLine().split("\\s+");
        String first = text[0];
        String second = text[1];
        int totalSum = 0;
        if (first.length() > second.length()){
            totalSum = Calc(first, second, totalSum);
        } else {
           totalSum = Calc(second, first, totalSum);
        }
        System.out.println(totalSum);
    }

    private static int Calc(String biggerString, String smallerString, int totalSum) {
        for (int i = 0; i < smallerString.length(); i++) {
            totalSum += biggerString.charAt(i) * smallerString.charAt(i);
        }
        for (int i = smallerString.length(); i < biggerString.length(); i++) {
            totalSum += biggerString.charAt(i);
        }
        return totalSum;
    }
}

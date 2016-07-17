import java.util.Scanner;

public class Problem03_FormattingNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int firstNum = sc.nextInt();
        String firstNumAsBinary =  Integer.toBinaryString(firstNum);
        String printBinary = "";
        if (firstNumAsBinary.length() > 10){
            for (int i = 0; i < 10; i++) {
                printBinary += firstNumAsBinary.charAt(i);
            }
        } else {
            for (int i = 0; i < 10 - firstNumAsBinary.length(); i++) {
                printBinary += "0";
            }
            printBinary += firstNumAsBinary;
        }
        double secondNum = sc.nextDouble();
        double thirdNum = sc.nextDouble();

        System.out.printf("|%-10s|%10s|%10.2f|%-10.3f|",
                Integer.toHexString(firstNum).toUpperCase(),
                firstNumAsBinary,
                secondNum,
                thirdNum);
    }
}

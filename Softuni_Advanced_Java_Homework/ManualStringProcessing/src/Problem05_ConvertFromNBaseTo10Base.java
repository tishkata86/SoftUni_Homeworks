import java.math.BigInteger;
import java.util.Scanner;

public class Problem05_ConvertFromNBaseTo10Base {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BigInteger base = sc.nextBigInteger();
        BigInteger num = sc.nextBigInteger();
        sc.nextLine();
        BigInteger result = new BigInteger("0");
        BigInteger counter = new BigInteger("1");
        BigInteger ten = new BigInteger("10");

        result = result.add(num.remainder(ten));
        num = num.divide(ten);

        while (!num.equals(new BigInteger("0"))){
            BigInteger reminder = num.remainder(ten);
            counter = counter.multiply(base);
            result = result.add(reminder.multiply(counter));
            num = num.divide(ten);
        }
        System.out.println(result);
    }
}

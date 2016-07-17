import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Scanner;

public class Problem04_ConvertFrom10ToNBase {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BigInteger base = sc.nextBigInteger();
        BigInteger num = sc.nextBigInteger();
        sc.nextLine();
        StringBuilder result = new StringBuilder();

        while (!num.equals(new BigInteger("0"))){
            result.append(num.remainder(base));
            num = num.divide(base);
        }

        System.out.println(result.reverse());
    }
}

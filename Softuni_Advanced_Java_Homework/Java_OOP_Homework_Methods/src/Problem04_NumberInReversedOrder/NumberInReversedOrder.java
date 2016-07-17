package Problem04_NumberInReversedOrder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NumberInReversedOrder {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        String number = sc.readLine();
        DecimalNumber reverse = new DecimalNumber(number);
        System.out.println(reverse.ReversedOrder());
    }
}

class DecimalNumber{
    String number;

    public DecimalNumber(String number) {
        this.number = number;
    }

    public String ReversedOrder(){
        StringBuilder result = new StringBuilder();
        for (int i = this.number.length() - 1; i >= 0; i--) {
            result.append(this.number.charAt(i));
        }
        return result.toString();
    }
}
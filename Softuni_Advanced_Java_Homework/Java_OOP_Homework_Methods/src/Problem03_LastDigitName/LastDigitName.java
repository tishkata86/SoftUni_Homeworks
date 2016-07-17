package Problem03_LastDigitName;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LastDigitName {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        long number = Long.parseLong(sc.readLine());
        Number stringNumber = new Number(number);
        System.out.println(stringNumber.LastDigit());
    }
}

class Number {
    long num;

    public Number(long num) {
        this.num = num;
    }

    public String LastDigit() {
        long longValue = this.num % 10;
        int lastNumber = (int)longValue;
        String numberInString = "";
        switch (lastNumber) {
            case 0:
                numberInString = "zero";
                break;
            case 1:
                numberInString = "one";
                break;
            case 2:
                numberInString = "two";
                break;
            case 3:
                numberInString = "three";
                break;
            case 4:
                numberInString = "four";
                break;
            case 5:
                numberInString = "five";
                break;
            case 6:
                numberInString = "six";
                break;
            case 7:
                numberInString = "seven";
                break;
            case 8:
                numberInString = "eight";
                break;
            case 9:
                numberInString = "nine";
                break;
        }

        return numberInString;
    }
}
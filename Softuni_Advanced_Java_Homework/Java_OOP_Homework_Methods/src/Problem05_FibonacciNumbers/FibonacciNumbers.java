package Problem05_FibonacciNumbers;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class FibonacciNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        int startPosition = Integer.parseInt(sc.readLine());
        int endPosition = Integer.parseInt(sc.readLine());
        Fibonacci numbers = new Fibonacci();
        ArrayList<Long> result = numbers.getNumbersInRange(startPosition, endPosition);
        boolean isFirst = true;
        for (Long aLong : result) {
            if (isFirst){
                System.out.print(aLong);
                isFirst = false;
            } else {
                System.out.print(", " + aLong);
            }
        }
        System.out.println();
    }
}

class Fibonacci {
    ArrayList<Long> numbers;

    public Fibonacci() {
        this.numbers = new ArrayList<>();
    }

    public ArrayList<Long> getNumbersInRange(int startPosition, int endPosition) {
        ArrayList<Long> resultList = new ArrayList<>();
        long oldValue = 0;
        long newValue = 1;
        this.numbers.add(0l);
        for (long i = 0; i < endPosition - 1; i++) {
            long temp = newValue;
            newValue += oldValue;
            oldValue = temp;
            this.numbers.add(oldValue);
        }

        for (int i = startPosition; i < endPosition; i++) {
            resultList.add(this.numbers.get(i));
        }

        return resultList;
    }
}

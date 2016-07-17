package Problem06_PrimeChecker;

import com.sun.org.apache.bcel.internal.classfile.ClassFormatException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PrimeChecker {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(sc.readLine());
        Number currentNumber = new Number(number, false);
        Number nextPrime = currentNumber.nextPrime();
        System.out.println(nextPrime.number + ", " + currentNumber.prime);


        Field[] fields = Number.class.getDeclaredFields();

        List<Field> filedsDeclared = Arrays.stream(fields)
                .filter(f -> f.getName().contains("prime") || f.getName().contains("number"))
                .collect(Collectors.toList());

        List<Constructor<?>> constructors = Arrays.stream(Number.class.getDeclaredConstructors())
                .filter(c -> c.getParameterCount() > 1)
                .collect(Collectors.toList());

        if (filedsDeclared.size() <= 1 || constructors.size() < 1) {
            throw new ClassFormatException();
        }

    }
}

class Number{
    int number;
    boolean prime;

    public Number(int number, boolean prime) {
        this.number = number;
        this.prime = isPrimeNumber(this.number);
    }

    boolean isPrimeNumber(int number){
        int counter = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0){
                counter++;
            }
        }

        if (counter <= 2){
            return true;
        } else {
            return false;
        }
    }

    public Number nextPrime(){
        int currentNumber = this.number;
        currentNumber++;
        Number newNumber = new Number(currentNumber, false);
        while (newNumber.prime == false){
            currentNumber++;
            newNumber = new Number(currentNumber, false);
        }
        return newNumber;
    }
}
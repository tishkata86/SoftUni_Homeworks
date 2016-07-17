package Problem07_BasicMath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BasicMath {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while (!"End".equals(line = sc.readLine())){
            String[] params = line.split("\\s+");
            double first = Double.parseDouble(params[1]);
            double second = Double.parseDouble(params[2]);

            switch (params[0]){
                case "Sum":
                    System.out.printf("%.2f\n", MathUtil.Sum(first, second));
                    break;
                case "Subtract":
                    System.out.printf("%.2f\n", MathUtil.Subtract(first, second));
                    break;
                case "Multiply":
                    System.out.printf("%.2f\n", MathUtil.Multiply(first, second));
                    break;
                case "Divide":
                    System.out.printf("%.2f\n", MathUtil.Divide(first, second));
                    break;
                case "Percentage":
                    System.out.printf("%.2f\n", MathUtil.Percentage(first, second));
                    break;
            }
        }

    }
}

class MathUtil {

    public static double Sum(double first, double second) {
        return first + second;
    }

    public static double Subtract(double first, double second) {
        return first - second;
    }

    public static double Multiply(double first, double second) {
        return first * second;
    }

    public static double Divide(double first, double second) {
        return first / second;
    }

    public static double Percentage(double first, double second) {
        return (first / 100) * second;
    }
}
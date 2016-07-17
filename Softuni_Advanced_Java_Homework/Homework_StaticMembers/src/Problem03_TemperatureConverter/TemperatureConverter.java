package Problem03_TemperatureConverter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TemperatureConverter {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while (!"End".equals(line = sc.readLine())) {
            String[] params = line.split("\\s+");
            switch (params[1]) {
                case "Celsius":
                    System.out.printf("%.2f Fahrenheit\n", CalculateTemperature.toFahrenheit(Integer.parseInt(params[0])));
                    break;
                case "Fahrenheit":
                    System.out.printf("%.2f Celsius\n", CalculateTemperature.toCelsius(Integer.parseInt(params[0])));
                    break;
            }
        }

    }
}

class CalculateTemperature {

    public static double toFahrenheit(int value) {
        return ((9.0 * value) / 5.0) + 32.0;
    }

    public static double toCelsius(int value) {
        return ((value - 32.0) * 5.0) / 9.0;
    }
}
package Problem07_CarSalesman;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        int enginesNumber = Integer.parseInt(sc.readLine());
        LinkedList<Engine> engines = new LinkedList<>();
        LinkedList<Car> cars = new LinkedList<>();
        for (int i = 0; i < enginesNumber; i++) {
            String[] params = sc.readLine().split("\\s+");

            String model = params[0];
            int power = Integer.parseInt(params[1]);

            if (params.length == 3) {
                if (Character.isDigit(params[2].charAt(0))){
                    int displacement = Integer.parseInt(params[2]);
                    engines.add(new Engine(model, power, displacement));
                } else {
                    String efficiency = params[2];
                    engines.add(new Engine(model, power, efficiency));
                }
            } else if (params.length == 4){
                int displacement = Integer.parseInt(params[2]);
                String efficiency = params[3];
                engines.add(new Engine(model, power, displacement, efficiency));
            } else {
                engines.add(new Engine(model, power));
            }
        }

        int carsNumber = Integer.parseInt(sc.readLine());
        for (int i = 0; i < carsNumber; i++) {
            String params[] = sc.readLine().split("\\s+");

            String model = params[0];
            String engine = params[1];

            Engine currentEngine = null;
            for (Engine engine1 : engines) {
                if (engine1.model.equals(engine)){
                    currentEngine = engine1;
                }
            }

            if (params.length == 3){
                if (Character.isDigit(params[2].charAt(0))){
                    int weight = Integer.parseInt(params[2]);
                    cars.add(new Car(model, currentEngine, weight));
                } else {
                    String color = params[2];
                    cars.add(new Car(model, currentEngine, color));
                }
            } else if (params.length == 4){
                int weight = Integer.parseInt(params[2]);
                String color = params[3];
                cars.add(new Car(model, currentEngine, weight, color));
            } else {
                cars.add(new Car(model, currentEngine));
            }
        }

        for (Car car : cars) {
            System.out.println(car.toString());
        }
    }
}



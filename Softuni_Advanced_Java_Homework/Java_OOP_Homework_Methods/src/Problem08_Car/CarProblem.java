package Problem08_Car;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CarProblem {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        String[] params = sc.readLine().split("\\s+");
        double speed = Double.parseDouble(params[0]);
        double fuel = Double.parseDouble(params[1]);
        double economy = Double.parseDouble(params[2]);
        Car car = new Car(speed, fuel, economy);


        while (true) {
            String[] commands = sc.readLine().split("\\s+");
            if (commands[0].equals("END")){
                break;
            }

            switch (commands[0]) {
                case "Travel":
                    double distance = Double.parseDouble(commands[1]);
                    car.Travel(distance);
                    break;
                case "Refuel":
                    double litters = Double.parseDouble(commands[1]);
                    car.Refuel(litters);
                    break;
                case "Distance":
                    System.out.printf("Total distance: %.1f kilometers\n", car.getTotalDistance());
                    break;
                case "Time":
                    double time = car.getTotalTime();
                    int hours = (int) time / 60;
                    int minutes = (int) time % 60;
                    System.out.printf("Total time: %d hours and %d minutes\n", hours, minutes);
                    break;
                case "Fuel":
                    System.out.printf("Fuel left: %.1f liters\n", car.getFuel());
                    break;
            }

        }
    }
}

class Car {
    private double speed;
    private double fuel;
    private double fuelEconomy;
    private double totalDistance;
    private double totalTime;

    public Car(double speed, double fuel, double fuelEconomy) {
        this.speed = speed;
        this.fuel = fuel;
        this.fuelEconomy = fuelEconomy;
        this.totalDistance = 0.0;
        this.totalTime = 0.0;
    }

    public double getTotalTime() {
        return totalTime;
    }

    public double getTotalDistance() {
        return totalDistance;
    }

    public double getFuel() {
        return fuel;
    }

    public void Refuel(double litters) {
        if (litters < 0) {
            return;
        }
        this.fuel += litters;
    }

    public void Travel(double distance) {
        double canTravel = (this.fuel * 100) / this.fuelEconomy;
        if (canTravel <= distance) {
            distance = canTravel;
        }
        this.fuel -= distance * (this.fuelEconomy / 100);
        this.totalDistance += distance;
        this.totalTime += (distance / speed) * 60;
    }
}
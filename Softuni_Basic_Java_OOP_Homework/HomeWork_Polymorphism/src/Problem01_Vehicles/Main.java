package Problem01_Vehicles;

import Problem01_Vehicles.Models.Bus;
import Problem01_Vehicles.Models.Car;
import Problem01_Vehicles.Models.Truck;
import Problem01_Vehicles.Models.Vehicle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        Vehicle car = null;
        Vehicle truck = null;
        Vehicle bus = null;

        for (int i = 0; i < 3; i++) {
            String[] params = sc.readLine().split("\\s+");
            String type = params[0];
            double quantities = Double.valueOf(params[1]);
            double littersPerKm = Double.valueOf(params[2]);
            double tankCapacity = Double.valueOf(params[3]);

            switch (type) {
                case "Car":
                    car = new Car(quantities, littersPerKm, tankCapacity);
                    break;
                case "Truck":
                    truck = new Truck(quantities, littersPerKm, tankCapacity);
                    break;
                case "Bus":
                    bus = new Bus(quantities, littersPerKm, tankCapacity);
                    break;
            }
        }

        int lines = Integer.valueOf(sc.readLine());
        for (int i = 0; i < lines; i++) {
            String[] params = sc.readLine().split("\\s+");
            String command = params[0];
            String vehicleType = params[1];
            double amountOrDistance = Double.valueOf(params[2]);

            switch (command) {
                case "Drive":
                    switch (vehicleType) {
                        case "Car":
                            car.DriveDistance(amountOrDistance);
                            break;
                        case "Truck":
                            truck.DriveDistance(amountOrDistance);
                            break;
                        case "Bus":
                            ((Bus)bus).DriveWithPeople(amountOrDistance);
                    }
                    break;
                case "Refuel":
                    switch (vehicleType) {
                        case "Car":
                            car.Refuel(amountOrDistance);
                            break;
                        case "Truck":
                            truck.Refuel(amountOrDistance);
                            break;
                        case "Bus":
                            bus.Refuel(amountOrDistance);
                    }
                    break;
                case "DriveEmpty":
                    bus.DriveDistance(amountOrDistance);
            }
        }

        System.out.println(car);
        System.out.println(truck);
        System.out.println(bus);
    }
}

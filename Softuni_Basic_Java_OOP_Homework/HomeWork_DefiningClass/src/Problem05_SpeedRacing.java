import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Problem05_SpeedRacing {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        LinkedList<Carr> allCars = new LinkedList<>();
        int cars = Integer.parseInt(sc.readLine());
        for (int i = 0; i < cars; i++) {
            String[] carsInfo = sc.readLine().split("\\s+");
            String model = carsInfo[0];
            int fuelAmount = Integer.parseInt(carsInfo[1]);
            double fuelCost = Double.parseDouble(carsInfo[2]);
            allCars.add(new Carr(model,fuelAmount,fuelCost));
        }

        String line;
        while (!"End".equals(line = sc.readLine())){
            String params[] = line.split("\\s+");
            String carModel = params[1];
            int travel = Integer.parseInt(params[2]);
            for (Carr currCar : allCars) {
                if (currCar.model.equals(carModel)){
                    currCar.Drive(travel);
                }
            }
        }
        allCars.stream().forEach(car ->{
            System.out.println(car.toString());
        });
    }
}

class Carr implements Comparable<Carr> {
    String model;
    double fuelAmount;
    double fuelCostForKm;
    int distanceToTravel = 0;

    public Carr(String model, double fuelAmount, double fuelCostForKm) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCostForKm = fuelCostForKm;
    }

    public void Drive(int distanceTraveled){
        double usedFuel = distanceTraveled * this.fuelCostForKm;
        if (usedFuel <= this.fuelAmount){
            fuelAmount = CalcRestFuel(this.fuelAmount, usedFuel);
            distanceToTravel = CalcDistanceTraveled(this.distanceToTravel, distanceTraveled);
        } else {
            System.out.println("Insufficient fuel for the drive");
        }
    }

    private int CalcDistanceTraveled(int distanceToTraveled, int distanceTraveled) {
        return distanceToTraveled + distanceTraveled;
    }

    private double CalcRestFuel(double fuelAmount, double usedFuel) {
        return fuelAmount - usedFuel;
    }


    @Override
    public String toString() {
        return String.format("%s %.2f %d", this.model, this.fuelAmount, this.distanceToTravel);
    }

    @Override
    public int compareTo(Carr car) {
        return car.model.compareTo(this.model);
    }
}

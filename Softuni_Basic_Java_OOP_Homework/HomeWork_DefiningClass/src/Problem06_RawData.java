import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Problem06_RawData {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        int carsNumbers = Integer.parseInt(sc.readLine());
        LinkedList<Car> cars = new LinkedList<>();
        for (int i = 0; i < carsNumbers; i++) {
            String[] params = sc.readLine().split("\\s+");
            String model = params[0];
            int engineSpeed = Integer.parseInt(params[1]);
            int enginePower = Integer.parseInt(params[2]);
            int cargoWeight = Integer.parseInt(params[3]);
            String cargoType = params[4];

            double[] tires = new double[4];
            tires[0] = Double.parseDouble(params[5]);
            tires[1] = Double.parseDouble(params[7]);
            tires[2] = Double.parseDouble(params[9]);
            tires[3] = Double.parseDouble(params[11]);

            Engine currentEngine = new Engine(engineSpeed, enginePower);
            Cargo currentCargo = new Cargo(cargoWeight, cargoType);
            Tires currentTires = new Tires(tires);

            cars.add(new Car(model, currentEngine,currentCargo,currentTires));
        }

        String needed = sc.readLine();
        if (needed.equals("fragile")){
            for (Car car : cars) {
                if (car.cargo.cargoType.equals("fragile")){
                    for (double tire : car.tires.tires) {
                        if (tire < 1.0){
                            System.out.println(car.model);
                            break;
                        }
                    }
                }
            }
        }

        if (needed.equals("flamable")){
            for (Car car : cars) {
                if (car.cargo.cargoType.equals("flamable")){
                    if (car.engine.enginePower > 250){
                        System.out.println(car.model);
                    }
                }
            }
        }
    }
}

class Car {
    String model;
    Engine engine;
    Cargo cargo;
    Tires tires;

    public Car(String model, Engine engine, Cargo cargo, Tires tires) {
        this.model = model;
        this.engine = engine;
        this.cargo = cargo;
        this.tires = tires;
    }
}

class Engine {
    int engineSpeed;
    int enginePower;

    public Engine(int engineSpeed, int enginePower) {
        this.engineSpeed = engineSpeed;
        this.enginePower = enginePower;
    }
}

class Cargo {
    int cargoWeight;
    String cargoType;

    public Cargo(int cargoWeight, String cargoType) {
        this.cargoWeight = cargoWeight;
        this.cargoType = cargoType;
    }
}

class Tires {
    double[] tires;

    public Tires(double[] tires) {
        this.tires = tires;
    }
}
package Problem01_Vehicles.Models;

public class Car extends Vehicle {


    public Car(double fuelQuantities, double consumptionPerKm, double tankCapacity) {
        super(fuelQuantities, consumptionPerKm, tankCapacity);
    }

    @Override
    protected void setConsumptionPerKm(double consumptionPerKm) {
        super.setConsumptionPerKm(consumptionPerKm + 0.9);
    }

    @Override
    public void Refuel(double litters) {
        if (getFuelQuantities() + litters > getTankCapacity()){
            System.out.println("Cannot fit fuel in tank");
        } else {
            super.Refuel(litters);
        }
    }
}

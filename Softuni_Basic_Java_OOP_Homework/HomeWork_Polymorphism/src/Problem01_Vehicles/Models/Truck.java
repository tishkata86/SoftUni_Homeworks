package Problem01_Vehicles.Models;

public class Truck extends Vehicle {

    public Truck(double fuelQuantities, double consumptionPerKm, double tankCapacity) {
        super(fuelQuantities, consumptionPerKm, tankCapacity);
    }

    @Override
    protected void setConsumptionPerKm(double consumptionPerKm) {
        super.setConsumptionPerKm(consumptionPerKm + 1.6);
    }

    @Override
    public void Refuel(double litters) {
        super.Refuel(litters * 0.95);
    }
}

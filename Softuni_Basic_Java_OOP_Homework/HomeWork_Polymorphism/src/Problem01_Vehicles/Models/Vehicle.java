package Problem01_Vehicles.Models;

import java.text.DecimalFormat;

public abstract class Vehicle {
    private double fuelQuantities;
    private double consumptionPerKm;
    private double tankCapacity;

    public Vehicle(double fuelQuantities, double consumptionPerKm, double tankCapacity) {
        setFuelQuantities(fuelQuantities);
        setConsumptionPerKm(consumptionPerKm);
        setTankCapacity(tankCapacity);
    }

    public double getTankCapacity() {
        return tankCapacity;
    }

    private void setTankCapacity(double tankCapacity) {
        this.tankCapacity = tankCapacity;
    }

    public double getFuelQuantities() {
        return fuelQuantities;
    }

    protected void setFuelQuantities(double fuelQuantities) {
        if (fuelQuantities < 0){
            System.out.println("Fuel must be a positive number");
        } else {
            this.fuelQuantities = fuelQuantities;
        }
    }

    public double getConsumptionPerKm() {
        return consumptionPerKm;
    }

    protected void setConsumptionPerKm(double consumptionPerKm) {
        this.consumptionPerKm = consumptionPerKm;
    }

    public void DriveDistance(double distance) {
        double neededFuel = distance * this.consumptionPerKm;
        if (neededFuel <= this.fuelQuantities) {
            this.fuelQuantities -= neededFuel;
            DecimalFormat dc = new DecimalFormat("0.######");
            System.out.printf("%s travelled %s km\n", getClass().getSimpleName(), dc.format(distance));
        } else {
            System.out.printf("%s needs refueling\n", getClass().getSimpleName());
        }
    }

    public void Refuel(double litters) {
        if (this.fuelQuantities + litters < 0){
            System.out.println("Fuel must be a positive number");
        } else {
            setFuelQuantities(this.fuelQuantities + litters);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s: %.2f", this.getClass().getSimpleName(), getFuelQuantities()));
        return sb.toString();
    }
}

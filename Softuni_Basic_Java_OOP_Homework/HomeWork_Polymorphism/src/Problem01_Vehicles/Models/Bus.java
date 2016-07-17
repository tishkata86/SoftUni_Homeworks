package Problem01_Vehicles.Models;

import java.text.DecimalFormat;

public class Bus extends Vehicle {

    public Bus(double fuelQuantities, double consumptionPerKm, double tankCapacity) {
        super(fuelQuantities, consumptionPerKm, tankCapacity);
    }


    @Override
    public void Refuel(double litters) {
        if (getFuelQuantities() + litters > getTankCapacity()) {
            System.out.println("Cannot fit fuel in tank");
        } else {
            super.Refuel(litters);
        }

    }

    public void DriveWithPeople(double distance) {
        double neededFuel = distance * (this.getConsumptionPerKm() + 1.4);
        if (neededFuel <= this.getFuelQuantities()) {
            setFuelQuantities(this.getFuelQuantities() - neededFuel);
            DecimalFormat dc = new DecimalFormat("0.######");
            System.out.printf("%s travelled %s km\n", getClass().getSimpleName(), dc.format(distance));
        } else {
            System.out.printf("%s needs refueling\n", getClass().getSimpleName());
        }
    }
}

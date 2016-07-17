package Problem08_MilitaryElite.Models.PrivateModels.SpecialSoldiersModels;

import Problem08_MilitaryElite.Interfaces.PartInterface;

public class Part implements PartInterface{

    private String name;
    private int hours;

    public Part(String name, int hours) {
        this.setName(name);
        this.setHours(hours);
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public int getHours() {
        return hours;
    }

    private void setHours(int hours) {
        this.hours = hours;
    }

    @Override
    public String toString() {
        return String.format("  Part Name: %s Hours Worked: %d", this.getName(), getHours());

    }
}

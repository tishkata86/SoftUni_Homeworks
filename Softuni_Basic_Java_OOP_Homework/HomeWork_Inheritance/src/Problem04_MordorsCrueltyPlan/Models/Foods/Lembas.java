package Problem04_MordorsCrueltyPlan.Models.Foods;

import Problem04_MordorsCrueltyPlan.Models.Food;

public class Lembas extends Food{
    private String name;
    private int pointOfHappiness;

    public Lembas(String name) {
        this.name = name;
        this.pointOfHappiness = 3;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Integer getPointOfHappiness() {
        return this.pointOfHappiness;
    }
}

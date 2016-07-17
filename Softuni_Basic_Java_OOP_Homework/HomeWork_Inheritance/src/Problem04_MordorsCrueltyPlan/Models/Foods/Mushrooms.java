package Problem04_MordorsCrueltyPlan.Models.Foods;

import Problem04_MordorsCrueltyPlan.Models.Food;

public class Mushrooms extends Food {
    private String name;
    private int pointOfHappiness;

    public Mushrooms(String name) {
        this.name = name;
        this.pointOfHappiness = -10;
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

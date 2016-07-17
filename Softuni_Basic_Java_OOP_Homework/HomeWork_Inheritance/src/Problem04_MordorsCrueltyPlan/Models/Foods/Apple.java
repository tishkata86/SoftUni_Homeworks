package Problem04_MordorsCrueltyPlan.Models.Foods;

import Problem04_MordorsCrueltyPlan.Models.Food;

public class Apple extends Food{
    private String name;
    private int pointOfHappiness;

    public Apple(String name) {
        this.name = name;
        this.pointOfHappiness = 1;
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

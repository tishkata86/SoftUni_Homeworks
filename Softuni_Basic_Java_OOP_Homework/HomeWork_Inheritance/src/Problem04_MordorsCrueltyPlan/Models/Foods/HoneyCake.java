package Problem04_MordorsCrueltyPlan.Models.Foods;

import Problem04_MordorsCrueltyPlan.Models.Food;

public class HoneyCake  extends Food{
    private String name;
    private int pointOfHappiness;

    public HoneyCake(String name) {
        this.name = name;
        pointOfHappiness = 5;
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

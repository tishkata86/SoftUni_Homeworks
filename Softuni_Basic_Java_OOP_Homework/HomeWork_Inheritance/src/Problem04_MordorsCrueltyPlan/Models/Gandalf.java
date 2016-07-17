package Problem04_MordorsCrueltyPlan.Models;

import Problem04_MordorsCrueltyPlan.Factories.FoodFactory;
import Problem04_MordorsCrueltyPlan.Factories.MoodFactory;

import java.util.ArrayList;

public class Gandalf {
    private final int DEFAULT_HAPPYNESS = 0;

    private int happinessPoint;
    private ArrayList<Food> foods;
    private Mood mood;

    public Gandalf() {
        this.happinessPoint = DEFAULT_HAPPYNESS;
        this.foods = new ArrayList<>();
        this.setMood();
    }

    public int getHappinessPoint(){
        return this.happinessPoint;
    }

    private void setHappinessPoint(){
        for (Food food : foods) {
            this.happinessPoint += food.getPointOfHappiness();
        }
    }

    public void setMood(){
        this.mood = MoodFactory.getMood(this.happinessPoint);
    }

    public void setFoods(String[] foods){
        for (String food : foods) {
            this.foods.add(FoodFactory.getFood(food));
        }

        if (this.foods.size() > 0){
            setHappinessPoint();
        }
    }

    @Override
    public String toString() {
        return String.format("%d%n%s", this.happinessPoint, this.mood);
    }
}

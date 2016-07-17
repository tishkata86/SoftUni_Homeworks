package Problem04_MordorsCrueltyPlan.Factories;

import Problem04_MordorsCrueltyPlan.Models.Food;
import Problem04_MordorsCrueltyPlan.Models.Foods.*;

public class FoodFactory {

    public static Food getFood(String name) {
        String food = name.toLowerCase();
        switch (food) {
            case "cram":
                return new Cram(food);
            case "apple":
                return new Apple(food);
            case "lembas":
                return new Lembas(food);
            case "melon":
                return new Melon(food);
            case "honeycake":
                return new HoneyCake(food);
            case "mushrooms":
                return new Mushrooms(food);
            default:
                return new UnknownFood(food);
        }
    }
}

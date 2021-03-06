package Problem03_WildFarm.Animals;

import Problem03_WildFarm.Foods.Food;

public class Zebra extends Mammal {

    public Zebra(String animalName, String animalType, double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    @Override
    public void eat(Food food) {
        if (food.getClass().getSimpleName().equals("Vegetable")){
            setFoodEaten(getFoodEaten() + food.getQuantities());
        } else {
            System.out.printf("%ss are not eating that type of food!\n", getAnimalType());
        }
    }

    @Override
    public void makeSound() {
        System.out.println("Zs");
    }
}

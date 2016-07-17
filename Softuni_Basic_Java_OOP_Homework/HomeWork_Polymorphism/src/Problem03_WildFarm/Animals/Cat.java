package Problem03_WildFarm.Animals;

import Problem03_WildFarm.Foods.Food;

import java.text.DecimalFormat;

public class Cat extends Felime {
    private String breed;

    public Cat(String animalName, String animalType, double animalWeight, String livingRegion, String breed) {
        super(animalName, animalType, animalWeight, livingRegion);
        this.setBreed(breed);
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    @Override
    public void eat(Food food) {
        setFoodEaten(getFoodEaten() + food.getQuantities());
    }

    @Override
    public void makeSound() {
        System.out.println("Meowwww");
    }

    @Override
    public String toString() {
        DecimalFormat dc = new DecimalFormat("0.######");
        return String.format("%s[%s, %s, %s, %s, %d]\n",
                getAnimalType(),
                this.getAnimalName(),
                this.breed,
                dc.format(this.getAnimalWeight()),
                getLivingRegion(),
                getFoodEaten());
    }
}

package Problem05_PizzaCalories;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private String name;
    private Dough dough;
    private List<Topping> toppings;
    private int numberOfToppings;
    private double totalCalories;

    public Pizza(String name, int numberOfToppings) {
        setName(name);
        setNumberOfToppings(numberOfToppings);
        this.toppings = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getNumberOfToppings() {
        return numberOfToppings;
    }

    public double getTotalCalories() {
        return totalCalories;
    }

    private void setNumberOfToppings(int numberOfToppings) {
        if (numberOfToppings < 1 || numberOfToppings > 10){
            throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
        }
        this.numberOfToppings = numberOfToppings;
    }

    private void setName(String name) {
        if (name.length() < 1 || name.length() > 15){
            throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
        }
        this.name = name;
    }

    public void setDough(Dough dough) {
        this.totalCalories += dough.CaloriesPerGram();
        this.dough = dough;
    }

    public void setToppings(Topping topping) {
        this.totalCalories += topping.CaloriesPerGram();
        this.toppings.add(topping);
    }

    @Override
    public String toString() {
        return String.format("%s - %.2f Calories.\n", this.name, this.totalCalories);
    }
}

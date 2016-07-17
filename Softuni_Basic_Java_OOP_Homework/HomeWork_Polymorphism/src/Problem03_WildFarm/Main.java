package Problem03_WildFarm;

import Problem03_WildFarm.Animals.*;
import Problem03_WildFarm.Foods.Food;
import Problem03_WildFarm.Foods.Meat;
import Problem03_WildFarm.Foods.Vegetable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while (!"End".equals(line = sc.readLine())){
            String[] animalParams = line.split("\\s+");
            String[] foodParams = sc.readLine().split("\\s+");

            String animalType = animalParams[0];
            String animalName = animalParams[1];
            double animalWeight = Double.valueOf(animalParams[2]);
            String animalRegion = animalParams[3];
            String bread = null;

            Animal currentAnimal = null;
            Food currentFood = null;

            switch (animalType){
                case "Cat":
                    bread = animalParams[4];
                    currentAnimal = new Cat(animalType, animalName, animalWeight, animalRegion, bread);
                    break;
                case "Tiger":
                    currentAnimal = new Tiger(animalType, animalName, animalWeight, animalRegion);
                    break;
                case "Zebra":
                    currentAnimal = new Zebra(animalType, animalName, animalWeight, animalRegion);
                    break;
                case "Mouse":
                    currentAnimal = new Mouse(animalType, animalName, animalWeight, animalRegion);
                    break;
            }

            String foodType = foodParams[0];
            int foodQuantities = Integer.parseInt(foodParams[1]);
            switch (foodType){
                case "Vegetable":
                    currentFood = new Vegetable(foodQuantities);
                    break;
                case "Meat":
                    currentFood = new Meat(foodQuantities);
            }


            currentAnimal.makeSound();
            currentAnimal.eat(currentFood);
            System.out.print(currentAnimal);

        }
    }
}

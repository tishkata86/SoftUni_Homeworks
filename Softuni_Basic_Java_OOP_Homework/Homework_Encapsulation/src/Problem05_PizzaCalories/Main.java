package Problem05_PizzaCalories;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        try {
            String line;
            Pizza myPizza = new Pizza("WrongPizza", 1);
            while (!"END".equals(line = sc.readLine())) {
                String[] params = line.split("\\s+");
                if (params[0].equals("Pizza")) {
                    String pizzaName = params[1];
                    int numberOfToppings = Integer.parseInt(params[2]);
                    myPizza = new Pizza(pizzaName, numberOfToppings);
                } else if (params[0].equals("Dough")) {
                    String flourType = params[1];
                    String technique = params[2];
                    double weight = Double.parseDouble(params[3]);
                    Dough currentDough = new Dough(flourType, technique, weight);
                    if (myPizza.getName().equals("WrongPizza")) {
                        System.out.printf("%.2f\n", currentDough.CaloriesPerGram());
                    }
                    if (!myPizza.getName().equals("WrongPizza")) {
                        myPizza.setDough(currentDough);
                    }
                } else if (params[0].equals("Topping")) {
                    String type = params[1];
                    double currentWeight = Double.parseDouble(params[2]);
                    Topping currentTopping = new Topping(type, currentWeight);
                    if (myPizza.getName().equals("WrongPizza")) {
                        System.out.printf("%.2f\n", currentTopping.CaloriesPerGram());
                    }
                    if (!myPizza.getName().equals("WrongPizza")) {
                        myPizza.setToppings(currentTopping);
                    }
                }
            }
            if (!myPizza.getName().equals("WrongPizza")) {
                System.out.println(myPizza);
            }

        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }

    }
}

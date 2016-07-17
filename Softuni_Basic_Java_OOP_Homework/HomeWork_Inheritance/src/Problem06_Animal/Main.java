package Problem06_Animal;

import Problem06_Animal.Models.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        try {
            while (true) {
                String command = sc.readLine();
                if (command.equals("Beast!")) {
                    break;
                }
                String[] params = sc.readLine().split("\\s+");
                String name = params[0];
                int age = Integer.valueOf(params[1]);
                String gender = null;
                Animal animal = null;

                switch (command.toLowerCase()) {
                    case "cat":
                        gender = params[2];
                        animal = new Cat(name, age, gender);
                        break;

                    case "kitten":
                        animal = new Kittens(name, age);
                        break;

                    case "tomcat":
                        animal = new Tomcat(name, age);
                        break;

                    case "dog":
                        gender = params[2];
                        animal = new Dog(name, age, gender);
                        break;

                    case "frog":
                        gender = params[2];
                        animal = new Frog(name, age, gender);
                        break;

                }
                if (animal != null) {
                    System.out.println(animal);
                    System.out.println(animal.produceSound());
                }
            }
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }

    }
}

package Problem05_AnimalClinicProblem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AnimalClinicProblem {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while (!"End".equals(line = sc.readLine())) {
            AnimalClinic.healOrRehabilitate(line);
        }
        System.out.println("Total healed animals: " + AnimalClinic.healedAnimalsCount);
        System.out.println("Total rehabilitated animals: " + AnimalClinic.rehabilitedAnimalsCount);

        String showAll = sc.readLine();
        switch (showAll){
            case "heal":
                for (Animal animal : AnimalClinic.healed) {
                    System.out.println(animal.getName() + " " + animal.getBread());
                }
                break;
            case "rehabilitate":
                for (Animal animal : AnimalClinic.rehabilitated) {
                    System.out.println(animal.getName() + " " + animal.getBread());
                }
                break;
        }
    }
}

class Animal {
    private String name;
    private String bread;

    public Animal(String name, String bread) {
        this.name = name;
        this.bread = bread;
    }

    public String getName() {
        return name;
    }

    public String getBread() {
        return bread;
    }
}

class AnimalClinic {
    private static int patientId = 1;
    public static int healedAnimalsCount = 0;
    public static int rehabilitedAnimalsCount = 0;
    public static List<Animal> healed = new ArrayList<>();
    public static List<Animal> rehabilitated = new ArrayList<>();

    public static void healOrRehabilitate(String info) {
        String[] params = info.split("\\s+");
        String name = params[0];
        String breed = params[1];
        String healOrRehabilitate = params[2];

        Animal currentAnimal = new Animal(name, breed);
        switch (healOrRehabilitate) {
            case "heal":
                System.out.printf("Patient %d: [%s (%s)] has been healed!\n",
                        patientId,
                        currentAnimal.getName(),
                        currentAnimal.getBread());
                healed.add(currentAnimal);
                patientId++;
                healedAnimalsCount++;
                break;
            case "rehabilitate":
                System.out.printf("Patient %d: [%s (%s)] has been rehabilitated!\n",
                        patientId,
                        currentAnimal.getName(),
                        currentAnimal.getBread());
                rehabilitated.add(currentAnimal);
                patientId++;
                rehabilitedAnimalsCount++;
                break;
        }
    }
}
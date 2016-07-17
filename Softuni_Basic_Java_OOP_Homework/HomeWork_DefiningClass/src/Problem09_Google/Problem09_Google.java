package Problem09_Google;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Problem09_Google {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        LinkedList<Person> persons = new LinkedList<>();
        LinkedList<String> names = new LinkedList<>();
        String line;
        while (!"End".equals(line = sc.readLine())){
            String[] params = line.split("\\s+");
            String name = params[0];
            if (!names.contains(name)){
                names.add(name);
                persons.add(new Person(name));
            }

            String info = params[1];
            switch (info){
                case "company":
                    String companyName = params[2];
                    String department = params[3];
                    double salary = Double.parseDouble(params[4]);

                    for (Person person : persons) {
                        if (person.name.equals(name)){
                            person.company = new Company(companyName, department, salary);
                        }
                    }
                    break;
                case "pokemon":
                    String pokemonName = params[2];
                    String pokemonType = params[3];

                    for (Person person : persons) {
                        if (person.name.equals(name)){
                            person.pokemons.add(new Pokemon(pokemonName, pokemonType));
                        }
                    }
                    break;
                case "parents":
                    String parentName = params[2];
                    String parentBirthday = params[3];

                    for (Person person : persons) {
                        if (person.name.equals(name)){
                            person.parents.add(new Parents(parentName, parentBirthday));
                        }
                    }
                    break;
                case "children":
                    String childName = params[2];
                    String childBirthday = params[3];

                    for (Person person : persons) {
                        if (person.name.equals(name)){
                            person.childrens.add(new Children(childName, childBirthday));
                        }
                    }
                    break;
                case "car":
                    String carModel = params[2];
                    String carSpeed = params[3];

                    for (Person person : persons) {
                        if (person.name.equals(name)){
                            person.car = new Car(carModel,carSpeed);
                        }
                    }
            }
        }

        String neededName = sc.readLine();
        for (Person person : persons) {
            if (person.name.equals(neededName)){
                System.out.println(person.toString());
                break;
            }
        }
    }
}

class Person{
    String name;
    Company company;
    LinkedList<Pokemon> pokemons;
    LinkedList<Parents> parents;
    LinkedList<Children> childrens;
    Car car;

    public Person(String name) {
        this.name = name;
        this.company = null;
        this.pokemons = new LinkedList<>();
        this.parents = new LinkedList<>();
        this.childrens = new LinkedList<>();
        this.car = null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.name + "\n");
        sb.append("Company:\n");
        if (this.company != null){
            sb.append(this.company.toString());
        }
        sb.append("Car:\n");
        if (this.car != null) {
            sb.append(this.car.toString());
        }
        sb.append("Pokemon:\n");
        for (Pokemon pokemon : pokemons) {
            sb.append(pokemon.toString());
        }
        sb.append("Parents:\n");
        for (Parents parent : parents) {
            sb.append(parent.toString());
        }
        sb.append("Children:\n");
        for (Children children : childrens) {
            sb.append(children.toString());
        }
        return sb.toString();
    }
}

class Company{
    String companyName;
    String department;
    double salary;

    public Company(String companyName, String department, double salary) {
        this.companyName = companyName;
        this.department = department;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return String.format("%s %s %.2f\n", this.companyName, this.department, this.salary);
    }
}

class Pokemon{
    String pokemonName;
    String pokemonType;

    public Pokemon(String pokemonName, String pokemonType) {
        this.pokemonName = pokemonName;
        this.pokemonType = pokemonType;
    }

    @Override
    public String toString() {
        return String.format("%s %s\n", this.pokemonName, this.pokemonType);
    }
}

class Parents{
    String parentName;
    String parentBirthday;

    public Parents(String parentName, String parentBirthday) {
        this.parentName = parentName;
        this.parentBirthday = parentBirthday;
    }

    @Override
    public String toString() {
        return String.format("%s %s\n", this.parentName, this.parentBirthday);
    }
}

class Children{
    String childName;
    String childBirthday;

    public Children(String childName, String childBirthday) {
        this.childName = childName;
        this.childBirthday = childBirthday;
    }

    @Override
    public String toString() {
        return String.format("%s %s\n", this.childName, this.childBirthday);
    }
}

class Car{
    String carModel;
    String carSpeed;

    public Car(String carModel, String carSpeed) {
        this.carModel = carModel;
        this.carSpeed = carSpeed;
    }

    @Override
    public String toString() {
        return String.format("%s %s\n", this.carModel, this.carSpeed);
    }
}
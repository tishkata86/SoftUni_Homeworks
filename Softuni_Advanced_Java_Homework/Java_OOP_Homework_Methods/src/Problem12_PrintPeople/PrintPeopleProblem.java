package Problem12_PrintPeople;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class PrintPeopleProblem {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        List<Person> data = new ArrayList<>();
        String line;
        while (!"END".equals(line = sc.readLine())){
            String[] params = line.split("\\s+");
            String name = params[0];
            int age = Integer.parseInt(params[1]);
            String occupation = params[2];
            data.add(new Person(name, age, occupation));
        }

        data.sort((person1, person2) -> person1.compareTo(person2));

        for (Person person : data) {
            System.out.println(person);
        }
    }
}

class Person implements Comparable<Person>{
    private String name;
    private int age;
    private String occupation;

    public Person(String name, int age, String occupation) {
        this.name = name;
        this.age = age;
        this.occupation = occupation;
    }

    @Override
    public int compareTo(Person newPerson) {
        return Integer.valueOf(this.age).compareTo(Integer.valueOf(newPerson.age));
    }

    @Override
    public String toString() {
        return String.format("%s - age: %d, occupation: %s", this.name, this.age, this.occupation);
    }
}
package Problem05_ComparingObjects;

import Problem05_ComparingObjects.interfaces.Person;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        List<Person> data = new ArrayList<>();

        String line;
        while (!"END".equals(line = sc.readLine())) {
            String[] params = line.split("\\s+");
            String name = params[0];
            int age = Integer.parseInt(params[1]);
            String town = params[2];
            data.add(new PersonImpl(name, age, town));
        }
        int index = Integer.parseInt(sc.readLine()) - 1;
        Person currentPerson = data.get(index);

        int matchedPersons = 0;
        int notMatchedPerson = 0;
        int allPersons = data.size();

        for (Person person : data) {
            if (person.compareTo(currentPerson) == 1){
                matchedPersons++;
            } else {
                notMatchedPerson++;
            }
        }

        if (matchedPersons == 1){
            System.out.println("No matches");
        } else {
            System.out.println(matchedPersons + " " + notMatchedPerson + " " + allPersons);
        }

    }
}

package Problem06_StrategyPattern;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        TreeSet<Person> orderedByName = new TreeSet<>(new CompareByName());
        TreeSet<Person> orderedByAge = new TreeSet<>(new CompareByAge());

        int lines = Integer.parseInt(sc.readLine());
        Person currentPerson = null;
        for (int i = 0; i < lines; i++) {
            String[] params = sc.readLine().split("\\s+");
            String name = params[0];
            int age = Integer.parseInt(params[1]);

            currentPerson = new Person(name, age);

            orderedByAge.add(currentPerson);
            orderedByName.add(currentPerson);
        }

        orderedByName.forEach(System.out::println);
        orderedByAge.forEach(System.out::println);
    }
}

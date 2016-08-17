package Problem07_EqualityLogic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        TreeSet<Person> treeSet = new TreeSet<>();
        HashSet<Person> hashSet = new HashSet<>();

        int lines = Integer.parseInt(sc.readLine());
        Person currentPerson = null;

        for (int i = 0; i < lines; i++) {
            String[] params = sc.readLine().split("\\s+");
            String name = params[0];
            int age = Integer.parseInt(params[1]);

            currentPerson = new Person(name, age);

            treeSet.add(currentPerson);
            hashSet.add(currentPerson);
        }

        System.out.println(treeSet.size());
        System.out.println(hashSet.size());
    }
}

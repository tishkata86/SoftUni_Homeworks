package Problem02_OldestFamilyMember;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class OldestFamilyMember {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        Method getOldestMethod = Class.forName("Problem02_OldestFamilyMember.Family").getMethod("getOldestMember");
        Method addMemberMethod =Class.forName("Problem02_OldestFamilyMember.Family").getMethod("addFamilyMember",Person.class);
        int lines = Integer.parseInt(sc.readLine());
        Family myFamily = new Family();
        for (int i = 0; i < lines; i++) {
            String[] params = sc.readLine().trim().split("\\s+");
            String name = params[0];
            int age = Integer.parseInt(params[1]);
            Person personToAdd = new Person(name, age);
            myFamily.addFamilyMember(personToAdd);
        }
        System.out.println(myFamily.getOldestMember().toString());

    }
}

class Person{
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("%s %d", this.name, this.age);
    }
}

class Family{
    List<Person> family = new ArrayList<>();

    public void addFamilyMember(Person member){
        this.family.add(member);
    }

    public Person getOldestMember(){
        Person oldest = new Person("", Integer.MIN_VALUE);
        for (Person person : family) {
            if (person.age >= oldest.age){
                oldest = person;
            }
        }

        return oldest;
    }
}
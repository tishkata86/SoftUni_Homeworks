package Problem07_EqualityLogic;

import java.util.Comparator;
import java.util.Iterator;

public class Person implements Comparable<Person>{
    private String name;
    private int age;

    public Person(String name, int age) {
        this.setName(name);
        this.setAge(age);
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    private void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || this.getClass() != other.getClass()) {
            return false;
        }

        Person person = (Person) other;

        if (this.age != person.age) {
            return false;
        }

        return this.name != null ? this.name.equals(person.name) : person.name == null;
    }

    @Override
    public int hashCode() {
        int result = this.name != null ? this.name.hashCode() : 0;
        result = 31 * result + this.age;

        return result;
    }

    @Override
    public int compareTo(Person other) {
        return Integer.compare(this.hashCode(), other.hashCode());
    }
}

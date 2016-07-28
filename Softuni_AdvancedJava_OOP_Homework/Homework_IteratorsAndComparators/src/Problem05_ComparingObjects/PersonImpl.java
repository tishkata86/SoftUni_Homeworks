package Problem05_ComparingObjects;

import Problem05_ComparingObjects.interfaces.Person;

public class PersonImpl implements Person, Comparable<Person>{
    private String name;
    private int age;
    private String town;

    public PersonImpl(String name, int age, String town) {
        this.setName(name);
        this.setAge(age);
        this.setTown(town);
    }

    @Override
    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    @Override
    public int getAge() {
        return age;
    }

    private void setAge(int age) {
        this.age = age;
    }

    @Override
    public String getTown() {
        return town;
    }

    private void setTown(String town) {
        this.town = town;
    }
    @Override
    public int compareTo(Person person) {
        int result = 0;
        if (this.getName().compareTo(person.getName()) == 0){
            if (this.getAge() == person.getAge()){
                if (this.getTown().compareTo(person.getTown()) == 0){
                    result = 1;
                }
            }
        }
        return result;
    }
}

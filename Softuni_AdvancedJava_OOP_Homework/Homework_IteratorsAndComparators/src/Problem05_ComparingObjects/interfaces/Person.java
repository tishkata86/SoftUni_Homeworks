package Problem05_ComparingObjects.interfaces;

public interface Person extends Comparable<Person>{
    String getName();

    int getAge();

    String getTown();
}

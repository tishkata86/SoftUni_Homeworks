package Problem06_StrategyPattern;

import java.util.Comparator;

public class CompareByName implements Comparator<Person> {

    @Override
    public int compare(Person first, Person second) {
        if (first.getName().length() == second.getName().length()){
            return Integer.compare(first.getName().toLowerCase().charAt(0), second.getName().toLowerCase().charAt(0));
        } else {
            return Integer.compare(first.getName().length(), second.getName().length());
        }
    }
}

package Problem10_FamilyTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;

public class FamilyTree {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        String myInfo = sc.readLine();
        List<Person> people = new LinkedList<>();
        List<String> lines = new LinkedList<>();

        String line;
        while (!"End".equals(line = sc.readLine())) {
            lines.add(line);
        }

        for (int i = 0; i < lines.size(); i++) {
            String currentLine = lines.get(i);

            if (!currentLine.contains("-")) {
                String[] params = currentLine.trim().split("\\s+");
                String name = params[0] + " " + params[1];
                String birthDay = params[2];
                people.add(new Person(name, birthDay));
            }
        }

        for (int i = 0; i < lines.size(); i++) {
            String currentLine = lines.get(i);

            if (currentLine.contains("-")) {
                String[] params = currentLine.trim().split("-");
                String left = params[0].trim();
                String right = params[1].trim();

                Person parent = null;
                Person child = null;

                if (Character.isLetter(left.charAt(0))) {
                    for (Person person : people) {
                        if (person.name.equals(left)) {
                            parent = person;
                            break;
                        }
                    }
                } else {
                    for (Person person : people) {
                        if (person.birthDay.equals(left)) {
                            parent = person;
                            break;
                        }
                    }
                }

                if (Character.isLetter(right.charAt(0))) {
                    for (Person person : people) {
                        if (person.name.equals(right)) {
                            child = person;
                            break;
                        }
                    }
                } else {
                    for (Person person : people) {
                        if (person.birthDay.equals(right)) {
                            child = person;
                            break;
                        }
                    }
                }

                parent.childrens.add(child);
                child.parents.add(parent);
            }
        }

        Person targetPerson = null;
        if (Character.isLetter(myInfo.charAt(0))) {
            for (Person person : people) {
                if (person.name.equals(myInfo)) {
                    targetPerson = person;
                }
            }
        } else {
            for (Person person : people) {
                if (person.birthDay.equals(myInfo)) {
                    targetPerson = person;
                }
            }
        }

        System.out.println(targetPerson);
    }
}

class Person {
    String name;
    String birthDay;
    LinkedHashSet<Person> parents;
    LinkedHashSet<Person> childrens;

    public Person(String name, String birthDay) {
        this.name = name;
        this.birthDay = birthDay;
        this.parents = new LinkedHashSet<>();
        this.childrens = new LinkedHashSet<>();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.name + " " + this.birthDay + "\n");
        sb.append("Parents:\n");
        for (Person parent : parents) {
            sb.append(parent.name + " " + parent.birthDay + "\n");
        }
        sb.append("Children:\n");
        for (Person children : childrens) {
            sb.append(children.name + " " + children.birthDay + "\n");
        }
        return sb.toString();
    }
}

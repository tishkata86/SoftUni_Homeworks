import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class Problem12_ThePartyReservationFilterList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> names = Arrays.asList(sc.nextLine().split("\\s+"));
        List<String> tempNames = new ArrayList<>(names);
        String line;
        while (!"Print".equals(line = sc.nextLine())) {
            String[] commands = line.split(";");
            String addOrRemove = commands[0];
            String starEndLengthContains = commands[1];
            String filterBy = commands[2];

            Predicate<String> condition = FilterBy(starEndLengthContains, filterBy);

            if (addOrRemove.equals("Add filter")) {
                tempNames = AddingFilter(names, tempNames, condition);
            } else if (addOrRemove.equals("Remove filter")) {
                tempNames = RemovingFilter(names, tempNames, condition);
            }
        }

        if (tempNames.size() > 0){
            for (String name : names) {
                if (tempNames.contains(name)){
                    System.out.print(name  + " ");
                }
            }
            System.out.println();
        }
    }

    private static List<String> RemovingFilter(List<String> names, List<String> tempNames, Predicate<String> condition) {
        for (String name : names) {
            if (condition.test(name)) {
                if (!tempNames.contains(name)) {
                    tempNames.add(name);
                }
            }
        }

        return tempNames;

    }

    private static List<String> AddingFilter(List<String> names, List<String> tempNames, Predicate<String> condition) {
        for (String name : names) {
            if (condition.test(name)) {
                if (tempNames.contains(name)) {
                    tempNames.remove(name);
                }
            }
        }

        return tempNames;
    }

    private static Predicate<String> FilterBy(String starEndLengthContains, String filterBy) {
        Predicate<String> filter;

        switch (starEndLengthContains) {
            case "Starts with":
                return filter = name -> name.startsWith(filterBy);
            case "Ends with":
                return filter = name -> name.endsWith(filterBy);
            case "Length":
                int length = Integer.parseInt(filterBy);
                return filter = name -> name.length() == length;
            case "Contains":
                return filter = name -> name.contains(filterBy);
        }
        return null;
    }
}

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Problem11_PredicateParty {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine().trim();
        List<String> names = Arrays.stream(line.split(" ")).collect(Collectors.toList());
        String nextLine;
        while (!"Party!".equals(nextLine = sc.nextLine())) {
            nextLine = nextLine.trim();
            String[] commands = nextLine.split(" ");
            String removeOrDouble = commands[0];
            String startEndOrLength = commands[1];
            List<String> result = new ArrayList<>();
            switch (removeOrDouble) {
                case "Remove":
                    switch (startEndOrLength) {
                        case "StartsWith":
                            String prefix = commands[2];
                            Predicate<String> isStartWith = name -> name.startsWith(prefix);
                            for (int i = 0; i < names.size(); i++) {
                                if (!isStartWith.test(names.get(i))) {
                                    result.add(names.get(i));
                                }
                            }
                            break;
                        case "EndsWith":
                            String suffix = commands[2];
                            Predicate<String> isEndWith = name -> name.endsWith(suffix);
                            for (int i = 0; i < names.size(); i++) {
                                if (!isEndWith.test(names.get(i))) {
                                    result.add(names.get(i));
                                }
                            }
                            break;
                        case "Length":
                            int length = Integer.parseInt(commands[2]);
                            Predicate<String> isEqualLength = name -> name.length() == length;
                            for (int i = 0; i < names.size(); i++) {
                                if (!isEqualLength.test(names.get(i))) {
                                    result.add(names.get(i));
                                }
                            }
                            break;
                    }
                    break;
                case "Double":
                    switch (startEndOrLength) {
                        case "StartsWith":
                            String prefix = commands[2];
                            Predicate<String> isStartWith = name -> name.startsWith(prefix);
                            for (int i = 0; i < names.size(); i++) {
                                if (isStartWith.test(names.get(i))) {
                                    result.add(names.get(i));
                                    result.add(names.get(i));
                                } else {
                                    result.add(names.get(i));
                                }
                            }
                            break;
                        case "EndsWith":
                            String suffix = commands[2];
                            Predicate<String> isEndWith = name -> name.endsWith(suffix);
                            for (int i = 0; i < names.size(); i++) {
                                if (isEndWith.test(names.get(i))) {
                                    result.add(names.get(i));
                                    result.add(names.get(i));
                                } else {
                                    result.add(names.get(i));
                                }
                            }
                            break;
                        case "Length":
                            int length = Integer.parseInt(commands[2]);
                            Predicate<String> isEqualLength = name -> name.length() == length;
                            for (int i = 0; i < names.size(); i++) {
                                if (isEqualLength.test(names.get(i))) {
                                    result.add(names.get(i));
                                    result.add(names.get(i));
                                } else {
                                    result.add(names.get(i));
                                }
                            }
                            break;
                    }
                    break;
            }
            names = new ArrayList<>(result);
        }

        if (names.size() > 0) {
            boolean isFirst = true;
            for (String name : names) {
                if (isFirst) {
                    System.out.print(name);
                    isFirst = false;
                } else {
                    System.out.printf(", %s", name);
                }
            }
            System.out.println(" are going to the party!");
        } else {
            System.out.println("Nobody is going to the party!");
        }
    }
}

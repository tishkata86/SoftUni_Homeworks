import java.util.Scanner;
import java.util.function.Predicate;

public class Problem07_PredicateForNames {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.nextLine();
        String[] names = sc.nextLine().split("\\s+");
        Predicate<String> isTrue = name -> name.length() <= num;
        for (String name : names) {
            if (isTrue.test(name)){
                System.out.println(name);
            }
        }

    }
}

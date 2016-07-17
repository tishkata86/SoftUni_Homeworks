import java.util.LinkedHashSet;
import java.util.Scanner;

public class Problem02_SetsOfElements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] setsSize = sc.nextLine().split("\\s+");
        int first = Integer.parseInt(setsSize[0]);
        int second = Integer.parseInt(setsSize[1]);
        LinkedHashSet<Integer> firstSet = new LinkedHashSet<>();
        LinkedHashSet<Integer> secondSet = new LinkedHashSet<>();
        LinkedHashSet<Integer> finalSet = new LinkedHashSet<>();

        for (int i = 0; i < first; i++) {
            firstSet.add(Integer.parseInt(sc.nextLine()));
        }
        for (int i = 0; i < second; i++) {
            secondSet.add(Integer.parseInt(sc.nextLine()));
        }

        for (Integer integer : firstSet) {
            for (Integer integer1 : secondSet) {
                if (secondSet.contains(integer)){
                    finalSet.add(integer);
                }
            }
        }

        for (Integer integer : finalSet) {
            System.out.print(integer + " ");
        }


    }
}

package Problem03_04_GenericSwapMethodStrings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        List<Box> data;

        int lines = Integer.parseInt(sc.readLine());

        // String swap Problem_03
//        data = StringSwap(lines);

        // Integer swap Problem_04
        data = IntegerSwap(lines);

        int[] indexes = Arrays.stream(sc.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        Box temp = data.get(indexes[0]);
        data.set(indexes[0], data.get(indexes[1]));
        data.set(indexes[1], temp);

        for (Box box : data) {
            System.out.println(box);
        }
    }

    private static List<Box> IntegerSwap(int lines) throws IOException {
        List<Box> currentList = new ArrayList<>();
        for (int i = 0; i < lines; i++) {
            int input = Integer.valueOf(sc.readLine());
            currentList.add(new Box(input));
        }

        return currentList;
    }

    private static List<Box> StringSwap(int lines) throws IOException {
        List<Box> currentList = new ArrayList<>();
        for (int i = 0; i < lines; i++) {
            String input = sc.readLine();
            currentList.add(new Box(input));
        }

        return currentList;
    }
}

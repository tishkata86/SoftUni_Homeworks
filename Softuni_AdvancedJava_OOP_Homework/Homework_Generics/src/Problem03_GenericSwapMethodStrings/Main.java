package Problem03_GenericSwapMethodStrings;

import Problem03_GenericSwapMethodStrings.Box;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        List<Box> data = new ArrayList<>();

        int lines = Integer.parseInt(sc.readLine());
        for (int i = 0; i < lines; i++) {
            data.add(new Box(sc.readLine()));
        }
        int[] indexes = Arrays.stream(sc.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        Box temp = data.get(indexes[0]);
        data.set(indexes[0],data.get(indexes[1]));
        data.set(indexes[1], temp);

        for (Box box : data) {
            System.out.println(box);
        }
    }
}

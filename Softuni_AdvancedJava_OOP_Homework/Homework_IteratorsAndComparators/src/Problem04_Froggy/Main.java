package Problem04_Froggy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        String[] elements = sc.readLine().split("[,\\s]+");
        Integer[] elementsAsInt = new Integer[elements.length];
        for (int i = 0; i < elements.length; i++) {
            elementsAsInt[i] = Integer.parseInt(elements[i]);
        }

        Lake lake = new Lake(elementsAsInt);
        StringBuilder sb = new StringBuilder();
        for (Integer integer : lake) {
            sb.append(integer).append(", ");
        }

        sb.setLength(sb.length() - 2);
        System.out.println(sb.toString());

    }
}

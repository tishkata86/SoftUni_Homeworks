package Problem10_Tuple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        String[] firstLine = sc.readLine().split("\\s+");
        String fullName = firstLine[0] + " " + firstLine[1];
        String address = firstLine[2];

        String[] secondLine = sc.readLine().split("\\s+");
        String name = secondLine[0];
        int beerCount = Integer.parseInt(secondLine[1]);

        String[] thirdLine = sc.readLine().split("\\s+");
        int integer = Integer.parseInt(thirdLine[0]);
        double doubleNum = Double.parseDouble(thirdLine[1]);

        Tuple tuple = null;

        tuple = new Tuple(fullName, address);
        System.out.println(tuple);

        tuple = new Tuple(name, beerCount);
        System.out.println(tuple);

        tuple = new Tuple(integer, doubleNum);
        System.out.println(tuple);
    }
}

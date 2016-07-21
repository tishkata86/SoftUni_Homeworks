package Problem10_11_Tuple_Threeuple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        //    TupleCreater();
        ThreeupleCreater();
    }

    private static void ThreeupleCreater() throws IOException {
        String[] firstLine = sc.readLine().split("\\s+");
        String fullName = firstLine[0] + " " + firstLine[1];
        String address = firstLine[2];
        String town = firstLine[3];

        String[] secondLine = sc.readLine().split("\\s+");
        String name = secondLine[0];
        int beerCount = Integer.parseInt(secondLine[1]);
        boolean drunkOrNot = secondLine[2].equals("drunk");

        String[] thirdLine = sc.readLine().split("\\s+");
        String someName = thirdLine[0];
        double doubleNum = Double.parseDouble(thirdLine[1]);
        String bankName = thirdLine[2];

        Threeuple tuple = null;

        tuple = new Threeuple(fullName, address, town);
        System.out.println(tuple);

        tuple = new Threeuple(name, beerCount, drunkOrNot);
        System.out.println(tuple);

        tuple = new Threeuple(someName, doubleNum, bankName);
        System.out.println(tuple);
    }

    private static void TupleCreater() throws IOException {

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

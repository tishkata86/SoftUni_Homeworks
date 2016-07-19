package Problem05_06_GenericCountMethodStrings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        List<Box> data = new ArrayList<>();

        int lines = Integer.valueOf(sc.readLine());

        //adding strings
//        data = StringComparableListAdding(lines);
//        String searching = sc.readLine();
//        int count = CompareStringValues(searching, data);


        //adding doubles
        data = DoubleComparableListAdding(lines);
        String searching = sc.readLine();
        int count = CompareDoubleValues(searching, data);


        System.out.println(count);

    }

    private static int CompareDoubleValues(String searching, List<Box> data) {
        int count = 0;
        for (Box box : data) {
            if (box.compareTo(searching) > 0){
                count++;
            }
        }

        return count;
    }

    private static int CompareStringValues(String searching, List<Box> data) {
        int count = 0;
        for (Box box : data) {
            if (box.getValue().toString().compareTo(searching) > 0){
                count++;
            }
        }

        return count;
    }

    private static List<Box> StringComparableListAdding(int lines) throws IOException {
        List<Box> currentList = new ArrayList<>();
        for (int i = 0; i < lines; i++) {
            currentList.add(new Box(sc.readLine()));
        }

        return currentList;
    }

    private static List<Box> DoubleComparableListAdding(int lines) throws IOException {
        List<Box> currentList = new ArrayList<>();
        for (int i = 0; i < lines; i++) {
            currentList.add(new Box(Double.valueOf(sc.readLine())));
        }

        return currentList;
    }

}


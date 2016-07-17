package Problem09_CollectionHierarchy;

import Problem09_CollectionHierarchy.models.AddCollection;
import Problem09_CollectionHierarchy.models.AddRemoveCollection;
import Problem09_CollectionHierarchy.models.MyList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = reader.readLine().split("\\s+");

        AddCollection addCollection = new AddCollection();
        AddRemoveCollection addRemoveCollection = new AddRemoveCollection();
        MyList myCollection = new MyList();

        System.out.println(addElements(addCollection, strings));
        System.out.println(addElements(addRemoveCollection, strings));
        System.out.println(addElements(myCollection, strings));

        int n = Integer.parseInt(reader.readLine().trim());

        System.out.println(removeElement(addRemoveCollection, n));
        System.out.println(removeElement(myCollection, n));

    }

    private static String removeElement(AddRemoveCollection collection, int n) {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < n; i++) {
            output.append(collection.remove()).append(" ");
        }

        return output.toString().trim();
    }

    private static String addElements(AddCollection collection, String[] strings) {
        StringBuilder output = new StringBuilder("");
        for(String string : strings){
            if(!string.equals("")) {
                output.append(collection.addToCollection(string)).append(" ");
            }
        }

        return output.toString().trim();
    }
}

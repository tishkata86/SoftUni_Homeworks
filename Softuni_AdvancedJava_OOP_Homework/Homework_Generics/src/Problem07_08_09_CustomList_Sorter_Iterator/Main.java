package Problem07_08_09_CustomList_Sorter_Iterator;

import Problem07_08_09_CustomList_Sorter_Iterator.interfaces.CustomList;
import Problem07_08_09_CustomList_Sorter_Iterator.interfaces.Sorter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        CustomList<String> elements = new CustomListImpl<>();
        Sorter<String> sorter = new SorterImpl<>();

        String line;
        while (!"END".equals(line = sc.readLine())){
            String[] params = line.split("\\s+");

            switch (params[0]){
                case "Add":
                    elements.add(params[1]);
                    break;
                case "Remove":
                    elements.remove(Integer.parseInt(params[1]));
                    break;
                case "Contains":
                    System.out.println(elements.contains(params[1]));
                    break;
                case "Swap":
                    elements.swap(Integer.parseInt(params[1]), Integer.parseInt(params[2]));
                    break;
                case "Greater":
                    System.out.println(elements.countGreaterThan(params[1]));
                    break;
                case "Max":
                    System.out.println(elements.getMax());
                    break;
                case "Min":
                    System.out.println(elements.getMin());
                    break;
                case "Print":
                    for (String element : elements) {
                        System.out.println(element);
                    }
                    break;
                case "Sort":
                    sorter.sort(elements);
                    break;
            }
        }
    }
}

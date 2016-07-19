package Problem07_CustomList;

import Problem07_CustomList.interfaces.CustomList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        CustomList<String> elements = new CustomListImpl<>();

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
                    System.out.print(elements);
            }
        }
    }
}

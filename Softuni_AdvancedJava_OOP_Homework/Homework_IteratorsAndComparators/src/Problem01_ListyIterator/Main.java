package Problem01_ListyIterator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        ListyIterator iterator = new ListyIteratorImpl();

        String line = sc.readLine();
        String[] createParams = Arrays.asList(line.split("\\s+"))
                .subList(1, line.split("\\s+").length)
                .toArray(new String[line.split("\\s+").length - 1]);
        iterator.Create(createParams);

        while (!"END".equals(line = sc.readLine())){
            String[] commands = line.split("\\s+");

            switch (commands[0]){
                case "Move":
                    System.out.println(iterator.Move());
                    break;
                case "HasNext":
                    System.out.println(iterator.HasNext());
                    break;
                case "Print":
                    iterator.Print();
            }
        }

    }
}

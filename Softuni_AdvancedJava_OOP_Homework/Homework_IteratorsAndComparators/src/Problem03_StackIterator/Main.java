package Problem03_StackIterator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        StackIterator<Integer> stackIterator = new StackIteratorImpl<>();

        String line;
        while (!"END".equals(line = sc.readLine())){
            String[] params = line.split("[\\s,]");
            switch (params[0]){
                case "Push":
                    List<Integer> integers = Arrays.stream(params)
                            .skip(1)
                            .filter(element -> !element.equals(""))
                            .map(Integer::parseInt)
                            .collect(Collectors.toList());
                    stackIterator.push(integers);
                    break;
                case "Pop":
                    stackIterator.pop();
                    break;
            }
        }

        for (Integer integer : stackIterator) {
            System.out.println(integer);
        }
        for (Integer integer : stackIterator) {
            System.out.println(integer);
        }
    }
}

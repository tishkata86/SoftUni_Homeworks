package Problem01_02_GenericBox;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        int lines = Integer.parseInt(sc.readLine());
        for (int i = 0; i < lines; i++) {
            String string = sc.readLine();
            try {
                int integer = Integer.valueOf(string);
                Box box = new Box(integer);
                System.out.println(box);
                continue;

            }   catch (Exception e){
            }
            Box box = new Box(string);
            System.out.println(box);
        }
    }
}

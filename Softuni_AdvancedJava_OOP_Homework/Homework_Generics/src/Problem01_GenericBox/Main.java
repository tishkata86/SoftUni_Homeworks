package Problem01_GenericBox;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        int lines = Integer.parseInt(sc.readLine());
        for (int i = 0; i < lines; i++) {
            Box box = new Box(sc.readLine());
            System.out.println(box);
        }
    }
}

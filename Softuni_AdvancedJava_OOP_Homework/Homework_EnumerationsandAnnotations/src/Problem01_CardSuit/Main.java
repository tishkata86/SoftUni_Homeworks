package Problem01_CardSuit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        String line;
        while ("Card Suits".equals(line = sc.readLine())){
            System.out.println("Card Suits:");
            for (int i = 0; i < CardSuit.values().length; i++) {
                System.out.println("Ordinal value: " + i + "; Name value: " + CardSuit.values()[i]);
            }
        }


    }
}

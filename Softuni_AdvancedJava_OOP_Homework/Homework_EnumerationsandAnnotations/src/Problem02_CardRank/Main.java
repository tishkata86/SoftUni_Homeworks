package Problem02_CardRank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        String line;
        while ("Card Ranks".equals(line = sc.readLine())){
            System.out.println("Card Ranks:");
            for (int i = 0; i < CardRank.values().length; i++) {
                System.out.println("Ordinal value: " + i + "; Name value: " + CardRank.values()[i]);
            }
        }
    }
}

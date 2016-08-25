package Problem04_CardToString;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        String cardRank = sc.readLine();
        String cardSuit = sc.readLine();

        System.out.println(new Card(cardRank, cardSuit));
    }
}

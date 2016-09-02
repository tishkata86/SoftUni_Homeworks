package Problem07_DeckOfCards;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        String line = sc.readLine();
        if (line.equals("Card Deck")){
            for (int i = 0; i < Suit.values().length; i++) {
                for (int j = 0; j < Rank.values().length; j++) {
                    System.out.println(Rank.values()[j] + " of " + Suit.values()[i]);
                }
            }
        }
    }
}

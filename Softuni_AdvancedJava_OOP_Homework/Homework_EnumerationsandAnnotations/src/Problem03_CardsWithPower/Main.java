package Problem03_CardsWithPower;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        String cardRank = sc.readLine();
        String cardSuit = sc.readLine();

        System.out.printf("Card name: %s of %s; Card power: %d", CardsRank.valueOf(cardRank),
                CardsSuit.valueOf(cardSuit),
                CardsRank.valueOf(cardRank).getCardPower() + CardsSuit.valueOf(cardSuit).getPower());
    }
}

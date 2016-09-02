package Problem08_CardGame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        String firstPlayer = sc.readLine();
        String secondPlayer = sc.readLine();

        HashMap<Card, Integer> firstPlayerDeck = new HashMap<>();
        HashMap<Card, Integer> secondPlayerDeck = new HashMap<>();

        String[] input;
        String cardRank;
        String cardSuit;
        Card currentCard;
        int maxValue = 0;
        while (firstPlayerDeck.size() < 5 || secondPlayerDeck.size() < 5) {
            try {
                input = sc.readLine().split("\\s+");
                cardRank = input[0];
                cardSuit = input[2];

                currentCard = new Card(cardRank, cardSuit);
                if (firstPlayerDeck.size() < 5) {
                    if (firstPlayerDeck.containsValue(currentCard.getCardValue())) {
                        throw new IllegalArgumentException("Card is not in the deck.");
                    } else {
                        firstPlayerDeck.put(currentCard, currentCard.getCardValue());
                        if (currentCard.getCardValue() > maxValue){
                            maxValue = currentCard.getCardValue();
                        }
                    }
                } else if (firstPlayerDeck.size() == 5 && secondPlayerDeck.size() < 5){
                    if (firstPlayerDeck.containsValue(currentCard.getCardValue()) ||
                            secondPlayerDeck.containsValue(currentCard.getCardValue())) {
                        throw new IllegalArgumentException("Card is not in the deck.");
                    } else {
                        secondPlayerDeck.put(currentCard, currentCard.getCardValue());
                        if (currentCard.getCardValue() > maxValue) {
                            maxValue = currentCard.getCardValue();
                        }
                    }
                }
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
        }

        for (Map.Entry<Card, Integer> cardIntegerEntry : firstPlayerDeck.entrySet()) {
            if (cardIntegerEntry.getValue() == maxValue){
                System.out.println(firstPlayer + " wins with " + cardIntegerEntry.getKey());
            }
        }

        for (Map.Entry<Card, Integer> cardIntegerEntry : secondPlayerDeck.entrySet()) {
            if (cardIntegerEntry.getValue() == maxValue){
                System.out.println(secondPlayer + " wins with " + cardIntegerEntry.getKey());
            }
        }
    }

}

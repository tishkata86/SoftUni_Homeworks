package Problem04_05_06_CardToString_CardCompareTo_CustonAnnotation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        //problem 04
//        String cardRank = sc.readLine();
//        String cardSuit = sc.readLine();
//
//        System.out.println(new Card(cardRank, cardSuit));

        //problem 05
//        String firstCardRank = sc.readLine();
//        String firstCardSuit = sc.readLine();
//        String secondCardRank = sc.readLine();
//        String secondCardSuit = sc.readLine();
//
//        Card firstCard = new Card(firstCardRank, firstCardSuit);
//        Card secondCard = new Card(secondCardRank, secondCardSuit);
//
//        System.out.println(firstCard.compareTo(secondCard) > -1 ? firstCard : secondCard);

        //problem06
        String info = sc.readLine();

        Class<CardsRank> clRank = CardsRank.class;
        Class<CardsSuit> clSuit = CardsSuit.class;
        EnumInfo enumInfoRank = clRank.getAnnotation(EnumInfo.class);
        EnumInfo enumInfoSuit = clSuit.getAnnotation(EnumInfo.class);

        if (enumInfoRank.category().equals(info)) {
            System.out.println("Type = " + enumInfoRank.type() + ", Description = " + enumInfoRank.description());
        }
        else if (enumInfoSuit.category().equals(info)) {
            System.out.println("Type = " + enumInfoSuit.type() + ", Description = " + enumInfoSuit.description());
        }
    }
}

package Problem04_05_06_CardToString_CardCompareTo_CustonAnnotation;

public class Card implements Comparable<Card>{

    private CardsRank cardsRank;
    private CardsSuit cardsSuit;

    public Card(String cardsRank, String cardsSuit) {
        this.cardsRank = CardsRank.valueOf(cardsRank);
        this.cardsSuit = CardsSuit.valueOf(cardsSuit);
    }

    public int getPower(){
        return this.cardsRank.getPower() + this.cardsSuit.getPower();
    }

    @Override
    public String toString() {
        return String.format("Card name: %s of %s; Card power: %d", this.cardsRank,
                this.cardsSuit,
                getPower());
    }

    @Override
    public int compareTo(Card anotherCard) {
        return Integer.compare(this.getPower(), anotherCard.getPower());
    }
}

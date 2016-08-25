package Problem04_CardToString;

public class Card {
    private CardsRank cardsRank;
    private CardsSuit cardsSuit;

    public Card(String cardsRank, String cardsSuit) {
        this.cardsRank = CardsRank.valueOf(cardsRank);
        this.cardsSuit = CardsSuit.valueOf(cardsSuit);
    }

    @Override
    public String toString() {
        return String.format("Card name: %s of %s; Card power: %d", this.cardsRank,
                this.cardsSuit,
                this.cardsRank.getCardPower() + this.cardsSuit.getPower());
    }
}

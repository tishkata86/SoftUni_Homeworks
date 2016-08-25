package Problem04_05_06_CardToString_CardCompareTo_CustonAnnotation;

@EnumInfo(category = "Suit", description = "Provides suit constants for a Card class.")

public enum CardsSuit {
    CLUBS(0),
    DIAMONDS(13),
    HEARTS(26),
    SPADES(39);

    private int power;

    CardsSuit(int i) {
        this.power = i;
    }

    public int getPower(){
        return this.power;
    }
}

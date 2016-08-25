package Problem04_CardToString;

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

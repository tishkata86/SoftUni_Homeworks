package Problem08_CardGame;

public enum SuitPower {

    CLUBS(0),
    DIAMONDS(13),
    HEARTS(26),
    SPADES(39);

    int power;

    SuitPower(int currentPower){
        this.power = currentPower;
    }
}

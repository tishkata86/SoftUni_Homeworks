package Problem04_05_06_CardToString_CardCompareTo_CustonAnnotation;

@EnumInfo(category = "Rank", description = "Provides rank constants for a Card class.")

public enum CardsRank {
    ACE(14),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    JACK(11),
    QUEEN(12),
    KING(13);

    private int power;

    CardsRank(int num){
        this.power = num;
    }

    public int getPower(){
        return this.power;
    }


}

package Problem08_CardGame;

public class Card {

    private RankPower rankPower;
    private SuitPower suitPower;

    public Card(String rankPower, String suitPower) {
        this.setRankPower(rankPower);
        this.setSuitPower(suitPower);
    }

    public RankPower getRankPower() {
        return rankPower;
    }

    private void setRankPower(String rankPower) {
        try {
            this.rankPower = RankPower.valueOf(rankPower);
        } catch (Exception ex) {
            throw new IllegalArgumentException("No such card exists.");
        }
    }

    public SuitPower getSuitPower() {
        return suitPower;
    }

    private void setSuitPower(String suitPower) {
        try {
            this.suitPower = SuitPower.valueOf(suitPower);
        } catch (Exception ex) {
            throw new IllegalArgumentException("No such card exists.");
        }
    }

    public int getCardValue() {
        return this.rankPower.power + this.suitPower.power;
    }

    @Override
    public String toString() {
        return this.rankPower.toString() + " of " + this.suitPower.toString() + ".";
    }



}

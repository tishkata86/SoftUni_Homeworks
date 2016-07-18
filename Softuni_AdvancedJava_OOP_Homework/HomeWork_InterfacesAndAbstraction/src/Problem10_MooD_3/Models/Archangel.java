package Problem10_MooD_3.Models;

public class Archangel extends PlayerImpl{
    private int mana;

    public Archangel(String username, Object specialPoint, int level) {
        super(username, specialPoint, level);
        this.setMana((int)specialPoint);
    }

    public int getMana() {
        return mana;
    }

    private void setMana(int mana) {
        this.mana = mana;
    }

    @Override
    protected String setPassword() {
        String pass = new StringBuilder(this.getUsername()).reverse().toString();

        return pass + (this.getUsername().length() * 21);
    }

    @Override
    public String toString() {
        return super.toString() + (this.getMana() * this.getLevel());
    }
}

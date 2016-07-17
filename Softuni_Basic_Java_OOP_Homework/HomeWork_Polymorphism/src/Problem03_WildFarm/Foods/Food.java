package Problem03_WildFarm.Foods;

public abstract class Food {
    private int quantities;

    public Food(int quantities) {
        this.quantities = quantities;
    }

    public int getQuantities() {
        return quantities;
    }

    public void setQuantities(int quantities) {
        this.quantities = quantities;
    }
}

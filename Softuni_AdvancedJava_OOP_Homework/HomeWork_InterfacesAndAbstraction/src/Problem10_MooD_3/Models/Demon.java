package Problem10_MooD_3.Models;

public class Demon extends PlayerImpl {
    private double energy;

    public Demon(String username, Object specialPoint, int level) {
        super(username, specialPoint, level);
        this.setEnergy((double)specialPoint);
    }

    public double getEnergy() {
        return energy;
    }

    private void setEnergy(double energy) {
        this.energy = energy;
    }

    @Override
    protected String setPassword() {
        return (this.getUsername().length() * 217) + "";
    }

    @Override
    public String toString() {
        return super.toString() + (this.getEnergy() * this.getLevel());
    }
}

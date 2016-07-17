package Problem03_WildFarm.Animals;

import java.text.DecimalFormat;

public class Mammal extends Animal {
    private String livingRegion;

    public Mammal(String animalName, String animalType, double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight);
        this.setLivingRegion(livingRegion);
    }

    public String getLivingRegion() {
        return livingRegion;
    }

    public void setLivingRegion(String livingRegion) {
        this.livingRegion = livingRegion;
    }


    @Override
    public String toString() {
        DecimalFormat dc = new DecimalFormat("0.######");
        return String.format("%s[%s, %s, %s, %d]\n",
                this.getAnimalType(),
                this.getAnimalName(),
                dc.format(this.getAnimalWeight()),
                this.getLivingRegion(),
                this.getFoodEaten());
    }
}

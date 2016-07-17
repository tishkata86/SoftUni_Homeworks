package Problem05_PizzaCalories;

public class Dough {
    private String flourType;
    private String technique;
    private double weightInGrams;
    private double flourModifier;
    private double techniqueModifier;

    public Dough(String flourType, String technique, double weightInGrams) {
        setFlourType(flourType);
        setTechnique(technique);
        setWeightInGrams(weightInGrams);
    }

    private void setFlourType(String flourType) {
        switch (flourType.toLowerCase()) {
            case "white":
                this.flourModifier = 1.5;
                break;
            case "wholegrain":
                this.flourModifier = 1.0;
                break;
            default:
                throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.flourType = flourType;
    }

    private void setTechnique(String technique) {
        switch (technique.toLowerCase()) {
            case "crispy":
                this.techniqueModifier = 0.9;
                break;
            case "chewy":
                this.techniqueModifier = 1.1;
                break;
            case "homemade":
                this.techniqueModifier = 1.0;
                break;
            default:
                throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.technique = technique;
    }

    private void setWeightInGrams(double weightInGrams) {
        if (weightInGrams < 1.0 || weightInGrams > 200.0) {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
        this.weightInGrams = weightInGrams;
    }

    public double CaloriesPerGram() {
        return (this.weightInGrams * 2) * this.flourModifier * this.techniqueModifier;
    }
}

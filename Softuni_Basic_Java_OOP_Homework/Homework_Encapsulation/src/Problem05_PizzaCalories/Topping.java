package Problem05_PizzaCalories;

public class Topping {
    private String type;
    private double weight;
    private double typeModifier;

    public Topping(String type, double weight) {
        setType(type);
        setWeight(weight);
    }

    private void setType(String type) {
        switch (type.toLowerCase()) {
            case "meat":
                this.typeModifier = 1.2;
                break;
            case "veggies":
                this.typeModifier = 0.8;
                break;
            case "cheese":
                this.typeModifier = 1.1;
                break;
            case "sauce":
                this.typeModifier = 0.9;
                break;
            default:
                throw new IllegalArgumentException(String.format("Cannot place %s on top of your pizza.", type));
        }
        this.type = type;
    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 50) {
            throw new IllegalArgumentException(String.format("%s weight should be in the range [1..50].", this.type));
        }
        this.weight = weight;
    }

    public double CaloriesPerGram() {
        return (this.weight * 2) * this.typeModifier;
    }
}

package Problem07_CarSalesman;

public class Car {
    String model;
    Engine engine;
    int weight;
    String color;

    public Car(String model, Engine engine, int weight, String color) {
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.color = color;
    }

    public Car(String model, Engine engine) {
        this(model, engine, -1, "n/a");
    }

    public Car(String model, Engine engine, int weight) {
        this(model, engine, weight, "n/a");
    }

    public Car(String model, Engine engine, String color) {
        this(model, engine, -1, color);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.model + ":\n");
        sb.append("  " + this.engine.model + ":\n");
        sb.append("    Power: " + this.engine.power + "\n");
        if (this.engine.displacement == -1) {
            sb.append("    Displacement: n/a\n");
        } else {
            sb.append("    Displacement: " + this.engine.displacement + "\n");
        }
        sb.append("    Efficiency: " + this.engine.efficiency + "\n");
        if (this.weight == -1) {
            sb.append("  Weight: n/a\n");
        } else {
            sb.append("  Weight: " + this.weight + "\n");
        }
        sb.append("  Color: " + this.color);
        return sb.toString();
    }
}

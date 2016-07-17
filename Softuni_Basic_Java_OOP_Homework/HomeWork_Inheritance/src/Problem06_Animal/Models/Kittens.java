package Problem06_Animal.Models;

public class Kittens extends Cat {

    public Kittens(String name, int age) {
        super(name, age, "Female");
    }

    @Override
    public String produceSound() {
        return "Miau";
    }
}

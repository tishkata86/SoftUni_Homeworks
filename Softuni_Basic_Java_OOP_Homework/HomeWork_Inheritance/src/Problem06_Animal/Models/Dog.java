package Problem06_Animal.Models;

import Problem06_Animal.Interfaces.SoundProducible;

public class Dog extends Animal implements SoundProducible{

    public Dog(String name, int age, String gender) {
        super(name, age, gender);
    }

    @Override
    public String produceSound() {
        return "BauBau";
    }
}

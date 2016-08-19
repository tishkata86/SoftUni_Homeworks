package Problem08_PetClinics.models;

public class Pet {

    private String name;
    private String age;
    private String kind;

    public Pet(String name, String age, String kind) {
        this.setName(name);
        this.setAge(age);
        this.setKind(kind);
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    private void setAge(String age) {
        this.age = age;
    }

    public String getKind() {
        return kind;
    }

    private void setKind(String kind) {
        this.kind = kind;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s", this.name, this.age, this.kind);
    }
}

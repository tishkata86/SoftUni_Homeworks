package Problem05_06_07_BorderControl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        List<Buyer> buyers = new ArrayList<>();

        int lines = Integer.parseInt(sc.readLine());
        for (int i = 0; i < lines; i++) {
            String[] params = sc.readLine().split("\\s+");
            String birthday;

            Citizen citizen = null;
            Rebel rebel = null;

            String name = params[0];
            int age = Integer.parseInt(params[1]);
            String idOrGroup = params[2];

            if (params.length == 4) {
                birthday = params[3];
                citizen = new Citizen(name, age, idOrGroup, birthday);
                buyers.add(citizen);

            } else if (params.length == 3) {
                rebel = new Rebel(name, age, idOrGroup);
                buyers.add(rebel);
            }
        }

        String line;
        while (!"End".equals(line = sc.readLine())) {
            for (Buyer buyer : buyers) {
                if (buyer.getName().equals(line)) {
                    buyer.buyFood();
                }
            }
        }

        System.out.println(buyers.stream().mapToInt(Buyer::getFood).sum());


    }
}

interface Birthday {
    String getBirthday();
}

interface Idable {
    String getId();
}

interface Buyer {
    int food = 0;
    int getFood();
    String getName();
    void buyFood();
}

class Rebel implements Buyer {
    private String name;
    private int age;
    private String group;
    private int food;

    public Rebel(String name, int age, String group) {
        this.setName(name);
        this.setAge(age);
        this.setGroup(group);
        this.food = 0;
    }

    @Override
    public int getFood() {
        return food;
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    private void setAge(int age) {
        this.age = age;
    }

    public String getGroup() {
        return group;
    }

    private void setGroup(String group) {
        this.group = group;
    }

    @Override
    public void buyFood() {
        this.food += 5;
    }
}

class Pet implements Birthday {
    private String name;
    private String birthday;

    public Pet(String name, String birthday) {
        this.setName(name);
        this.setBirthday(birthday);
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    @Override
    public String getBirthday() {
        return birthday;
    }
}

class Robot implements Idable {
    private String model;
    private String id;

    public Robot(String model, String id) {
        this.setModel(model);
        this.setId(id);
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

class Citizen implements Idable, Birthday, Buyer {
    private String name;
    private int age;
    private String id;
    private String birthday;
    private int food;

    public Citizen(String name, int age, String id, String birthday) {
        this.setName(name);
        this.setAge(age);
        this.setId(id);
        this.setBirthday(birthday);
        this.food = 0;
    }

    public String getBirthday() {
        return birthday;
    }

    private void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    @Override
    public int getFood() {
        return food;
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    private void setAge(int age) {
        this.age = age;
    }

    private void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public void buyFood() {
        this.food += 10;
    }
}

package Problem04_ShoppingSpree;

import java.util.LinkedList;
import java.util.List;

public class Person {
    private String name;
    private double money;
    private LinkedList<Product> bag;

    public Person(String name, double money) {
        setName(name);
        setMoney(money);
        this.bag = new LinkedList<>();
    }

    public String getName() {
        return name;
    }

    public List<Product> getBag() {
        return bag;
    }

    private void setName(String name) {
        if (name.equals("") || name.equals(null)){
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    private void setMoney(double money) {
        if (money < 0.0){
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
    }

    public void buyProduct(Product product){
        if (this.money >= product.getPrice()){
            this.money -= product.getPrice();
            bag.add(product);
            System.out.println(this.name + " bought " + product.getName());
        } else {
            System.out.printf("%s can't afford %s\n",this.name, product.getName());
        }
    }
}

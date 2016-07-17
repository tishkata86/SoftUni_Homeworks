package Problem04_ShoppingSpree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        LinkedList<Product> store = new LinkedList<>();
        LinkedList<Person> persons = new LinkedList<>();
        try{
            String[] people = sc.readLine().split(";");
            for (int i = 0; i < people.length; i++) {
                if (people[i].contains("=")){
                    String[] params = people[i].split("=");
                    String name = params[0].trim();
                    double money = Double.parseDouble(params[1].trim());
                    persons.add(new Person(name, money));
                }
            }

            String[] products = sc.readLine().split(";");
            for (int i = 0; i < products.length; i++) {
                if (products[i].contains("=")){
                    String[] params = products[i].split("=");
                    String productName = params[0].trim();
                    double price = Double.parseDouble(params[1].trim());
                    store.add(new Product(productName, price));
                }
            }

            String line;
            while (!"END".equals(line = sc.readLine())){
                String[] lineParams = line.split("\\s+");
                String personName = lineParams[0].trim();
                String productName = lineParams[1].trim();

                for (Person person : persons) {
                    if (person.getName().equals(personName)){
                        for (Product product : store) {
                            if (product.getName().equals(productName)){
                                person.buyProduct(product);
                            }
                        }
                    }
                }
            }

            for (Person person : persons) {
                if (person.getBag().size() == 0){
                    System.out.println(person.getName() + " - Nothing bought");
                } else {
                    System.out.print(person.getName() + " - ");
                    boolean isFrist = true;
                    for (Product product : person.getBag()) {
                        if (isFrist){
                            System.out.print(product.getName());
                            isFrist = false;
                        } else {
                            System.out.print(", " + product.getName());
                        }
                    }
                    System.out.println();
                }
            }


        } catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }
    }
}

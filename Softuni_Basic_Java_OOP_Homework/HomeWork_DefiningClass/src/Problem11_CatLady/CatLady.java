package Problem11_CatLady;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class CatLady {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        LinkedList<Cat> cats = new LinkedList<>();
        String line;
        while (!"End".equals(line = sc.readLine())){
            String[] params = line.trim().split("\\s+");
            String bread = params[0];
            String name = params[1];
            String info = params[2];

            Cat currentCat = new Cat(bread, name, info);
            cats.add(currentCat);
            }

        String catName = sc.readLine();
        for (Cat cat : cats) {
            if (cat.name.equals(catName)){
                System.out.println(cat.toString());
            }
        }
    }
}

class Cat{
    String bread;
    String name;
    String info;

    public Cat(String bread, String name, String info) {
        this.bread = bread;
        this.name = name;
        this.info = info;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s", this.bread, this.name, this.info);
    }
}
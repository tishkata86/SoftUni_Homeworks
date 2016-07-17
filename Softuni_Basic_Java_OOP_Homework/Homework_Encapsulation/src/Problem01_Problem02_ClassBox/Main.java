package Problem01_Problem02_ClassBox;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));Class boxClass = Box.class;
        Field[] fields = boxClass.getDeclaredFields();
        System.out.println(Arrays.asList(fields)
                .stream()
                .filter(f -> Modifier.isPrivate(f.getModifiers())).count());

        try {
            double length = Double.parseDouble(sc.readLine());
            double width = Double.parseDouble(sc.readLine());
            double height = Double.parseDouble(sc.readLine());
            Box currentBox = new Box(length, width, height);
            System.out.println(currentBox);
        } catch (ArithmeticException ex){
            System.out.println(ex.getMessage());
        }
    }
}
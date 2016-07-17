import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Problem01_MethodSayHello {
    public static void main(String[] args) throws ClassNotFoundException, IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        String name = sc.readLine();
        Person someone = new Person(name);
        someone.Method();

        Field[] fields = Person.class.getDeclaredFields();
        Method[] methods = Class.forName("Person").getDeclaredMethods();
        if (fields.length != 1 || methods.length != 1) {
            throw new ClassFormatError();
        }

    }
}
 class Person {
    String name;

    public Person(String name) {
        this.name = name;
    }

    public void Method() {
        System.out.println(this.name + " says \"Hello\"!");
    }
}
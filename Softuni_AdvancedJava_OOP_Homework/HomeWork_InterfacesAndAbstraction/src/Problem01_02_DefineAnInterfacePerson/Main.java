package Problem01_02_DefineAnInterfacePerson;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Class[] citizenInterfaces = Problem01_02_DefineAnInterfacePerson.Citizen.class.getInterfaces();
        if (Arrays.asList(citizenInterfaces).contains(Problem01_02_DefineAnInterfacePerson.Birthable.class)
                && Arrays.asList(citizenInterfaces).contains(Problem01_02_DefineAnInterfacePerson.Identifiable.class)) {
            Method[] methods = Problem01_02_DefineAnInterfacePerson.Birthable.class.getDeclaredMethods();
            System.out.println(methods.length);
            System.out.println(methods[0].getReturnType().getSimpleName());
            methods = Problem01_02_DefineAnInterfacePerson.Identifiable.class.getDeclaredMethods();
            System.out.println(methods.length);
            System.out.println(methods[0].getReturnType().getSimpleName());
            Scanner scanner = new Scanner(System.in);
            String name = scanner.nextLine();
            int age = Integer.parseInt(scanner.nextLine());
            String id = scanner.nextLine();
            String birthdate = scanner.nextLine();
            Identifiable identifiable = new Problem01_02_DefineAnInterfacePerson.Citizen(name,age,id,birthdate);
            Birthable birthable = new Problem01_02_DefineAnInterfacePerson.Citizen(name,age,id,birthdate);
        }
    }

}

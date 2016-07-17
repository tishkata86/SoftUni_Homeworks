import java.util.Scanner;
import java.util.function.Consumer;

public class Problem01_ConsumerPrint {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] names = sc.nextLine().split(" ");
        Consumer<String> consumer = name -> System.out.println(name);
        for (String name : names) {
            consumer.accept(name);
        }
    }
}

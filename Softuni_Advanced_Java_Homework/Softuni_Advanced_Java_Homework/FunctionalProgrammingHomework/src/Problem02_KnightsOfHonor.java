import java.util.Scanner;
        import java.util.function.BiConsumer;

public class Problem02_KnightsOfHonor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] names = sc.nextLine().split("\\s+");
        BiConsumer<String, String> consumer = (title, name) -> System.out.printf("%s %s\n", title, name);
        for (String name : names) {
            consumer.accept("Sir", name);
        }
    }
}

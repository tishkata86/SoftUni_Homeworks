import java.text.Collator;
import java.util.*;
import java.util.stream.Collectors;

public class Problem11_Palindromes {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String[] arr = input.split("[,?\\s!\\.]+");
        TreeSet<String> result = new TreeSet<>();

        for (String str : arr) {
            if (isPalindrome(str)) {
                result.add(str);
            }
        }
        System.out.println(result);
    }

    private static boolean isPalindrome(String str) {
        StringBuilder sb = new StringBuilder(str);

        if (str.equals(sb.reverse().toString())) {
            return true;
        }

        return false;
    }
}
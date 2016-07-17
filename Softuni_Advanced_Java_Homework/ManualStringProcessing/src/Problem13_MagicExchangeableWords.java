import java.util.HashSet;
import java.util.Scanner;

public class Problem13_MagicExchangeableWords {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] text = sc.nextLine().split("\\s+");
        HashSet<Character> set = new HashSet<>();
        int firstWordCharacters = 0;
        int secondWordCharacter = 0;

        for (int i = 0; i < text[0].length(); i++) {
            set.add(text[0].charAt(i));
        }
        firstWordCharacters = set.size();
        set = new HashSet<>();
        for (int i = 0; i < text[1].length(); i++) {
            set.add(text[1].charAt(i));
        }
        secondWordCharacter = set.size();

        System.out.println(firstWordCharacters == secondWordCharacter);

    }
}

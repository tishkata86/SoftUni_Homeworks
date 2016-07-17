import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem15_MelrahShake {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder text = new StringBuilder(sc.nextLine());
        StringBuilder word = new StringBuilder(sc.nextLine());

        while (word.length() > 0) {
            List<Integer> positions = new ArrayList<>();
            for (int i = 0; i < text.length(); i++) {
                if (text.charAt(i) == word.charAt(0)) {
                    if (word.length() == 1) {
                        positions.add(i);
                    } else {
                        for (int j = 1; j < word.length(); j++) {
                            if (i + j < text.length() && text.charAt(i + j) == word.charAt(j)) {
                                if (j == word.length() - 1) {
                                    positions.add(i);
                                    i = i + j;
                                }
                            } else {
                                break;
                            }
                        }
                    }
                }
            }

            if (positions.size() > 1) {
                int firstPosition = positions.get(0);
                int lastPosition = positions.get(positions.size() - 1);
                text.delete(lastPosition, lastPosition + word.length());
                text.delete(firstPosition, firstPosition + word.length());
                System.out.println("Shaked it.");

            } else if (positions.size() == 0){
                System.out.println("No shake.");
                break;
            } else {
                System.out.println("No shake.");
            }
            word.deleteCharAt(word.length() / 2);
        }

        if (word.length() == 0){
            System.out.println("No shake.");
        }
        System.out.println(text);
    }
}

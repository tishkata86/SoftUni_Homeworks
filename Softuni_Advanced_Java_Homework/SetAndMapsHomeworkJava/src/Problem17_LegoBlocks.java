import java.util.List;
import java.util.Scanner;

public class Problem17_LegoBlocks {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int lines = Integer.parseInt(sc.nextLine());
        String[][] firstArray = new String[lines][];
        String[][] secondArray = new String[lines][];

        for (int i = 0; i < lines; i++) {
            String text =sc.nextLine().trim();
            String[] input = text.split("\\s+");
            firstArray[i] = new String[input.length];
            for (int j = 0; j < input.length; j++) {
                firstArray[i][j] = input[j];
            }
        }

        for (int i = 0; i < lines; i++) {
            String text =sc.nextLine().trim();
            String[] input = text.split("\\s+");
            secondArray[i] = new String[input.length];
            for (int j = 0; j < input.length; j++) {
                secondArray[i][j] = input[j];
            }
        }

        int totalSum = 0;
        String[][] result = new String[lines][];
        for (int i = 0; i < lines; i++) {
            result[i] = new String[firstArray[i].length + secondArray[i].length];
            totalSum += result[i].length;
            for (int k = 0; k < firstArray[i].length; k++) {
                result[i][k] = firstArray[i][k];
            }
            int counter = secondArray[i].length - 1;
            for (int k = firstArray[i].length; k < result[i].length; k++) {
                result[i][k] = secondArray[i][counter];
                counter--;
            }
        }

        boolean isTrue = false;
        for (int i = 1; i < lines; i++) {
            if (result[i - 1].length != result[i].length){
                isTrue = true;
                break;
            }
        }

        if (isTrue){
            System.out.printf("The total number of cells is: %d", totalSum);
        } else {
            for (int i = 0; i < lines; i++) {
                boolean isFirst = true;
                System.out.print("[");
                for (int j = 0; j < result[i].length; j++) {
                    if (isFirst){
                        System.out.printf("%s", result[i][j]);
                        isFirst = false;
                    } else {
                        System.out.printf(", %s", result[i][j]);
                    }
                }
                System.out.print("]");
                System.out.println();
            }
        }
    }
}

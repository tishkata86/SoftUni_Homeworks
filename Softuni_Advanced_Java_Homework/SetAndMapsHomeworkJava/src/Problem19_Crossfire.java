import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Problem19_Crossfire {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int counter = 1;
        String[] dimentions = sc.nextLine().split(" ");
        int row = Integer.parseInt(dimentions[0]);
        int col = Integer.parseInt(dimentions[1]);
        int[][] matrix = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = counter;
                counter++;
            }
        }

        String input = sc.nextLine();
        while (!input.equals("Nuke it from orbit")) {
            String[] commands = input.split(" ");
            int bombRow = Integer.parseInt(commands[0]);
            int bombCol = Integer.parseInt(commands[1]);
            int radius = Integer.parseInt(commands[2]);

            if (bombRow >= 0 && bombRow < row && bombCol >= 0 && bombCol < col) {
                matrix[bombRow][bombCol] = 0;
            }
            for (int i = 1; i <= radius; i++) {
                long decRow = bombRow - i * 1l;
                long incRow = bombRow + i * 1l;
                long decCol = bombCol - i * 1l;
                long incCol = bombCol + i * 1l;
                if (decRow >= 0 && decRow < row) {
                    if (bombCol >= 0 && bombCol < col) {
                        matrix[bombRow - i][bombCol] = 0;
                    }
                }

                if (incRow < row && incRow >= 0) {
                    if (bombCol >= 0 && bombCol < col) {
                        matrix[bombRow + i][bombCol] = 0;

                    }
                }

                if (decCol >= 0 && decCol < col) {
                    if (bombRow >= 0 && bombRow < row) {
                        matrix[bombRow][bombCol - i] = 0;
                    }
                }

                if (incCol < col && incCol >= 0) {
                    if (bombRow >= 0 && bombRow < row) {
                        matrix[bombRow][bombCol + i] = 0;
                    }
                }
            }

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (matrix[i][j] == 0) {
                        for (int k = j; k < col - 1; k++) {
                            matrix[i][k] = matrix[i][k + 1];
                            matrix[i][k + 1] = 0;
                        }
                    }
                }
            }

            input = sc.nextLine();
        }
        boolean isTrue = false;
        for (int i = 0; i < row; i++) {
            isTrue = true;
            for (int j = 0; j < col; j++) {
                if (Arrays.stream(matrix[i]).sum() != 0) {
                    if (!(matrix[i][j] == 0)) {
                        System.out.print(matrix[i][j] + " ");
                    }
                } else {
                    isTrue = false;
                }
            }
            if (isTrue) {
                System.out.println();
            }
        }
    }
}

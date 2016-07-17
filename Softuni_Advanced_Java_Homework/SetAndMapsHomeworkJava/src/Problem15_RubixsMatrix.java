import java.util.Scanner;

public class Problem15_RubixsMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int counter = 1;
        String[] rowsCols = sc.nextLine().split(" ");
        int row = Integer.parseInt(rowsCols[0]);
        int col = Integer.parseInt(rowsCols[1]);
        int[][] matrix = new int[row][col];
        int lines = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = counter;
                counter++;
            }
        }
        counter = 1;

        for (int i = 0; i < lines; i++) {
            String[] input = sc.nextLine().split(" ");
            switch (input[1]) {
                case "up":
                    ShiftUp(matrix, input[0], input[2], row);
                    break;
                case "down":
                    ShiftDown(matrix, input[0], input[2], row);
                    break;
                case "left":
                    ShiftLeft(matrix, input[0], input[2], col);
                    break;
                case "right":
                    ShiftRight(matrix, input[0], input[2], col);
                    break;
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] != counter) {
                    SwapMatrix(matrix, counter, row, col, i, j);
                } else {
                    System.out.println("No swap required");
                }
                counter++;
            }
        }
    }

    private static int[][] SwapMatrix(int[][] matrix, int counter, int row, int col, int i, int j) {
        int foundedRow = 0;
        int foundedCol = 0;
        boolean isFound = false;
        for (int k = i; k < row; k++) {
            for (int l = 0; l < col; l++) {
                if (matrix[k][l] == counter){
                    foundedRow = k;
                    foundedCol = l;
                    isFound = true;
                    break;
                }
            }
            if (isFound){
                break;
            }
        }

        int oldValue = matrix[i][j];
        matrix[i][j] = matrix[foundedRow][foundedCol];
        matrix[foundedRow][foundedCol] = oldValue;
        PrintFounded(i , j, foundedRow, foundedCol);
        return matrix;
    }

    private static void PrintFounded(int row, int col, int foundedRow, int foundedCol) {
        System.out.printf("Swap (%d, %d) with (%d, %d)\n",row, col, foundedRow, foundedCol);
    }


    private static int[][] ShiftUp(int[][] matrix, String col, String shiftTimes, int rowSize) {
        int currentCol = Integer.parseInt(col);
        int times = Integer.parseInt(shiftTimes) % rowSize;
        for (int i = 0; i < times; i++) {
            int firstNum = matrix[0][currentCol];
            for (int j = 0; j < matrix.length - 1; j++) {
                matrix[j][currentCol] = matrix[j + 1][currentCol];
            }
            matrix[matrix.length - 1][currentCol] = firstNum;
        }
        return matrix;
    }

    private static int[][] ShiftDown(int[][] matrix, String col, String shiftTimes, int rowSize) {
        int currentCol = Integer.parseInt(col);
        int times = Integer.parseInt(shiftTimes) % rowSize;
        for (int i = 0; i < times; i++) {
            int lastNum = matrix[matrix.length - 1][currentCol];
            for (int j = matrix.length - 1; j > 0; j--) {
                matrix[j][currentCol] = matrix[j - 1][currentCol];
            }
            matrix[0][currentCol] = lastNum;
        }
        return matrix;
    }

    private static int[][] ShiftLeft(int[][] matrix, String row, String shiftTimes, int colSize) {
        int currentRow = Integer.parseInt(row);
        int times = Integer.parseInt(shiftTimes) % colSize;
        for (int i = 0; i < times; i++) {
            int firstNum = matrix[currentRow][0];
            for (int j = 0; j < matrix[currentRow].length - 1; j++) {
                matrix[currentRow][j] = matrix[currentRow][j + 1];
            }
            matrix[currentRow][matrix[currentRow].length - 1] = firstNum;
        }
        return matrix;
    }

    private static int[][] ShiftRight(int[][] matrix, String row, String shiftTimes, int colSize) {
        int currentRow = Integer.parseInt(row);
        int times = Integer.parseInt(shiftTimes) % colSize;
        for (int i = 0; i < times; i++) {
            int lastNum = matrix[currentRow][matrix[currentRow].length - 1];
            for (int j = matrix[currentRow].length - 1; j > 0; j--) {
                matrix[currentRow][j] = matrix[currentRow][j - 1];
            }
            matrix[currentRow][0] = lastNum;
        }
        return matrix;
    }
}

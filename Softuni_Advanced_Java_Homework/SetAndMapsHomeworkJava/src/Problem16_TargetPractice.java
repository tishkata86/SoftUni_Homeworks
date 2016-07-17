import java.util.Scanner;

public class Problem16_TargetPractice {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] colsRows = sc.nextLine().split(" ");
        int row = Integer.parseInt(colsRows[0]);
        int col = Integer.parseInt(colsRows[1]);
        char[][] matrix = new char[row][col];
        String text = sc.nextLine();
        String fillWith = "";
        int counter = 0;

        for (int i = 0; i < row * col; i++) {
            fillWith += text.charAt(i % text.length());
        }

        for (int i = row - 1; i >= 0; i -= 2) {
            for (int j = col - 1; j >= 0; j--) {
                matrix[i][j] = fillWith.charAt(counter);
                counter++;
            }

            for (int j = 0; j < col; j++) {
                if (i - 1 < 0) {
                    break;
                }
                matrix[i - 1][j] = fillWith.charAt(counter);
                counter++;
            }
        }

        String[] commands = sc.nextLine().split(" ");
        int rowBomb = Integer.parseInt(commands[0]);
        int colBomb = Integer.parseInt(commands[1]);
        int radius = Integer.parseInt(commands[2]);

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if ((j - colBomb) * (j - colBomb) + (i - rowBomb) * (i - rowBomb) <= radius * radius){
                    matrix[i][j] = ' ';
                }
            }
        }

        for (int i = row - 1; i >= 0; i--) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == ' ') {
                    for (int k = i - 1; k >= 0; k--) {
                        if (matrix[k][j] != ' ') {
                            matrix[i][j] = matrix[k][j];
                            matrix[k][j] = ' ';
                            break;
                        }
                    }
                }
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}

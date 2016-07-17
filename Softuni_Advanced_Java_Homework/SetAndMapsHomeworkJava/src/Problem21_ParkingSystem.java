import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem21_ParkingSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();
        sc.nextLine();
        boolean[][] matrix = new boolean[row][col];
        String input;
        while (!"stop".equals(input = sc.nextLine())) {
            String[] commands = input.split(" ");
            int entryRow = Integer.parseInt(commands[0]);
            int targetRow = Integer.parseInt(commands[1]);
            int targetCol = Integer.parseInt(commands[2]);
            List<Integer> freeSpaces = new ArrayList<>();

            int steps = 1;
            steps += Math.abs(targetRow - entryRow);
            if (matrix[targetRow][targetCol] == false) {
                steps += targetCol;
                matrix[targetRow][targetCol] = true;
                System.out.println(steps);
            } else {
                for (int i = 1; i < col; i++) {
                    if (matrix[targetRow][i] == false) {
                        freeSpaces.add(i);
                    }
                }

                if (freeSpaces.size() == 0){
                    System.out.printf("Row %d full\n", targetRow);
                } else {
                    for (int i = 1; i <= col - 1 ; i++) {
                        if (freeSpaces.contains(targetCol - i)){
                            matrix[targetRow][targetCol - i] = true;
                            steps += (targetCol - i);
                            System.out.println(steps);
                            break;
                        }
                        if (freeSpaces.contains(targetCol + i)){
                            matrix[targetRow][targetCol + i] = true;
                            steps += (targetCol + i);
                            System.out.println(steps);
                            break;
                        }
                    }
                }
            }
        }
    }
}

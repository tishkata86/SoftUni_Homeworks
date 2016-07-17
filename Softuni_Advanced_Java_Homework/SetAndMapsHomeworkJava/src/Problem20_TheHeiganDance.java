import java.util.Scanner;
import java.util.StringJoiner;

public class Problem20_TheHeiganDance {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double damageToHeaigen = Double.parseDouble(sc.nextLine());
        double playerLife = 18500.0;
        double heigenLife = 3000000.0;
        double cloudDamage = 3500.0;
        double eruptionDamage = 6000.0;
        boolean isCloudAktiv = false;
        boolean isHeiganDead = false;
        boolean isPlayerDead = false;
        boolean killedByEruption = false;

        boolean[][] field = new boolean[15][15];

        int playerRow = 7;
        int playerCol = 7;

        while (heigenLife > 0 && playerLife > 0) {
            heigenLife -= damageToHeaigen;

            if (isCloudAktiv){
                playerLife -= cloudDamage;
                isCloudAktiv = false;
            }

            if (playerLife <= 0){
                isPlayerDead = true;
                isHeiganDead = false;
                break;
            }

            if (heigenLife <= 0) {
                isHeiganDead = true;
                break;
            }

            String[] input = sc.nextLine().split(" ");
            String magic = input[0];
            int row = Integer.parseInt(input[1]);
            int col = Integer.parseInt(input[2]);

            if (row - 1 >= 0 && row - 1 <= 14 && col - 1 >= 0 && col - 1 <= 14) {
                field[row - 1][col - 1] = true;
            }
            if (row - 1 >= 0 && row - 1 <= 14 && col >= 0 && col <= 14) {
                field[row - 1][col] = true;
            }
            if (row - 1 >= 0 && row - 1 <= 14 && col + 1 >= 0 && col + 1 <= 14) {
                field[row - 1][col + 1] = true;
            }
            if (row >= 0 && row <= 14 && col - 1 >= 0 && col - 1 <= 14) {
                field[row][col - 1] = true;
            }
            if (row >= 0 && row <= 14 && col >= 0 && col <= 14) {
                field[row][col] = true;
            }
            if (row >= 0 && row <= 14 && col + 1 >= 0 && col + 1 <= 14) {
                field[row][col + 1] = true;
            }
            if (row + 1 >= 0 && row + 1 <= 14 && col - 1 >= 0 && col - 1 <= 14) {
                field[row + 1][col - 1] = true;
            }
            if (row + 1 >= 0 && row + 1 <= 14 && col >= 0 && col <= 14) {
                field[row + 1][col] = true;
            }
            if (row + 1 >= 0 && row + 1 <= 14 && col + 1 >= 0 && col + 1 <= 14) {
                field[row + 1][col + 1] = true;
            }


            if (field[playerRow][playerCol] == true) {
                if (playerRow - 1 < 0 || field[playerRow - 1][playerCol] == true){
                    if (playerCol + 1 >= 15 || field[playerRow][playerCol + 1] == true){
                        if (playerRow + 1 >= 15 || field[playerRow + 1][playerCol] == true){
                            if (playerCol - 1 < 0 || field[playerRow][playerCol - 1] == true){
                                switch (magic){
                                    case "Cloud":
                                        playerLife -= cloudDamage;
                                        isCloudAktiv = true;
                                        if (playerLife <= 0){
                                            isPlayerDead = true;
                                        }
                                        break;
                                    case "Eruption":
                                        playerLife -= eruptionDamage;
                                        if (playerLife <= 0){
                                            isPlayerDead = true;
                                            killedByEruption = true;
                                        }
                                        break;
                                }
                            } else {
                                playerCol--;
                            }
                        } else {
                            playerRow++;
                        }
                    } else {
                        playerCol++;
                    }
                } else {
                    playerRow--;
                }
            }

            field = new boolean[15][15];
        }

        if (isHeiganDead) {
            System.out.printf("Heigan: Defeated!\n");
            System.out.printf("Player: %.0f\n", playerLife);
            System.out.printf("Final position: %d, %d\n", playerRow, playerCol);
        }

        if (isPlayerDead) {
            System.out.printf("Heigan: %.2f\n", heigenLife);
            System.out.printf("Player: Killed by %s\n", killedByEruption ? "Eruption" : "Plague Cloud");
            System.out.printf("Final position: %d, %d\n", playerRow, playerCol);
        }
    }
}

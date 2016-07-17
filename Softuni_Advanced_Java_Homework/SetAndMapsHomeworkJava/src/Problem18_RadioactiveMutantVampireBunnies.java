import com.sun.org.apache.bcel.internal.generic.BREAKPOINT;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Problem18_RadioactiveMutantVampireBunnies {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] dimentions = sc.nextLine().split(" ");
        int row = Integer.parseInt(dimentions[0]);
        int col = Integer.parseInt(dimentions[1]);

        int playerRow = -1;
        int playerCol = -1;

        List<char[]> matrix = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            String line = sc.nextLine();
            int playerColumn = line.indexOf('P');
            if (playerColumn != -1){
                playerCol = playerColumn;
                playerRow = i;
            }
            matrix.add(line.toCharArray());
        }

        char[] cmds = sc.nextLine().toCharArray();
        boolean hasWon = false;
        boolean hasDied = false;


        for (int i = 0; i < cmds.length; i++) {
            char cmd = cmds[i];

            switch (cmd){
                case 'U':
                    if (playerRow == 0){
                        hasWon = true;
                        matrix.get(playerRow)[playerCol] = '.';
                    } else {
                        if (matrix.get(playerRow - 1)[playerCol] == 'B'){
                            hasDied = true;
                        } else {
                            matrix.get(playerRow - 1)[playerCol] = 'P';
                            matrix.get(playerRow)[playerCol] = '.';
                        }
                        playerRow--;
                    }
                    break;
                case 'D':
                    if (playerRow == row - 1){
                        hasWon = true;
                        matrix.get(playerRow)[playerCol] = '.';
                    } else {
                        if (matrix.get(playerRow + 1)[playerCol] == 'B'){
                            hasDied = true;
                        } else {
                            matrix.get(playerRow + 1)[playerCol] = 'P';
                            matrix.get(playerRow)[playerCol] = '.';
                        }
                        playerRow++;
                    }
                    break;
                case 'L':
                    if (playerCol == 0){
                        hasWon = true;
                        matrix.get(playerRow)[playerCol] = '.';
                    } else {
                        if (matrix.get(playerRow)[playerCol - 1] == 'B'){
                            hasDied = true;
                        } else {
                            matrix.get(playerRow)[playerCol - 1] = 'P';
                            matrix.get(playerRow)[playerCol] = '.';
                        }
                        playerCol--;
                    }
                    break;
                case 'R':
                    if (playerCol == col - 1){
                        hasWon = true;
                        matrix.get(playerRow)[playerCol] = '.';
                    } else {
                        if (matrix.get(playerRow)[playerCol + 1] == 'B'){
                            hasDied = true;
                        } else {
                            matrix.get(playerRow)[playerCol + 1] = 'P';
                            matrix.get(playerRow)[playerCol] = '.';
                        }
                        playerCol++;
                    }
                    break;
            }

            List<char[]> tempList = new ArrayList<>();
            for (int j = 0; j < row; j++) {
                tempList.add(new char[col]);
                for (int k = 0; k < col; k++) {
                    tempList.get(j)[k] = matrix.get(j)[k];
                }
            }

            for (int j = 0; j < row; j++) {
                for (int k = 0; k < col; k++) {
                    if (matrix.get(j)[k] == 'B'){
                        if (j > 0){
                            if (matrix.get(j - 1)[k] == 'P'){
                                hasDied = true;
                            }
                            tempList.get(j - 1)[k] = 'B';
                        }

                        if (j < row - 1){
                            if (matrix.get(j + 1)[k] == 'P'){
                                hasDied = true;
                            }
                            tempList.get(j + 1)[k] = 'B';
                        }

                        if (k > 0){
                            if (matrix.get(j)[k - 1] == 'P'){
                                hasDied = true;
                            }
                            tempList.get(j)[k - 1] = 'B';
                        }

                        if (k < col - 1){
                            if (matrix.get(j)[k + 1] == 'P'){
                                hasDied = true;
                            }
                            tempList.get(j)[k + 1] = 'B';
                        }
                    }
                }
            }

            for (int j = 0; j < row; j++) {
                for (int k = 0; k < col; k++) {
                    matrix.get(j)[k] = tempList.get(j)[k];
                }
            }

            if (hasWon){
                hasDied = false;
                break;
            }

            if (hasDied){
                break;
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(matrix.get(i)[j]);
            }
            System.out.println();
        }

        if (hasWon){
            System.out.println("won: " + playerRow + " " + playerCol);
        } else {
            System.out.println("dead: " + playerRow + " " + playerCol);
        }
    }
}
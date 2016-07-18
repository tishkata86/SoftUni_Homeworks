package Problem10_MooD_3;

import Problem10_MooD_3.Interfaces.Player;
import Problem10_MooD_3.Models.Archangel;
import Problem10_MooD_3.Models.Demon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        String[] params = sc.readLine().split("[\\|]");
        String username = params[0].trim();
        String type = params[1].trim();
        int level = Integer.parseInt(params[3].trim());

        Player currentPlayer = null;
        switch (type) {
            case "Archangel":
                int mana = Integer.parseInt(params[2].trim());
                currentPlayer = new Archangel(username, mana, level);
                System.out.println(currentPlayer);
                break;
            case "Demon":
                double energy = Double.parseDouble(params[2].trim());
                currentPlayer = new Demon(username, energy, level);
                System.out.println(currentPlayer);
                break;
        }
    }
}

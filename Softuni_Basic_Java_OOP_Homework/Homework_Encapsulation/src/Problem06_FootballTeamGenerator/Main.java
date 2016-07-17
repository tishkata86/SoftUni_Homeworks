package Problem06_FootballTeamGenerator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        List<FootballTeam> allTeams = new ArrayList<>();

        String line;
        while (!"END".equals(line = sc.readLine())) {
            try {
                String[] params = line.split(";");
                if (params[0].equals("Team")) {
                    String name = params[1];
                    allTeams.add(new FootballTeam(name));
                }

                if (params[0].equals("Add")) {
                    String teamName = params[1];
                    String playerName = params[2];
                    double endurance = Double.parseDouble(params[3]);
                    double sprint = Double.parseDouble(params[4]);
                    double dribble = Double.parseDouble(params[5]);
                    double passing = Double.parseDouble(params[6]);
                    double shooting = Double.parseDouble(params[7]);

                    boolean notFoundTeam = true;
                    for (FootballTeam team : allTeams) {
                        if (team.getName().equals(teamName)) {
                            notFoundTeam = false;
                            Player currentPlayer = new Player(playerName, endurance, sprint, dribble, passing, shooting);
                            team.addPlayer(currentPlayer);
                        }
                    }

                    if (notFoundTeam) {
                        throw new IllegalArgumentException(String.format("Team %s does not exist.", teamName));
                    }
                }

                if (params[0].equals("Remove")) {
                    String teamName = params[1];
                    String playerName = params[2];

                    boolean notFoundTeam = true;
                    for (FootballTeam footballTeam : allTeams) {
                        if (footballTeam.getName().equals(teamName)) {
                            notFoundTeam = false;
                            footballTeam.removePlayer(playerName);
                        }
                    }

                    if (notFoundTeam) {
                        throw new IllegalArgumentException(String.format("Team %s does not exist.", teamName));
                    }
                }

                if (params[0].equals("Rating")) {
                    String teamName = params[1];

                    boolean notFoundTeam = true;
                    for (FootballTeam currentTeam : allTeams) {
                        if (currentTeam.getName().equals(teamName)) {
                            notFoundTeam = false;
                            System.out.printf("%s - %.0f\n", currentTeam.getName(), currentTeam.getRating());
                        }
                    }

                    if (notFoundTeam) {
                        throw new IllegalArgumentException(String.format("Team %s does not exist.", teamName));
                    }
                }

            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}

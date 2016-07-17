package Problem06_FootballTeamGenerator;

import java.util.ArrayList;
import java.util.List;

public class FootballTeam {
    private String name;
    private double rating;
    private List<Player> players;

    public FootballTeam(String name) {
        setName(name);
        this.players = new ArrayList<>();
        this.rating = 0;
    }

    public String getName() {
        return name;
    }

    public double getRating() {
        return rating;
    }

    private void setName(String name) {
        if (name == null || name.trim().equals("")) {
            throw new IllegalArgumentException("A name should not be empty. ");
        }
        this.name = name;
    }

    public void addPlayer(Player player) {
        this.players.add(player);
        double averageRating = 0.0;
        for (Player player1 : players) {
            averageRating += player1.getOverallSkillLevel();
        }
        this.rating = averageRating / this.players.size();
    }

    public void removePlayer(String player) {
        boolean notFound = true;
        for (int i = 0; i < this.players.size(); i++) {
            if (this.players.get(i).getName().equals(player)) {
                notFound = false;
                this.players.remove(i);
            }
        }
        if (notFound) {
            throw new IllegalArgumentException(String.format("Player %s is not in %s team.", player, this.name));
        }

        if (this.players.size() == 0) {
            this.rating = 0.0;
        } else {
            double averageRating = 0.0;
            for (Player player1 : this.players) {
                averageRating += player1.getOverallSkillLevel();
            }
            this.rating = averageRating / this.players.size();
        }
    }
}

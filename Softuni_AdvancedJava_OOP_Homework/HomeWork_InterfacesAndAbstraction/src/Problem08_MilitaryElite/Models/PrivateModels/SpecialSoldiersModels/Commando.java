package Problem08_MilitaryElite.Models.PrivateModels.SpecialSoldiersModels;

import Problem08_MilitaryElite.Interfaces.CommandoInterface;
import Problem08_MilitaryElite.Interfaces.MissionInterface;
import Problem08_MilitaryElite.Models.PrivateModels.SpecialSoldier;

import java.util.ArrayList;
import java.util.List;

public class Commando extends SpecialSoldier implements CommandoInterface {
    private List<MissionInterface> missions;

    public Commando(String id, String firstName, String lastName, double salary, String corps) {
        super(id, firstName, lastName, salary, corps);
        this.missions = new ArrayList<>();
    }


    public List<MissionInterface> getMissions() {
        return this.missions;
    }

    public void addMission(MissionInterface mission) {
        this.missions.add(mission);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("Missions: ").append(System.lineSeparator());
        for (MissionInterface mission : missions) {
            sb.append(mission).append(System.lineSeparator());
        }

        return sb.toString();
    }
}

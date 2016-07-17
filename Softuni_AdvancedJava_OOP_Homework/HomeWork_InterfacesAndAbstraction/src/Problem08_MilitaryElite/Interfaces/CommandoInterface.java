package Problem08_MilitaryElite.Interfaces;

import Problem08_MilitaryElite.Models.PrivateModels.SpecialSoldiersModels.Mission;

import java.util.List;

public interface CommandoInterface extends SpecialSoldierInterface {

    List<MissionInterface> getMissions();

    void addMission(MissionInterface mission);
}

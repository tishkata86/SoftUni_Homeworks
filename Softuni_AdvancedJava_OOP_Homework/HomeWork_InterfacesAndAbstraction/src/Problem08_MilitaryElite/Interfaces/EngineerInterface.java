package Problem08_MilitaryElite.Interfaces;

import Problem08_MilitaryElite.Models.PrivateModels.SpecialSoldiersModels.Part;

import java.util.List;

public interface EngineerInterface extends SpecialSoldierInterface{

    List<PartInterface> getParts();

    void addPart(PartInterface part);
}

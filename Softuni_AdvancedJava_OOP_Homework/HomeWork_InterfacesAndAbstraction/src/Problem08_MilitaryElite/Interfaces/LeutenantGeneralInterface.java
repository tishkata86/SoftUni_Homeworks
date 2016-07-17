package Problem08_MilitaryElite.Interfaces;

import Problem08_MilitaryElite.Models.Private;

import java.util.List;

public interface LeutenantGeneralInterface extends PrivateInterface{

    List<SoldierInterface> getSoldiersUnderCommand();

    void addSoldierToLeutenantList(SoldierInterface soldier);
}

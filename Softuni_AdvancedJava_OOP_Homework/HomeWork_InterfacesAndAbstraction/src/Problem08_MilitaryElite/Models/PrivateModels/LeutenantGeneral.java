package Problem08_MilitaryElite.Models.PrivateModels;

import Problem08_MilitaryElite.Interfaces.LeutenantGeneralInterface;
import Problem08_MilitaryElite.Interfaces.PrivateInterface;
import Problem08_MilitaryElite.Interfaces.SoldierInterface;
import Problem08_MilitaryElite.Models.Private;

import java.util.ArrayList;
import java.util.List;

public class LeutenantGeneral extends Private implements LeutenantGeneralInterface {
    List<SoldierInterface> soldiersUnderCommand;

    public LeutenantGeneral(String id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName, salary);
        this.soldiersUnderCommand = new ArrayList<>();
    }

    public List<SoldierInterface> getSoldiersUnderCommand() {
        return soldiersUnderCommand;
    }

    @Override
    public void addSoldierToLeutenantList(SoldierInterface soldier) {
        this.soldiersUnderCommand.add(soldier);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("Privates: ").append(System.lineSeparator());
        for (SoldierInterface aPrivate : soldiersUnderCommand) {
            sb.append("  " + aPrivate);
        }
        return sb.toString();
    }
}

package Problem08_MilitaryElite.Models.PrivateModels.SpecialSoldiersModels;

import Problem08_MilitaryElite.Interfaces.EngineerInterface;
import Problem08_MilitaryElite.Interfaces.PartInterface;
import Problem08_MilitaryElite.Models.PrivateModels.SpecialSoldier;

import java.util.ArrayList;
import java.util.List;

public class Engineer extends SpecialSoldier implements EngineerInterface{
    private List<PartInterface> parts;

    public Engineer(String id, String firstName, String lastName, double salary, String corps) {
        super(id, firstName, lastName, salary, corps);
        this.parts = new ArrayList<>();
    }

    public List<PartInterface> getParts() {
        return parts;
    }

    public void addPart(PartInterface part){
        this.parts.add(part);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("Repairs: ").append(System.lineSeparator());
        for (PartInterface part : parts) {
            sb.append(part).append(System.lineSeparator());
        }
        return sb.toString();
    }
}

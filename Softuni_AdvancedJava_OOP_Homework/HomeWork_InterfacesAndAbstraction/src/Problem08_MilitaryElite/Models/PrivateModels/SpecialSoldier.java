package Problem08_MilitaryElite.Models.PrivateModels;

import Problem08_MilitaryElite.Interfaces.SoldierInterface;
import Problem08_MilitaryElite.Models.Private;

public abstract class SpecialSoldier extends Private implements SoldierInterface{

    private String corps;

    public SpecialSoldier(String id, String firstName, String lastName, double salary, String corps) {
        super(id, firstName, lastName, salary);
        this.setCorps(corps);
    }

    public String getCorps() {
        return corps;
    }

    private void setCorps(String corps) {
        this.corps = corps;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("Corps: " + getCorps()).append(System.lineSeparator());
        return sb.toString();
    }
}

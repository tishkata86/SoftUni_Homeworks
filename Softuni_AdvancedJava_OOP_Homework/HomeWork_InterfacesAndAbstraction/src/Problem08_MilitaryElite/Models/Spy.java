package Problem08_MilitaryElite.Models;

import Problem08_MilitaryElite.Interfaces.SpyInterface;

public class Spy extends Soldier implements SpyInterface {

    private int codeNumber;

    public Spy(String id, String firstName, String lastName, int codeNumber) {
        super(id, firstName, lastName);
        this.setCodeNumber(codeNumber);
    }

    public int getCodeNumber() {
        return codeNumber;
    }

    private void setCodeNumber(int codeNumber) {
        this.codeNumber = codeNumber;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Name: %s %s Id: %s",
                getFirstName(),
                getLastName(),
                getId()))
                .append(System.lineSeparator());
        sb.append("Code Number: " + getCodeNumber()).append(System.lineSeparator());

        return sb.toString();
    }
}

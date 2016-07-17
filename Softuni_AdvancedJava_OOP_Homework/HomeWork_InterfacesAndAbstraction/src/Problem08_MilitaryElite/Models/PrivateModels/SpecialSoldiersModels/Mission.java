package Problem08_MilitaryElite.Models.PrivateModels.SpecialSoldiersModels;

import Problem08_MilitaryElite.Interfaces.MissionInterface;

public class Mission implements MissionInterface{
    private String codeName;
    private String state;

    public Mission(String codeName, String state) {
        this.setCodeName(codeName);
        this.setState(state);
    }

    public String getCodeName() {
        return codeName;
    }

    private void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    public String getState() {
        return state;
    }

    private void setState(String state) {
        this.state = state;
    }

    public void CompleteMission(){
        this.state = "Finished";
    }

    @Override
    public String toString() {
        return String.format("  Code Name: %s State: %s", getCodeName(), getState());
    }
}

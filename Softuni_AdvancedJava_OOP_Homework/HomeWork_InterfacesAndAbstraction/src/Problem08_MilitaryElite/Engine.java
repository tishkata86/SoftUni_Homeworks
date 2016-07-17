package Problem08_MilitaryElite;

import Problem08_MilitaryElite.Interfaces.*;
import Problem08_MilitaryElite.Models.Private;
import Problem08_MilitaryElite.Models.PrivateModels.LeutenantGeneral;
import Problem08_MilitaryElite.Models.PrivateModels.SpecialSoldiersModels.Commando;
import Problem08_MilitaryElite.Models.PrivateModels.SpecialSoldiersModels.Engineer;
import Problem08_MilitaryElite.Models.PrivateModels.SpecialSoldiersModels.Mission;
import Problem08_MilitaryElite.Models.PrivateModels.SpecialSoldiersModels.Part;
import Problem08_MilitaryElite.Models.Spy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Engine {

    private List<SoldierInterface> database;
    private BufferedReader sc;

    public Engine() {
        this.database = new ArrayList<>();
        sc = new BufferedReader(new InputStreamReader(System.in));
    }

    public void run() throws IOException {
        List<PrivateInterface> privateSoldiers = new ArrayList<>();

        String id;
        String firstName;
        String lastName;
        double salary;
        int codeName;
        String corp;

        PartInterface part;
        String partName;
        int partHours;

        MissionInterface mission;
        String missionCodeName;
        String missionState;

        String line;
        while (!"End".equals(line = sc.readLine())) {
            String[] params = line.trim().split("\\s+");

            String soldierType = params[0];
            id = params[1];
            firstName = params[2];
            lastName = params[3];

            switch (soldierType) {
                case "Private":
                    salary = Double.parseDouble(params[4]);
                    PrivateInterface currentSoldier = new Private(id, firstName, lastName, salary);
                    database.add(currentSoldier);
                    privateSoldiers.add(currentSoldier);
                    break;

                case "Spy":
                    codeName = Integer.valueOf(params[4]);
                    SpyInterface spy = new Spy(id, firstName, lastName, codeName);
                    this.database.add(spy);
                    break;

                case "LeutenantGeneral":
                    salary = Double.parseDouble(params[4]);
                    LeutenantGeneralInterface leutenant = new LeutenantGeneral(id, firstName, lastName, salary);
                    for (int i = 5; i < params.length; i++) {
                        for (PrivateInterface soldier : privateSoldiers) {
                            if (soldier.getId().equals(params[i])) {
                                leutenant.addSoldierToLeutenantList(soldier);
                            }
                        }
                    }
                    this.database.add(leutenant);
                    break;

                case "Engineer":
                    salary = Double.parseDouble(params[4]);
                    corp = params[5];

                    if (CheckIfValidCorp(corp)) {
                        break;
                    }

                    EngineerInterface currentEngineer = new Engineer(id, firstName, lastName, salary, corp);
                    for (int i = 6; i < params.length; i += 2) {
                        partName = params[i];
                        partHours = Integer.parseInt(params[i + 1]);
                        part = new Part(partName, partHours);
                        currentEngineer.addPart(part);
                    }

                    database.add(currentEngineer);
                    break;

                case "Commando":
                    salary = Double.parseDouble(params[4]);
                    corp = params[5];

                    if (CheckIfValidCorp(corp)) {
                        break;
                    }

                    CommandoInterface currentCommando = new Commando(id, firstName, lastName, salary, corp);
                    for (int i = 6; i < params.length; i += 2) {
                        missionCodeName = params[i];
                        missionState = params[i + 1];
                        if (!missionState.equals("inProgress") &&
                                !missionState.equals("Finished")) {
                            continue;
                        }
                        mission = new Mission(missionCodeName, missionState);
                        currentCommando.addMission(mission);
                    }

                    database.add(currentCommando);
                    break;
            }
        }

        for (SoldierInterface soldier : database) {
            System.out.print(soldier);
        }
    }

    private boolean CheckIfValidCorp(String corp) {
        if (corp.equals("Airforces") || corp.equals("Marines")) {
            return false;
        } else {
            return true;
        }
    }
}

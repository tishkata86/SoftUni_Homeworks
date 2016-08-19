package Problem08_PetClinics;

import Problem08_PetClinics.models.Clinic;
import Problem08_PetClinics.models.Pet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Pet> pets = new HashMap<>();
        HashMap<String ,Clinic> clinics = new HashMap<>();

        int lines = Integer.parseInt(sc.readLine());

        for (int i = 0; i < lines; i++) {
            String[] params = sc.readLine().split("\\s+");

            switch (params[0]) {
                case "Create":
                    if (params[1].equals("Pet")) {
                        String name = params[2];
                        String age = params[3];
                        String kind = params[4];
                        pets.put(name ,new Pet(name, age, kind));
                    }

                    if (params[1].equals("Clinic")) {
                        String name = params[2];
                        int rooms = 0;
                        try {
                            rooms = Integer.parseInt(params[3]);
                            clinics.put(name ,new Clinic(name, rooms));
                        } catch (Exception ex){
                            System.out.println(ex.getMessage());
                        }
                    }

                    break;

                case "Add":
                    String petName = params[1];
                    String clinicName = params[2];

                    if (clinics.containsKey(clinicName)){
                        if (pets.containsKey(petName)){
                            clinics.get(clinicName).add(pets.get(petName));
                        } else {
                            System.out.println("Invalid Operation!");
                        }
                    } else {
                        System.out.println("Invalid Operation!");
                    }
                    break;

                case "Release":
                    String clinic = params[1];
                    if (clinics.containsKey(clinic)){
                        System.out.println(clinics.get(clinic).release());
                    }else {
                        System.out.println("false");
                    }
                    break;

                case "HasEmptyRooms":
                    String nameOfClinic = params[1];
                    System.out.println(clinics.get(nameOfClinic).hasEmptyRoom());
                    break;
                case "Print":
                    if (params.length == 2){
                        clinics.get(params[1]).printAll();
                    } else {
                        clinics.get(params[1]).printClinicRoomInfo(Integer.parseInt(params[2]));
                    }
                    break;
            }
        }
    }
}

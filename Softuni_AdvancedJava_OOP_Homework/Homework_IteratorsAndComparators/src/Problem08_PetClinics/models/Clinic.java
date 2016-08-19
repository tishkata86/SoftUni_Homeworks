package Problem08_PetClinics.models;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.function.Consumer;

public class Clinic implements Iterable<Pet> {
    private String name;
    private Pet[] patients;
    private int mid;
    private int addIndex;
    private int releaseIndex;
    private int difference;

    public Clinic(String name, int rooms) {
        this.setName(name);
        this.patients = setPatients(rooms);
        this.mid = rooms / 2;
        this.addIndex = mid;
        this.releaseIndex = mid;
        this.difference = 0;
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public Pet[] getPatients() {
        return patients;
    }

    private Pet[] setPatients(int rooms) {
        if (rooms % 2 == 0) {
            throw new IllegalArgumentException("Invalid Operation!");
        }
        return new Pet[rooms];
    }

    public boolean release() {
        boolean isReleased = false;

        for (int i = 0; i < patients.length; i++) {
            if (releaseIndex == patients.length) {
                releaseIndex = 0;
            }

            if (patients[releaseIndex] != null) {
                isReleased = true;
                patients[releaseIndex] = null;
                releaseIndex++;
                break;
            }
        }

        return isReleased;
    }

    public boolean hasEmptyRoom() {
        boolean hasEmpty = false;
        for (int i = 0; i < patients.length; i++) {
            if (patients[i] == null) {
                hasEmpty = true;
            }
        }

        return hasEmpty;
    }

    public boolean add(Pet pet) {
        boolean isAdded = false;
        int counter = patients.length;

        while (isAdded == false && counter >= 0) {
            if (this.addIndex == mid) {
                if (patients[addIndex] == null) {
                    patients[addIndex] = pet;
                    isAdded = true;
                }
                addIndex++;
                difference++;
            } else {
                if (addIndex > mid) {
                    if (this.addIndex == patients.length || mid - difference < 0) {
                        break;
                    }

                    if (patients[mid - difference] == null) {
                        patients[mid - difference] = pet;
                        isAdded = true;
                        addIndex = mid - difference;
                    }
                } else {
                    if (this.addIndex < 0 || mid + difference == this.patients.length) {
                        break;
                    }

                    if (patients[mid + difference] == null) {
                        patients[mid + difference] = pet;
                        isAdded = true;
                        addIndex = mid + difference;
                    }
                    this.difference++;
                }
            }

            counter--;
        }

        System.out.println(isAdded);
        return isAdded;
    }

    public void printAll() {
        for (int i = 0; i < patients.length; i++) {
            if (patients[i] != null) {
                System.out.println(patients[i]);
            } else {
                System.out.println("Room empty");
            }
        }
    }

    public void printClinicRoomInfo(int index) {
        index -= 1;
        if (patients[index] != null) {
            System.out.println(patients[index]);
        } else {
            System.out.println("Room empty");
        }
    }


    @Override
    public Iterator<Pet> iterator() {
        if (this.patients.length == 0) {
            return Collections.<Pet>emptyIterator();
        }

        return Arrays.stream(this.patients).iterator();
    }

    @Override
    public void forEach(Consumer<? super Pet> action) {
        for (Pet patient : patients) {
            action.accept(patient);
        }
    }
}

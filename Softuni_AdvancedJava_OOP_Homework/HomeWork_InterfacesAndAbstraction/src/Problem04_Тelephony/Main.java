package Problem04_Тelephony;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

interface Browsable {

    void browse();
}

interface Callable {

    void call();
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        List<String> phoneNumbers = new ArrayList<>(Arrays.asList(sc.readLine().split("\\s+")));
        List<String> webSites = new ArrayList<>(Arrays.asList(sc.readLine().split("\\s+")));


        Smartphone myPhone = new Smartphone(phoneNumbers, webSites);
        myPhone.call();
        myPhone.browse();
    }
}

class Smartphone implements Browsable, Callable {
    private List<String> phoneNumbers;
    private List<String> websites;

    public Smartphone(List<String> phoneNumbers, List<String> websites) {
        this.setPhoneNumbers(phoneNumbers);
        this.setWebsites(websites);
    }

    public List<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    private void setPhoneNumbers(List<String> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public List<String> getWebsites() {
        return websites;
    }

    private void setWebsites(List<String> websites) {
        this.websites = websites;
    }

    public void call() {

        for (String phoneNumber : phoneNumbers) {
            boolean hasCharacter = false;
            for (int i = 0; i < phoneNumber.length(); i++) {
                if (Character.isLetter(phoneNumber.charAt(i))) {
                    hasCharacter = true;
                }
            }

            if (!hasCharacter) {
                System.out.println("Calling... " + phoneNumber);
            } else {
                System.out.println("Invalid number!");
            }
        }
    }

    public void browse() {
        for (String website : websites) {
            boolean hasDigit = false;
            for (int i = 0; i < website.length(); i++) {
                if (Character.isDigit(website.charAt(i))) {
                    hasDigit = true;
                }
            }

            if (!hasDigit) {
                System.out.println("Browsing: " + website + "!");
            } else {
                System.out.println("Invalid URL!");
            }
        }
    }
}

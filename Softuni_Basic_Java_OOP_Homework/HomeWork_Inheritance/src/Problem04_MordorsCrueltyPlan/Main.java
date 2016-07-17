package Problem04_MordorsCrueltyPlan;

import Problem04_MordorsCrueltyPlan.Models.Gandalf;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        try {
            String[] foods = sc.readLine().split("\\s+");
            Gandalf gandalf = new Gandalf();
            gandalf.setFoods(foods);
            gandalf.setMood();
            System.out.println(gandalf);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}

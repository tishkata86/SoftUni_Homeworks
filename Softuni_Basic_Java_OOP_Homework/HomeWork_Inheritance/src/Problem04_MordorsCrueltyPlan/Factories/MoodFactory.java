package Problem04_MordorsCrueltyPlan.Factories;

import Problem04_MordorsCrueltyPlan.Models.Mood;
import Problem04_MordorsCrueltyPlan.Models.Moods.Angry;
import Problem04_MordorsCrueltyPlan.Models.Moods.Happy;
import Problem04_MordorsCrueltyPlan.Models.Moods.JavaScript;
import Problem04_MordorsCrueltyPlan.Models.Moods.Sad;

public class MoodFactory {

    public static Mood getMood(int happinesPoint){
        if (happinesPoint < -5){
            return new Angry();
        } else if (happinesPoint >= -5 && happinesPoint < 0){
            return new Sad();
        } else if (happinesPoint >= 0 && happinesPoint <= 15){
            return new Happy();
        } else {
            return new JavaScript();
        }
    }
}

package Problem05_OnlineRadionData;

import java.util.ArrayList;
import java.util.List;

public class RadionData {
    private int songsCount;
    private int hours;
    private int minutes;
    private int seconds;
    private List<Song> songs;

    public RadionData() {
        this.songsCount = 0;
        this.hours = 0;
        this.minutes = 0;
        this.seconds = 0;
        this.songs = new ArrayList<>();
    }

    public void setSongs(Song currentSong){
        this.songs.add(currentSong);
        this.songsCount++;
        System.out.println("Song added.");
    }

    public void CalcTime(){
        int totalHours = 0;
        int totalMinutes = 0;
        int totalSeconds = 0;
        for (Song song : songs) {
            totalMinutes += song.getMinuts();
            totalSeconds += song.getSeconds();
        }

        totalMinutes += totalSeconds / 60;
        totalSeconds %= 60;
        totalHours += totalMinutes / 60;
        totalMinutes %= 60;

        this.hours = totalHours;
        this.minutes = totalMinutes;
        this.seconds = totalSeconds;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Songs added: " + this.songsCount + "\n");
        sb.append(String.format("Playlist length: %dh %dm %ds\n",this.hours, this.minutes, this.seconds));
        return sb.toString();
    }
}

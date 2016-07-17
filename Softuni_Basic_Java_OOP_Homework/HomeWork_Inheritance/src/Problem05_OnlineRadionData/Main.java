package Problem05_OnlineRadionData;

import Problem05_OnlineRadionData.ExeptionHierarchy.InvalidSongException;
import Problem05_OnlineRadionData.ExeptionHierarchy.InvalidSongNameExeptions.InvalidArtistNameException;
import Problem05_OnlineRadionData.ExeptionHierarchy.InvalidSongNameExeptions.InvalidSongLengthException;
import Problem05_OnlineRadionData.ExeptionHierarchy.InvalidSongNameExeptions.InvalidSongNameException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        int lines = Integer.parseInt(sc.readLine());
        RadionData myRadio = new RadionData();
        for (int i = 0; i < lines; i++) {
            try {
                String[] params = sc.readLine().split(";");

                if (params.length != 3) {
                    throw new InvalidSongException("Invalid song.");
                }
                String artist = params[0];
                String song = params[1];
                String[] time = params[2].split(":");
                if (time.length != 2) {
                    throw new InvalidSongLengthException("Invalid song length.");
                }
                int minutes;
                int seconds;
                try {
                    minutes = Integer.parseInt(time[0]);
                    seconds = Integer.parseInt(time[1]);
                } catch (Exception ex) {
                    throw new InvalidSongLengthException("Invalid song length.");
                }
                Song currentSong = new Song(artist, song, minutes, seconds);
                myRadio.setSongs(currentSong);

            } catch (InvalidSongException e) {
                System.out.println(e.getMessage());
            }
        }

        myRadio.CalcTime();
        System.out.println(myRadio);
    }
}

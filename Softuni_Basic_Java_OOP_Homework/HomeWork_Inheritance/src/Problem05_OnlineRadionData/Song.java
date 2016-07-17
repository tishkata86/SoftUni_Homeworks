package Problem05_OnlineRadionData;

import Problem05_OnlineRadionData.ExeptionHierarchy.InvalidSongException;
import Problem05_OnlineRadionData.ExeptionHierarchy.InvalidSongNameExeptions.InvalidArtistNameException;
import Problem05_OnlineRadionData.ExeptionHierarchy.InvalidSongNameExeptions.InvalidSongLengthException;
import Problem05_OnlineRadionData.ExeptionHierarchy.InvalidSongNameExeptions.InvalidSongLenthExeptions.InvalidSongMinutesException;
import Problem05_OnlineRadionData.ExeptionHierarchy.InvalidSongNameExeptions.InvalidSongLenthExeptions.InvalidSongSecondsException;
import Problem05_OnlineRadionData.ExeptionHierarchy.InvalidSongNameExeptions.InvalidSongNameException;

public class Song {
    private String artist;
    private String songName;
    private int minuts;
    private int seconds;

    public Song(String artist, String songName, int minuts, int seconds) throws InvalidArtistNameException, InvalidSongNameException, InvalidSongLengthException {
        setArtist(artist);
        setSongName(songName);
        setMinuts(minuts);
        setSeconds(seconds);
    }

    public int getMinuts() {
        return minuts;
    }

    public int getSeconds() {
        return seconds;
    }

    private void setArtist(String artist) throws InvalidArtistNameException {
        if (artist.length() <3 || artist.length() > 20){
            throw new InvalidArtistNameException("Artist name should be between 3 and 20 symbols.");
        }

        this.artist = artist;
    }

    private void setSongName(String songName) throws InvalidSongNameException {
        if (songName.length() < 3 || songName.length() > 30){
            throw new InvalidSongNameException("Song name should be between 3 and 30 symbols.");
        }
        this.songName = songName;
    }

    private void setMinuts(int minuts) throws InvalidSongLengthException {
        if (minuts < 0 || minuts > 14){
            throw new InvalidSongMinutesException("Song minutes should be between 0 and 14.");
        }
        this.minuts = minuts;
    }

    private void setSeconds(int seconds) throws InvalidSongSecondsException {
        if (seconds < 0 || seconds > 59){
            throw new InvalidSongSecondsException("Song seconds should be between 0 and 59.");
        }
        this.seconds = seconds;
    }
}

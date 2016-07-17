package Problem05_OnlineRadionData.ExeptionHierarchy.InvalidSongNameExeptions;

import Problem05_OnlineRadionData.ExeptionHierarchy.InvalidSongException;

public class InvalidArtistNameException extends InvalidSongException{

    public InvalidArtistNameException(String message) {
        super(message);
    }
}

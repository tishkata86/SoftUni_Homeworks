package Problem05_OnlineRadionData.ExeptionHierarchy.InvalidSongNameExeptions;

import Problem05_OnlineRadionData.ExeptionHierarchy.InvalidSongException;

public class InvalidSongNameException extends InvalidSongException{
    public InvalidSongNameException(String message) {
        super(message);
    }
}

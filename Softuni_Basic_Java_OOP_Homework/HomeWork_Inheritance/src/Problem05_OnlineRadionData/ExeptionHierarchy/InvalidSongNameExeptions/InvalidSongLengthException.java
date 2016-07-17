package Problem05_OnlineRadionData.ExeptionHierarchy.InvalidSongNameExeptions;

import Problem05_OnlineRadionData.ExeptionHierarchy.InvalidSongException;

public class InvalidSongLengthException extends InvalidSongException {
    public InvalidSongLengthException(String message) {
        super(message);
    }
}

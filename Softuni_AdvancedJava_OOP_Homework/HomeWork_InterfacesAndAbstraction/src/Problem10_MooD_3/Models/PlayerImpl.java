package Problem10_MooD_3.Models;

import Problem10_MooD_3.Interfaces.Player;

public abstract class PlayerImpl<T> implements Player {

    private String username;
    private T specialPoint;
    private int level;
    private String password;

    public PlayerImpl(String username, T specialPoint, int level) {
        this.setUsername(username);
        this.setSpecialPoint(specialPoint);
        this.setLevel(level);
        this.password = setPassword();
    }

    public String getPassword() {
        return this.password;
    }

    protected String setPassword() {
        return null;
    }

    public String getUsername() {
        return username;
    }

    private void setUsername(String username) {
        this.username = username;
    }

    public T getSpecialPoint() {
        return specialPoint;
    }

    private void setSpecialPoint(T specialPoint) {
        this.specialPoint = specialPoint;
    }

    public int getLevel() {
        return level;
    }

    private void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return String.format("\"%s\" | \"%s\" -> %s\n",
                this.getUsername(),
                this.getPassword(),
                this.getClass().getSimpleName());
    }
}

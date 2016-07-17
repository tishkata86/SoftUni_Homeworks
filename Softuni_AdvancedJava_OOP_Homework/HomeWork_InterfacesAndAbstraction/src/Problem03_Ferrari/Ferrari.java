package Problem03_Ferrari;

public class Ferrari implements Car {
    private String model;
    private String driver;

    public Ferrari(String driver) {
        this.model = "488-Spider";
        this.setDriver(driver);
    }

    public String getDriver() {
        return driver;
    }

    private void setDriver(String driver) {
        this.driver = driver;
    }

    @Override
    public String useBrakes() {
        return "Brakes!";
    }

    @Override
    public String gas() {
        return "Zadu6avam sA!";
    }

    @Override
    public String toString() {
        return String.format("%s/%s/%s/%s", this.model, useBrakes(), gas(), this.driver);
    }
}

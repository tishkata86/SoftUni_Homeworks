package Problem01_Problem02_ClassBox;

public class Box {

    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        this.setLength(length);
        this.setWidth(width);
        this.setHeight(height);
    }

    public void setLength(double length) {
        if (length <= 0.0){
            throw new ArithmeticException("Length cannot be zero or negative.");
        }
        this.length = length;
    }

    public void setWidth(double width) {
        if (width <= 0.0){
            throw new ArithmeticException("Width cannot be zero or negative.");
        }
        this.width = width;
    }

    public void setHeight(double height) {
        if (height <= 0.0){
            throw new ArithmeticException("Height cannot be zero or negative.");
        }
        this.height = height;
    }

    private double SurfaceArea() {
        return (2 * this.length * this.width) +
                (2 * this.length * this.height) +
                (2 * this.width * this.height);
    }

    private double LateralSurfaceArea() {
        return (2 * this.length * this.height) +
                (2 * this.width * this. height);
    }

    private double Volume() {
        return (this.length * this.width * this.height);
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append(String.format("Surface Area - %.2f\n", SurfaceArea()));
        output.append(String.format("Lateral Surface Area - %.2f\n", LateralSurfaceArea()));
        output.append(String.format("Volume - %.2f\n", Volume()));
        return output.toString();
    }
}

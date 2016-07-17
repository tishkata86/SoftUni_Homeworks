package Problem08_ShapesVolume;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ShapesVolume {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while (!"End".equals(line = sc.readLine())) {
            String[] params = line.split("\\s+");
            switch (params[0]){
                case "TrianglePrism":
                    double base = Double.parseDouble(params[1]);
                    double height = Double.parseDouble(params[2]);
                    double length = Double.parseDouble(params[3]);
                    TriangularPrism currentTriangle = new TriangularPrism(base,height,length);
                    VolumeCalculator.VolumeOfTriangle(currentTriangle);
                    break;
                case "Cube":
                    double side = Double.parseDouble(params[1]);
                    Cube currentCube = new Cube(side);
                    VolumeCalculator.VolumeOfCube(currentCube);
                    break;
                case "Cylinder":
                    double radius = Double.parseDouble(params[1]);
                    double cylinderHeight = Double.parseDouble(params[2]);
                    Cylinder currentCylinder = new Cylinder(radius, cylinderHeight);
                    VolumeCalculator.VolumeOfCylinder(currentCylinder);
                    break;
            }
        }

    }
}

class TriangularPrism {
    private double base;
    private double height;
    private double length;

    public TriangularPrism(double base, double height, double length) {
        this.base = base;
        this.height = height;
        this.length = length;
    }

    public double getBase() {
        return base;
    }

    public double getHeight() {
        return height;
    }

    public double getLength() {
        return length;
    }
}

class Cube {
    private double sideLength;

    public Cube(double sideLength) {
        this.sideLength = sideLength;
    }

    public double getSideLength() {
        return sideLength;
    }
}

class Cylinder {
    private double radius;
    private double height;

    public Cylinder(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }

    public double getRadius() {
        return radius;
    }

    public double getHeight() {
        return height;
    }
}

class VolumeCalculator {
    public static void VolumeOfTriangle(TriangularPrism triangularPrism) {
        double result = (0.5 * triangularPrism.getHeight()) * triangularPrism.getBase() * triangularPrism.getLength();
        System.out.printf("%.3f\n", result);
    }

    public static void VolumeOfCube(Cube cube) {
        double result = cube.getSideLength() * cube.getSideLength() * cube.getSideLength();
        System.out.printf("%.3f\n", result);
    }

    public static void VolumeOfCylinder(Cylinder cylinder) {
        double result = Math.PI * (cylinder.getRadius() * cylinder.getRadius()) * cylinder.getHeight();
        System.out.printf("%.3f\n", result);
    }
}
package Problem11_RectangleIntersection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class RectangleIntersection {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        List<Rectangle> data = new LinkedList<>();
        int[] params = Arrays.stream(sc.readLine().trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int numbersOfRect = params[0];
        int intersectionChecks = params[1];

        for (int i = 0; i < numbersOfRect; i++) {
            String[] currentParams = sc.readLine().trim().split("\\s+");
            String id = currentParams[0];
            double width = Double.parseDouble(currentParams[1]);
            double height = Double.parseDouble(currentParams[2]);
            double coordX = Double.parseDouble(currentParams[3]);
            double coordY = Double.parseDouble(currentParams[4]);
            data.add(new Rectangle(id, width, height, coordX, coordY));
        }

        for (int i = 0; i < intersectionChecks; i++) {
            String[] ids = sc.readLine().trim().split("\\s+");
            String idOne = ids[0];
            String idTwo = ids[1];

            Rectangle first = null;
            Rectangle second = null;

            for (Rectangle rectangle : data) {
                if (rectangle.getId().equals(idOne)) {
                    first = rectangle;
                }

                if (rectangle.getId().equals(idTwo)) {
                    second = rectangle;
                }
            }

            System.out.println(first.isIntersection(second));
        }
    }
}

class Rectangle {
    private String id;
    private double width;
    private double height;
    private double coordinateX;
    private double coordinateY;

    public Rectangle(String id, double width, double height, double coordinateX, double coordinateY) {
        this.id = id;
        this.width = width;
        this.height = height;
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
    }

    public String getId() {
        return id;
    }

    public boolean isIntersection(Rectangle another) {
        return this.coordinateX <= another.coordinateX + another.width &&
                this.coordinateX + width >= another.coordinateX &&
                this.coordinateY <= another.coordinateY + another.height &&
                this.coordinateY + another.height >= another.coordinateY;
    }
}
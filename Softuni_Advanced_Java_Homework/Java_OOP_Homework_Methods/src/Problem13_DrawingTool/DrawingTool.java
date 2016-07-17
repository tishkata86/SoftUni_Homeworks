package Problem13_DrawingTool;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class DrawingTool {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        String line = sc.readLine();
        Figure myFigure = null;
        switch (line){
            case "Square":
                int size = Integer.parseInt(sc.readLine());
                myFigure = new Square(size);
                break;
            case "Rectangle":
                int width = Integer.parseInt(sc.readLine());
                int height = Integer.parseInt(sc.readLine());
                myFigure = new Rectangle(width, height);
                break;
        }

        myFigure.Draw();

    }
}

interface Figure {
    void Draw();
}

class Square implements Figure {
    private int size;

    public Square(int size) {
        this.size = size;
    }

    @Override
    public void Draw() {
        System.out.printf("|%s|\n", new String(new char[this.size]).replace('\0', '-'));
        for (int i = 0; i < size - 2; i++) {
            System.out.printf("|%s|\n", new String(new char[this.size]).replace('\0', ' '));
        }
        System.out.printf("|%s|\n", new String(new char[this.size]).replace('\0', '-'));
    }
}

class Rectangle implements Figure {
    private int wight;
    private int height;

    public Rectangle(int wight, int height) {
        this.wight = wight;
        this.height = height;
    }

    @Override
    public void Draw() {
        System.out.printf("|%s|\n", new String(new char[this.wight]).replace('\0', '-'));
        for (int i = 0; i < height - 2; i++) {
            System.out.printf("|%s|\n", new String(new char[this.wight]).replace('\0', ' '));
        }
        System.out.printf("|%s|\n", new String(new char[this.wight]).replace('\0', '-'));
    }
}
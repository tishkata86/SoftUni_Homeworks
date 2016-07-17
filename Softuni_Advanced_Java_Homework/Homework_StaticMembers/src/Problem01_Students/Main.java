package Problem01_Students;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        List<Student> data = new ArrayList<>();
        String line;
        Student student = null;
        while (!"End".equals(line = sc.readLine())){
            data.add(new Student(line));
        }
        System.out.println(Student.COUNTER);
    }
}

class Student{
    private String name;
    static int COUNTER = 0;

    public Student(String name) {
        this.name = name;
        COUNTER++;
    }
}
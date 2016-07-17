package Problem02_UniqueStudentNames;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class UniqueStudentNames {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        StudentGroup studentGroup = new StudentGroup(new HashSet<>());
        String line;
        while (!"End".equals(line = sc.readLine())) {
            String name = line;
            Student newStudent = new Student(name, studentGroup);
        }

        System.out.println(StudentGroup.counter);
    }
}

class Student {
    private String name;

    public Student(String name, StudentGroup studentGroup) {
        this.name = name;
        studentGroup.addName(name);
    }
}

class StudentGroup {
    private HashSet<String> uniqueStudents;
    static int counter = 0;

    public StudentGroup(HashSet<String> uniqueStudents) {
        this.uniqueStudents = new HashSet<>();
    }

    public void addName(String name) {
        if (!uniqueStudents.contains(name)) {
            uniqueStudents.add(name);
            StudentGroup.counter++;
        }
    }
}
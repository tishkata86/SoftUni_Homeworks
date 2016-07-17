import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Problem03_OpinionPoll {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        TreeSet<String> names = new TreeSet<>();
        Set<Student> students = new HashSet<>();
        int lines = Integer.parseInt(sc.readLine());
        for (int i = 0; i < lines; i++) {
            String[] params = sc.readLine().split(" ");
            String name = params[0];
            int age = Integer.parseInt(params[1]);
            Student someone = new Student(name, age);
            students.add(someone);
            names.add(someone.name);
        }

        students.stream().sorted((x1, x2) -> x1.name.compareTo(x2.name)).filter(student1 -> student1.age > 30).forEach(student -> {
            System.out.println(student.name + " - " + student.age);
        });
    }
}

class Student {
    String name;
    int age;

    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }


}

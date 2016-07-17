package Problem03_Mankind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        try {
            String[] studentParams = sc.readLine().split("\\s+");
            String studentFirstName = studentParams[0];
            String studentLastName = studentParams[1];
            String studentFacultyNumber = studentParams[2];
            Student currentStudent = new Student(studentFirstName, studentLastName, studentFacultyNumber);
            System.out.println(currentStudent);

            String[] workerParams = sc.readLine().split("\\s+");
            String workerFirstName = workerParams[0];
            String workerLastName = workerParams[1];
            double workerSalary = Double.parseDouble(workerParams[2]);
            double workderHours = Double.parseDouble(workerParams[3]);
            Worker currentWorker = new Worker(workerFirstName, workerLastName, workerSalary, workderHours);
            System.out.println(currentWorker);

        } catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }
    }
}

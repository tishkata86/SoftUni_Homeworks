import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem04_CompanyRoster {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        int line = Integer.parseInt(sc.readLine());
        List<Employee> allEmplyee = new ArrayList<>();
        Map<String, BigDecimal> departments = new HashMap<>();

        for (int i = 0; i < line; i++) {
            String[] params = sc.readLine().split("\\s+");
            String name = params[0];
            BigDecimal salary = new BigDecimal(params[1]);
            String position = params[2];
            String department = params[3];

            if (params.length == 6) {
                String email = params[4];
                int age = Integer.parseInt(params[5]);
                allEmplyee.add(new Employee(name, salary, position, department, email, age));
            } else if (params.length == 5) {
                if (params[4].contains("@")) {
                    String email = params[4];
                    allEmplyee.add(new Employee(name, salary, position, department, email));
                } else {
                    int age = Integer.parseInt(params[4]);
                    allEmplyee.add(new Employee(name, salary, position, department, age));
                }
            } else if (params.length == 4){
                allEmplyee.add(new Employee(name, salary, position, department));
            }
        }

        for (Employee employee : allEmplyee) {
            if (!departments.containsKey(employee.department)) {
                departments.put(employee.department, employee.salary);
            } else {
                BigDecimal oldSum = departments.get(employee.department);
                departments.put(employee.department, oldSum.add(employee.salary));
            }
        }


        BigDecimal biggestDepart = new BigDecimal(0);
        String richestDepart = "";
        for (Map.Entry<String, BigDecimal> entry : departments.entrySet()) {
            int isTrue = entry.getValue().compareTo(biggestDepart);
            if (isTrue == 1){
                biggestDepart = entry.getValue();
                richestDepart = entry.getKey();
            }
        }

        String dep = richestDepart;
        System.out.println("Highest Average Salary: " + dep);
        allEmplyee.stream().sorted((e1, e2) -> e2.salary.compareTo(e1.salary)).forEach(employee -> {
            if (employee.department.equals(dep)){
                System.out.printf("%s %.2f %s %d\n",employee.name, employee.salary, employee.email, employee.age);
            }
        });
    }
}

class Employee {
    String name;
    BigDecimal salary;
    String position;
    String department;
    String email;
    int age;

    Employee(String name, BigDecimal salary, String position, String department, String email, int age) {
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
        this.email = email;
        this.age = age;
    }

    Employee(String name, BigDecimal salary, String position, String department, String email) {
        this(name, salary, position, department, email, -1);
    }

    Employee(String name, BigDecimal salary, String position, String department, int age) {
        this(name, salary, position, department, "n/a", age);
    }

    Employee(String name, BigDecimal salary, String position, String department) {
        this(name, salary, position, department, "n/a", -1);
    }
}
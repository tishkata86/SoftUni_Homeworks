package Problem08_MilitaryElite.Models;

import Problem08_MilitaryElite.Interfaces.PrivateInterface;

public class Private extends Soldier implements PrivateInterface{
    private double salary;

    public Private(String id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName);
        this.setSalary(salary);
    }

    public double getSalary() {
        return salary;
    }

    private void setSalary(double salary) {
        this.salary = salary;
    }

    public String toString() {
        return String.format("Name: %s %s Id: %s Salary: %.2f\n",
                getFirstName(),
                getLastName(),
                getId(),
                getSalary());
    }
}

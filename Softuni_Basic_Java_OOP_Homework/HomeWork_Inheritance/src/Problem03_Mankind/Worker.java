package Problem03_Mankind;

public class Worker extends Human {
    private double weekSalary;
    private double workHoursPerDay;
    private double  salaryPerHour;


    public Worker(String firstName, String lastName, double weekSalary, double workHoursPerDay) {
        super(firstName, lastName);
        setWeekSalary(weekSalary);
        setWorkHoursPerDay(workHoursPerDay);
        salaryPerHour = setSalaryPerHour();
    }

    public double getWeekSalary() {
        return weekSalary;
    }

    public double getWorkHoursPerDay() {
        return workHoursPerDay;
    }

    public double getSalaryPerHour() {
        return salaryPerHour;
    }

    private void setWeekSalary(double weekSalary) {
        if (weekSalary < 10){
            throw new IllegalArgumentException("Expected value mismatch!Argument: weekSalary");
        }
        this.weekSalary = weekSalary;
    }

    private void setWorkHoursPerDay(double workHoursPerDay) {
        if (workHoursPerDay < 1 || workHoursPerDay > 12){
            throw new IllegalArgumentException("Expected value mismatch!Argument: workHoursPerDay");
        }
        this.workHoursPerDay = workHoursPerDay;
    }

    private double setSalaryPerHour() {
        return getWeekSalary() / (7 * getWorkHoursPerDay());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("First Name: " + getFirstName() + "\n");
        sb.append("Last Name: " + getLastName() + "\n");
        sb.append(String.format("Week Salary: %.2f\n", getWeekSalary()));
        sb.append(String.format("Hours per day: %.2f\n",getWorkHoursPerDay()));
        sb.append(String.format("Salary per hour: %.2f\n",getSalaryPerHour()));
        return sb.toString();
    }
}

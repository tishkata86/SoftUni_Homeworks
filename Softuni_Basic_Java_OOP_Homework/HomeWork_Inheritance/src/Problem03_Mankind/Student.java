package Problem03_Mankind;

public class Student extends Human {
    private String facultyNumber;

    public Student(String firstName, String lastName, String facultyNumber) {
        super(firstName, lastName);
        setFacultyNumber(facultyNumber);
    }

    public String getFacultyNumber() {
        return facultyNumber;
    }

    private void setFacultyNumber(String facultyNumber) {
        if (facultyNumber.length() < 5 || facultyNumber.length() > 10) {
            throw new IllegalArgumentException("Invalid faculty number!");
        }
        for (int i = 0; i < facultyNumber.length(); i++) {
            if (!Character.isDigit(facultyNumber.charAt(i)) &&
                    !Character.isLetter(facultyNumber.charAt(i))) {
                throw new IllegalArgumentException("Invalid faculty number!");
            }
        }
        this.facultyNumber = facultyNumber;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("First Name: " + getFirstName() + "\n");
        sb.append("Last Name: " + getLastName() + "\n");
        sb.append("Faculty number: " + getFacultyNumber() + "\n");
        return sb.toString();
    }
}

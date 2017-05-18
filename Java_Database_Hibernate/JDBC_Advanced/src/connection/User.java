package connection;

import persistance.Column;
import persistance.Entity;
import persistance.Id;

import java.util.Date;

@Entity(name = "users")
public class User {

    @Id
    private int id;

    @Column(name = "password")
    private String password;

    @Column(name = "age")
    private int age;

    @Column(name = "registration_date")
    private Date registrationDate;

    public User(int id, String password, int age, Date registrationDate) {
        this.setId(id);
        this.setPassword(password);
        this.setAge(age);
        this.setRegistrationDate(registrationDate);
    }

    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    private void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    private void setAge(int age) {
        this.age = age;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    private void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }
}

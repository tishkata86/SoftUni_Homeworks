package common;

import entities.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

public class CreateObjects {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Department newDepartment = new Department();
        newDepartment.setName("SearchAndEngine");
        Employee manager = em.find(Employee.class, 5);
        newDepartment.setManager(manager);

        Town town = new Town();
        town.setName("Burgas");

        Address address1 = new Address();
        address1.setAddressText("Stefan Shikov 27");
        address1.setTown(town);
        Address address2 = new Address();
        address2.setAddressText("Ivan Vazov 5a");
        address2.setTown(town);
        Address address3 = new Address();
        address3.setAddressText("Gorno Nanadolinishte 99");
        address3.setTown(town);
        Address address4 = new Address();
        address4.setAddressText("Merlin Monro 69");
        address4.setTown(town);
        Address address5 = new Address();
        address5.setAddressText("Hollywood 25");
        address5.setTown(town);

        Employee employee1 = new Employee();
        employee1.setFirstName("Ivan");
        employee1.setMiddleName("Ivanov");
        employee1.setLastName("Ivanov");
        employee1.setJobTitle("Chukar");
        employee1.setDepartment(newDepartment);
        employee1.setManager(manager);
        employee1.setHireDate(new Date());
        employee1.setSalary(new BigDecimal(10000));
        employee1.setAddress(address2);
        employee1.setProjects(new ArrayList<>());
        Employee employee2 = new Employee();
        employee2.setFirstName("Hasan");
        employee2.setMiddleName("Ali");
        employee2.setLastName("Reza");
        employee2.setJobTitle("Lekar");
        employee2.setDepartment(em.find(Department.class, 3));
        employee2.setManager(manager);
        employee2.setHireDate(new Date());
        employee2.setSalary(new BigDecimal(32100));
        employee2.setAddress(address4);
        employee2.setProjects(new ArrayList<>());
        Employee employee3 = new Employee();
        employee3.setFirstName("Georgi");
        employee3.setMiddleName("Georgiev");
        employee3.setLastName("Georgiev");
        employee3.setJobTitle("Pekar");
        employee3.setDepartment(em.find(Department.class, 1));
        employee3.setManager(em.find(Employee.class, 2));
        employee3.setHireDate(new Date());
        employee3.setSalary(new BigDecimal(12300));
        employee3.setAddress(address1);
        employee3.setProjects(new ArrayList<>());
        Employee employee4 = new Employee();
        employee4.setFirstName("Stefan");
        employee4.setMiddleName("Stefanov");
        employee4.setLastName("Stefanov");
        employee4.setJobTitle("Gradinar");
        employee4.setDepartment(newDepartment);
        employee4.setManager(manager);
        employee4.setHireDate(new Date());
        employee4.setSalary(new BigDecimal(5800));
        employee4.setAddress(address4);
        employee4.setProjects(new ArrayList<>());
        Employee employee5 = new Employee();
        employee5.setFirstName("Paskal");
        employee5.setMiddleName("Mihalov");
        employee5.setLastName("Stavrev");
        employee5.setJobTitle("Zavivach");
        employee5.setDepartment(em.find(Department.class, 4));
        employee5.setManager(manager);
        employee5.setHireDate(new Date());
        employee5.setSalary(new BigDecimal(45600));
        employee5.setAddress(address1);
        employee5.setProjects(new ArrayList<>());

        Project project = new Project();
        project.setName("First Project");
        project.setDescription("Awesome");
        project.setStartDate(new Date());
        project.setEndDate(new Date());

        employee1.getProjects().add(project);
        employee3.getProjects().add(project);
        employee5.getProjects().add(project);

        em.persist(newDepartment);
        em.persist(town);
        em.persist(address1);
        em.persist(address2);
        em.persist(address3);
        em.persist(address4);
        em.persist(address5);
        em.persist(project);
        em.persist(employee1);
        em.persist(employee2);
        em.persist(employee3);
        em.persist(employee4);
        em.persist(employee5);

        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}

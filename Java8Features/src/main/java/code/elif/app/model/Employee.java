package code.elif.app.model;

import java.time.LocalDate;

public class Employee {
    Integer id;
    String name;
    LocalDate startDate;

    public Employee() {
        System.out.println("Empty Employee");
    }

    public Employee(Integer id, String name, LocalDate startDate) {
        this.id = id;
        this.name = name;
        System.out.println("Employee id: " + id + ", name: " + name + "startDate: " + startDate);
    }
}

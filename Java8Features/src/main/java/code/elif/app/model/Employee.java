package code.elif.app.model;

import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@ToString
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
        this.startDate = startDate;
        System.out.println("Created Employee id: " + id + ", name: " + name + " startDate: " + startDate);
    }
}

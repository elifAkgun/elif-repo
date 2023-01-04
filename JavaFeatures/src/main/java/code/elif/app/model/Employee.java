package code.elif.app.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
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
    }
}

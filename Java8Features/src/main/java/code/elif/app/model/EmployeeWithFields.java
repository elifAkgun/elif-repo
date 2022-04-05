package code.elif.app.model;

import java.time.LocalDate;

@FunctionalInterface
public interface EmployeeWithFields {
    Employee get(Integer id, String name, LocalDate startDate);
}

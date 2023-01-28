package code.elif.app.features.java14;

import code.elif.app.model.Employee;

public class NullPointerExceptionExample {
    public static void main(String[] args) {
        Employee employee = Employee.builder()
                .id(1)
                .name("John")
                .build();

        System.out.println(employee.getStartDate().getDayOfMonth());
    }
}

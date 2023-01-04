package code.elif.app.features.java9.copyOf;

import code.elif.app.model.Employee;

import java.time.LocalDate;
import java.util.List;

//Example shows how to use copyOf method in a List.
public class CopyOfListEmployee {
    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee(1, "Lesley", LocalDate.now()),
                new Employee(2, "Yin", LocalDate.now()),
                new Employee(3, "Rafael", LocalDate.now()));

        usingCopyOf(employees);
    }
    public static void usingCopyOf(List<Employee> employeeList) {
        List<Employee> employeeCopyList = List.copyOf(employeeList);

        Employee employee = employeeList.get(0);
        employee.setName("John");

        System.out.println("Original - " + employeeList);
        System.out.println("CopyOf - " + employeeCopyList);
    }
}


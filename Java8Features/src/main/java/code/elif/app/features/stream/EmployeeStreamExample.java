package code.elif.app.features.stream;

import code.elif.app.model.Employee;
import code.elif.app.service.EmployeeService;
import code.elif.app.service.EmployeeServiceImpl;

import java.time.LocalDate;
import java.util.List;

public class EmployeeStreamExample {
    public static void main(String[] args) {
        EmployeeService employeeService = new EmployeeServiceImpl();

        List<Employee> employeeList = employeeService.getEmployeeList();

        employeeList.stream()
                .filter(employee -> employee.getStartDate().isAfter(LocalDate.now().minusYears(5)))
                .forEach(employee -> System.out.println(employee));
    }
}

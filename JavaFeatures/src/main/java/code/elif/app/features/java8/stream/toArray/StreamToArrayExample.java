package code.elif.app.features.stream.toArray;

import code.elif.app.model.Employee;
import code.elif.app.service.EmployeeService;
import code.elif.app.service.EmployeeServiceImpl;

import java.util.List;

public class StreamToArrayExample {

    public static void main(String[] args) {
        processStreamToArray();
    }

    private static void processStreamToArray() {
        EmployeeService employeeService = new EmployeeServiceImpl();
        List<Employee> employeeList = employeeService.getEmployeeListOrderByStartDate();

        Employee[] employees = employeeList.stream().toArray(Employee[]::new);

        for (int i = 0; i < employees.length; i++) {
            System.out.println(employees[i]);
        }
    }
}

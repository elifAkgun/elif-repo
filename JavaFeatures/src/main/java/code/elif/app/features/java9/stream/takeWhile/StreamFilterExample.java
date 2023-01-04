package code.elif.app.features.java9.stream.takeWhile;

import code.elif.app.model.Employee;
import code.elif.app.model.Shape;
import code.elif.app.service.EmployeeService;
import code.elif.app.service.EmployeeServiceImpl;
import code.elif.app.service.ShapeService;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class StreamFilterExample {

    public static void main(String[] args) {
        List<Employee> employees = filterEmployeeListUsingTakeWhile();
        System.out.println(employees);
    }

    private static List<Employee> filterEmployeeListUsingTakeWhile() {
        EmployeeService employeeService = new EmployeeServiceImpl();
        List<Employee> employeeList = employeeService.getEmployeeListOrderByStartDate();
        return employeeList.stream()
                .peek(e -> System.out.println( e + " processed employee"))
                .takeWhile(employee -> employee.getStartDate()
                        .isBefore(LocalDate.of(2011,1,1)))
                .peek(e -> System.out.println( e + " filtered employee"))
                .collect(Collectors.toList());
    }

}

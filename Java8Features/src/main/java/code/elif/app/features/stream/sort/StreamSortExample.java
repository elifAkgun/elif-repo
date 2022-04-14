package code.elif.app.features.stream.sort;

import code.elif.app.model.Employee;
import code.elif.app.model.EmployeeComparator;
import code.elif.app.service.EmployeeService;
import code.elif.app.service.EmployeeServiceImpl;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamSortExample {

    public static void main(String[] args) {
        processBySorted();
        sortEmployeeList();
    }

    private static void processBySorted() {
        List<Integer> list = Arrays.asList(10, 15, 25, 20, 5, 0);

        List<Integer> list1 = list.stream().sorted().collect(Collectors.toList());
        System.out.println("ascending order" + list1);

        List<Integer> list2 = list.stream().sorted((a, b) -> a > b ? -1 : 1)
                .collect(Collectors.toList());
        System.out.println("descending order" + list2);
    }

    private static void sortEmployeeList() {

        EmployeeService employeeService = new EmployeeServiceImpl();
        List<Employee> employeeList = employeeService.getEmployeeList();

        EmployeeComparator employeeComparator = new EmployeeComparator();
        employeeList.stream().sorted(employeeComparator)
                .forEach(employee -> System.out.println(employee));
    }

    private static void sortEmployeeMethodUsingReference() {

        EmployeeService employeeService = new EmployeeServiceImpl();
        List<Employee> employeeList = employeeService.getEmployeeList();

        employeeList.stream().sorted(Comparator.comparingInt(Employee::getId))
                .forEach(employee -> System.out.println(employee));
    }
}

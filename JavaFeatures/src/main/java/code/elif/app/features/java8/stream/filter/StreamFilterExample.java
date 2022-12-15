package code.elif.app.features.java8.stream.filter;

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
        List<Employee> employees = filterEmployeeList();
        System.out.println(employees);
    }


    private static List<Employee> filterEmployeeList() {
        EmployeeService employeeService = new EmployeeServiceImpl();
        List<Employee> employeeList = employeeService.getEmployeeListOrderByStartDate();
       return employeeList.stream()
                .peek(e -> System.out.println( e + " processed employee"))
                .filter(employee -> employee.getStartDate()
                        .isBefore(LocalDate.of(2011,1,1)))
                .peek(e -> System.out.println( e + " filtered employee"))
               .collect(Collectors.toList());
    }

    private static void filterExample() {
        List<Integer> list = Arrays.asList(10, 15, 25, 20, 5, 0);
        List<Integer> collectedList = list.stream().filter(i -> i % 2 == 0)
                .collect(Collectors.toList());
        System.out.println(collectedList);
    }

    private static void filterShapeExample() {
        ShapeService shapeService = new ShapeService();

        List<Shape> shapeList = (List<Shape>) shapeService.getShapes();

        List<Shape> collectedList = shapeList.stream()
                .filter(s -> s.getArea() > 50)
                .collect(Collectors.toList());
        for (Shape s : collectedList) {
            s.draw();
        }
    }


}

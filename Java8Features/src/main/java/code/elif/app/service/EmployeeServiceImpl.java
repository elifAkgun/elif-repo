package code.elif.app.service;

import code.elif.app.model.Employee;
import code.elif.app.model.EmployeeWithFields;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {

    @Override
    public List<Employee> getEmployeeList() {
        List<Employee> employeeList = new ArrayList<>();

        EmployeeWithFields e1 = Employee::new;
        employeeList.add(e1.get(3, "Jenifer", LocalDate.of(2017, 9, 12)));
        employeeList.add(e1.get(1, "John", LocalDate.of(2020, 10, 2)));
        employeeList.add(e1.get(2, "Mike", LocalDate.of(2010, 7, 30)));

        return employeeList;
    }
}

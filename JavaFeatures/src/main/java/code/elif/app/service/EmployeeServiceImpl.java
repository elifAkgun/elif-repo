package code.elif.app.service;

import code.elif.app.model.Employee;
import code.elif.app.model.EmployeeWithFields;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {

    @Override
    public List<Employee> getEmployeeListOrderByStartDate() {
        List<Employee> employeeList = new ArrayList<>();

        EmployeeWithFields e1 = Employee::new;
        employeeList.add(e1.get(1, "Jenifer", LocalDate.of(2005, 9, 12)));
        employeeList.add(e1.get(2, "Mike", LocalDate.of(2009, 7, 30)));
        employeeList.add(e1.get(3, "John", LocalDate.of(2015, 10, 2)));
        employeeList.add(e1.get(4, "Sarah", LocalDate.of(2021, 9, 12)));
        employeeList.add(e1.get(5, "Ken", LocalDate.of(2022, 7, 30)));
        employeeList.add(e1.get(6, "Micheal", LocalDate.of(2022, 10, 2)));
        return employeeList;
    }
}

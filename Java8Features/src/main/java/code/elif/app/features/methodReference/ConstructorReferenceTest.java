package code.elif.app.features.methodReference;

import code.elif.app.model.Employee;
import code.elif.app.model.EmployeeEmpty;
import code.elif.app.model.EmployeeWithFields;

import java.time.LocalDate;

public class ConstructorReferenceTest {
    public static void main(String[] args) {
        EmployeeEmpty e1 = Employee::new;
        e1.get();

        EmployeeWithFields e2 = Employee::new;
        e2.get(7, "John",  LocalDate.of(2000,1,1) );
    }
}


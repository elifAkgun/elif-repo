package code.elif;

/**
 * An object adapter. Using composition to translate interface
 */
public class EmployeeObjectAdapter implements  Customer{

    Employee employee;

    public EmployeeObjectAdapter(Employee employee){
        this.employee = employee;
    }

    public String getName() {
        return employee.getFullName();
    }

    public String getDesignation() {
        return employee.getJobTitle();
    }

    public String getAddress() {
        return employee.getOfficeLocation();
    }
}

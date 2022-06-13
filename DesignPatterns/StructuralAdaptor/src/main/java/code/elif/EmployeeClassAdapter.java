package code.elif;

/**
 * A class adapter, works as Two-way adapter
 */
public class EmployeeClassAdapter extends Employee implements Customer {

    public String getName() {
        return this.getFullName();
    }

    public String getDesignation() {
        return this.getJobTitle();
    }

    public String getAddress() {
        return this.getOfficeLocation();
    }
}

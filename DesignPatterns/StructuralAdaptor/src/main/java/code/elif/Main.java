package code.elif;

public class Main {

	public static void main(String[] args) {
		/** Using Class/Two-way adapter **/ 
		EmployeeClassAdapter employeeClassAdapter = new EmployeeClassAdapter();
		populateEmployeeData(employeeClassAdapter);

		BusinessCardDesigner businessCardDesigner = new BusinessCardDesigner();
		String designCard1 = businessCardDesigner.designCard(employeeClassAdapter);
		System.out.println(designCard1);


		/** Using Object Adapter **/

		Employee employee = new Employee();
		populateEmployeeData(employee);

		EmployeeObjectAdapter employeeObjectAdapter = new EmployeeObjectAdapter(employee);

		String designCard2 = businessCardDesigner.designCard(employeeObjectAdapter);
		System.out.println(designCard2);

	}

	private static void populateEmployeeData(Employee employee) {
		employee.setFullName("Elliot Alderson");
		employee.setJobTitle("Security Engineer");
		employee.setOfficeLocation("Allsafe Cybersecurity, New York City, New York");
	}
}

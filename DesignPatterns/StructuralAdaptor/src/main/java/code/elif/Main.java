package code.elif;

public class Main {

	public static void main(String[] args) {
		/** Using Class/Two-way adapter **/ 
		EmployeeClassAdapter employeeClassAdapter = new EmployeeClassAdapter();
		populateEmployeeData(employeeClassAdapter);

		BusinessCardDesigner businessCardDesigner = new BusinessCardDesigner();
		String designCard = businessCardDesigner.designCard(employeeClassAdapter);
		System.out.println(designCard);


		/** Using Object Adapter **/
		
	}

	private static void populateEmployeeData(Employee employee) {
		employee.setFullName("Elliot Alderson");
		employee.setJobTitle("Security Engineer");
		employee.setOfficeLocation("Allsafe Cybersecurity, New York City, New York");
	}
}

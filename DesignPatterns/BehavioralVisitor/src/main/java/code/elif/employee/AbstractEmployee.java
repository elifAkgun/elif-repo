package code.elif.employee;

import lombok.Getter;
import lombok.Setter;

import java.util.Collection;
import java.util.Collections;

@Getter
@Setter
public abstract class AbstractEmployee implements Employee {

	private int performanceRating;
	
	private String name;
	
	private static int employeeIdCounter = 101;
	
	private int employeeId;
	
	public AbstractEmployee(String name) {
		this.name = name;
		employeeId = employeeIdCounter++;
	}

	@Override
	public Collection<Employee> getDirectReports() {
		return Collections.emptyList();
	}

}
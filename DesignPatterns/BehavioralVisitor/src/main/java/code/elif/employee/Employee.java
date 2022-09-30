package code.elif.employee;

import code.elif.employee.visitor.Visitor;

import java.util.Collection;

public interface Employee {

	int getPerformanceRating();

	void setPerformanceRating(int rating);

	Collection<Employee> getDirectReports();

	int getEmployeeId();

	void accept(Visitor visitor);
}
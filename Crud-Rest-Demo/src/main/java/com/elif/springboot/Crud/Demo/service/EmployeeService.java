package com.elif.springboot.Crud.Demo.service;

import java.util.List;

import com.elif.springboot.Crud.Demo.entity.Employee;

public interface EmployeeService {
	
	public List<Employee> getAllEmployee();

	public Employee getEmployee(int id);

	public void deleteEmployee(int id);

	public void saveEmployee(Employee employee);

}

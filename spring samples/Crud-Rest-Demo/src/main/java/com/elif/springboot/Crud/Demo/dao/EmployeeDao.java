package com.elif.springboot.Crud.Demo.dao;

import java.util.List;

import com.elif.springboot.Crud.Demo.entity.Employee;

public interface EmployeeDao {
	
	public List<Employee> getAllEmployee();
	
	public Employee getEmployee(int id);
	
	public void deleteEmployee(int id);
	
	public void saveEmployee(Employee employee);
	
}

package com.elif.springboot.Crud.Demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elif.springboot.Crud.Demo.entity.Employee;
import com.elif.springboot.Crud.Demo.service.EmployeeService;

@RestController
@RequestMapping("repo/api")
public class EmployeeRestController {

	private EmployeeService employeeService;

	// inject employeedao using constructor
	@Autowired
	public EmployeeRestController(@Qualifier("employeeServiceImpl")EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@GetMapping("/employee")
	public List<Employee> getEmployeeList() {
		List<Employee> allEmployee = employeeService.getAllEmployee();

		if (allEmployee.size() == 0) {
			throw new RuntimeException("There is not available record!");
		}

		return allEmployee;
	}

	@GetMapping("/employee/{id}")
	public Employee getEmployee(@PathVariable("id") int id) {
		Employee employee = employeeService.getEmployee(id);

		if (employee == null) {
			throw new RuntimeException("The employee not found! id: " + id);
		}
		return employee;
	}

	@DeleteMapping("/employee/{id}")
	public String deleteEmployee(@PathVariable("id") int id) {
		employeeService.deleteEmployee(id);
		return "Your record successfully deleted.";
	}

	@PostMapping("/employee/{id}")
	public Employee updateEmployee(@PathVariable("id") int id, @RequestBody Employee employee) {
		employee.setId(id);
		employeeService.saveEmployee(employee);
		return employee;
	}

	@PutMapping("/employee")
	public Employee createEmployee(@RequestBody Employee employee) {
		employee.setId(0);
		employeeService.saveEmployee(employee);
		return employee;
	}

}

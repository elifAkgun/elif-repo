package com.elif.springboot.Crud.Demo.service.impl;

import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.elif.springboot.Crud.Demo.dao.EmployeeRepostory;
import com.elif.springboot.Crud.Demo.entity.Employee;
import com.elif.springboot.Crud.Demo.service.EmployeeService;

@Service
public class EmployeeServiceImplUseRepo implements EmployeeService {

	private EmployeeRepostory employeeRepo;

	@Autowired
	public EmployeeServiceImplUseRepo(EmployeeRepostory employeeRepo) {
		this.employeeRepo = employeeRepo;
	}

	@Override
	@Transactional
	public List<Employee> getAllEmployee() {
		return employeeRepo.findAll();
	}

	@Override
	@Transactional
	public Employee getEmployee(int id) {
		Optional<Employee> result = employeeRepo.findById(id);

		if (result.isPresent()) {
			return result.get();
		}
		else {
			throw new RuntimeException("There is no employee with the id: " + id);
		}
	}

	@Override
	@Transactional
	public void deleteEmployee(int id) {
		employeeRepo.deleteById(id);
	}

	@Override
	@Transactional
	public void saveEmployee(Employee employee) {
		employeeRepo.save(employee);
	}

}

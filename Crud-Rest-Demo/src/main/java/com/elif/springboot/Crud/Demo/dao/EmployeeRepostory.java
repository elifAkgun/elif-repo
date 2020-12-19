package com.elif.springboot.Crud.Demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elif.springboot.Crud.Demo.entity.Employee;

public interface EmployeeRepostory extends JpaRepository<Employee, Integer> {
	
	//there is no need to write a code...

}

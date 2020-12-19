package com.elif.springboot.Crud.Demo.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.elif.springboot.Crud.Demo.dao.EmployeeDao;
import com.elif.springboot.Crud.Demo.entity.Employee;

@Repository
public class EmployeeDaoImplJpa implements EmployeeDao {
	
	private EntityManager entityManager;
	
	@Autowired
	public EmployeeDaoImplJpa (EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Employee> getAllEmployee() {
		TypedQuery<Employee> createQuery = entityManager.createQuery(" from Employee",Employee.class);
		return createQuery.getResultList();
	}

	@Override
	public Employee getEmployee(int id) {
		Employee employee = entityManager.find(Employee.class, id);
		return employee;
	}

	@Override
	public void deleteEmployee(int id) {
		Query query = entityManager.createQuery("delete from Employee where id=:employeeId");
		query.setParameter("employeeId", id);
		query.executeUpdate();
	}

	@Override
	public void saveEmployee(Employee employee) {
		Employee merge = entityManager.merge(employee);
		employee.setId(merge.getId());

	}

}

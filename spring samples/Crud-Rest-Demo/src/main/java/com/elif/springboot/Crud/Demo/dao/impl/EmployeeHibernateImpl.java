package com.elif.springboot.Crud.Demo.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.elif.springboot.Crud.Demo.dao.EmployeeDao;
import com.elif.springboot.Crud.Demo.entity.Employee;

@Repository
public class EmployeeHibernateImpl implements EmployeeDao {

	private EntityManager entityManager;

	@Autowired
	public EmployeeHibernateImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Employee> getAllEmployee() {
		Session session = entityManager.unwrap(Session.class);
		Query<Employee> query = session.createQuery("from Employee", Employee.class);
		return query.getResultList();
	}

	@Override
	public Employee getEmployee(int id) {
		Session session = entityManager.unwrap(Session.class);
//		Query<Employee> query = session.createQuery("from Employee where id=:employeeid", Employee.class);
//		query.setParameter("employeeid", id);
		return session.get(Employee.class, id);
		
	}

	@Override
	public void deleteEmployee(int id) {
		Session session = entityManager.unwrap(Session.class);
		Employee employee = getEmployee(id);
		session.delete(employee);

	}

	@Override
	public void saveEmployee(Employee employee) {
		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(employee);

	}

}

package com.elif.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.elif.entity.Customer;
import com.elif.service.Service;

@Transactional
public class CustomerServiceImpl implements Service<Customer> {

	@PersistenceContext
	EntityManager entityManager; // This is JPA provider entity provider.

	@Override
	public long create(Customer t) {
		entityManager.persist(t);
		return t.getId();
	}

	@Override
	public Customer update(Customer t) {
		entityManager.merge(t);
		return t;
	}

	@Override
	public Customer find(long id) {
		return entityManager.find(Customer.class, id);
	}

	@Override
	public List<Customer> findAll() {
		return entityManager.createQuery("SELECT t FROM Customer t", Customer.class).getResultList();

	}

}

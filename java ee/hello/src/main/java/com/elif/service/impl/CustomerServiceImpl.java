package com.elif.service.impl;

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
	public Customer save(Customer t) {

		if (t.getId() == null) {
			entityManager.persist(t);
		}
		else {
			entityManager.merge(t);
		}
		
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

	@Override
	public void delete(Customer t) {
		if (!entityManager.contains(t)) {
		    t = entityManager.merge(t);
		}
		entityManager.remove(t);
	}

}

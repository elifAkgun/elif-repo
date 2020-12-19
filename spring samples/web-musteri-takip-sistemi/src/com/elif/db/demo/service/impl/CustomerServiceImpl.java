package com.elif.db.demo.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elif.db.demo.dao.CustomerDao;
import com.elif.db.demo.entity.Customer;
import com.elif.db.demo.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	// need to inject session factory
	@Autowired
	private CustomerDao customerDao;

	@Transactional
	@Override
	public List<Customer> getCustomers() {

		// return customer list
		return customerDao.getCustomers();
	}
	@Transactional
	@Override
	public void saveCustomer(Customer customer) {
		customerDao.saveCustomer(customer);

	}
	
	@Transactional
	@Override
	public Customer getCustomers(int customerId) {
		// TODO Auto-generated method stub
		return customerDao.getCustomers(customerId);
	}
	
	@Transactional
	@Override
	public void deleteCustomer(int customerId) {
		customerDao.deleteCustomer(customerId);
	}
	
	
	@Override
    @Transactional
    public List<Customer> searchCustomers(String theSearchName) {

        return customerDao.searchCustomers(theSearchName);
    }

}

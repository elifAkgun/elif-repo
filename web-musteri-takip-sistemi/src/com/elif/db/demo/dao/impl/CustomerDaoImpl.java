package com.elif.db.demo.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.elif.db.demo.dao.CustomerDao;
import com.elif.db.demo.entity.Customer;

@Repository
@SuppressWarnings("deprecation")
public class CustomerDaoImpl implements CustomerDao {

	// need to inject session factory
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Customer> getCustomers() {
		// get session
		Session session = sessionFactory.getCurrentSession();
		// create query and get customers
		Query<Customer> query = session.createQuery("from Customer order by lastName", Customer.class);

		// return customer list
		return query.getResultList();
	}

	@Override
	public void saveCustomer(Customer customer) {
		// get session
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(customer);

	}

	@Override
	public Customer getCustomers(int customerId) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Customer.class, customerId);
	}

	@Override
	public void deleteCustomer(int customerId) {
		Session session = sessionFactory.getCurrentSession();
		
//		Customer customer = session.get(Customer.class, customerId);
//		session.delete(customer);
		
		Query<?> theQuery = session.createQuery("delete from Customer where id=:customerId");
		theQuery.setParameter("customerId", customerId);
		
		theQuery.executeUpdate();

	}

	  @Override
	    public List<Customer> searchCustomers(String theSearchName) {

	        // get the current hibernate session
	        Session currentSession = sessionFactory.getCurrentSession();
	        
	        Query theQuery = null;
	        
	        //
	        // only search by name if theSearchName is not empty
	        //
	        if (theSearchName != null && theSearchName.trim().length() > 0) {

	            // search for firstName or lastName ... case insensitive
	            theQuery =currentSession.createQuery("from Customer where lower(firstName) like :theName or lower(lastName) like :theName", Customer.class);
	            theQuery.setParameter("theName", "%" + theSearchName.toLowerCase() + "%");

	        }
	        else {
	            // theSearchName is empty ... so just get all customers
	            theQuery =currentSession.createQuery("from Customer", Customer.class);            
	        }
	        
	        // execute query and get result list
	        List<Customer> customers = theQuery.getResultList();
	                
	        // return the results        
	        return customers;
	        
	    }

}

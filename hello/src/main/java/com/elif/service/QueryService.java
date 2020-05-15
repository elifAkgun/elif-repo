package com.elif.service;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;

import com.elif.jpa.Bank;
import com.elif.jpa.Customer;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Stateless
public class QueryService {
	
	private int queryId;


    @PostConstruct
    private void init() {
    	System.out.println("@PostConstruct ->>> " + this.hashCode());
    }

    @PreDestroy
    private void destroy() {
    	System.out.println("@PreDestroy ->>>  " + this.hashCode());
    }

    public List<Customer> getCustomers() {
        return null;
    }


    public List<Bank> getBanks() {
        return null;
    }
}

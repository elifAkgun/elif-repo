package com.elif.service;

import java.util.List;

import com.elif.entity.AbstractEntity;
import com.elif.entity.Customer;

public interface Service<T extends AbstractEntity> {
	
	public T find(long id);
	
	public List<T> findAll();

	public T save(T t);
	
	public void delete(T t);
}

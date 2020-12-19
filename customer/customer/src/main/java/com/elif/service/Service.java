package com.elif.service;

import java.util.List;

import com.elif.entity.AbstractEntity;

public interface Service<T extends AbstractEntity> {
	
	public long create(T t);
	
	public T update (T t);
	
	public T find(long id);
	
	public List<T> findAll();
}

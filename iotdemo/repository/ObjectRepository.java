package com.iot.iotdemo.repository;

import java.util.List;

public interface ObjectRepository<T> {
	
	public void save(T t);

	public T findById(int id);

	public T search(String name);

	public T delete(int id);
	
	public List<T> findAll();
	
	public void deleteAll();
	
	

}

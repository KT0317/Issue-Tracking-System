package com.fdmgroup.dao;

import java.util.List;

import com.fdmgroup.model.Employee;

public interface IUserDao extends IStorage<Employee>, IEditable<Employee>, IRemovable<Employee> {
	public Employee findByUsername(String username);
	public List<Employee> findByFirstname(String firstname);
}

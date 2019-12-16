package com.fdmgroup.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import com.fdmgroup.model.Department;
import com.fdmgroup.model.Ticket;
import com.fdmgroup.model.TicketStatus;
import com.fdmgroup.model.Employee;

public class UserDao implements IUserDao{
	
	private DbConnection connection;

	public UserDao() {
		super();
		connection = DbConnection.getInstance();
	}

	@Override
	public Employee create(Employee t) {
		EntityManager em = connection.getEntityManager();
		em.getTransaction().begin();
		em.persist(t);
		em.getTransaction().commit();
		em.close();
		
		return t;
	}

	@Override
	public Employee findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee update(Employee t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(Employee t) {
		EntityManager em = connection.getEntityManager();
		Employee foundEmployee = em.find(Employee.class, t.getId());
		
		em.getTransaction().begin();
		foundEmployee.setActive(false);
		em.getTransaction().commit();
		em.close();
		
	}

	@Override
	public Employee findByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> findByFirstname(String firstname) {
		// TODO Auto-generated method stub
		return null;
	}
	

	
}

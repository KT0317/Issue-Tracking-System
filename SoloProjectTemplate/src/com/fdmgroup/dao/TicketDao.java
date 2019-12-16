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
import com.fdmgroup.model.Employee;
import com.fdmgroup.model.Ticket;
import com.fdmgroup.model.TicketStatus;

public class TicketDao implements IEditable<Ticket>, IRemovable<Ticket>, IStorage<Ticket>{
	
	private DbConnection connection;

	public TicketDao() {
		super();
		connection = DbConnection.getInstance();
	}

	@Override
	public Ticket create(Ticket t) {
		EntityManager em = connection.getEntityManager();
		em.getTransaction().begin();
		em.persist(t);
		em.getTransaction().commit();
		em.close();
		
		return t;
	}

	@Override
	public Ticket findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Ticket> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(Ticket t) {
		EntityManager em = connection.getEntityManager();
		Ticket foundEmployee = em.find(Ticket.class, t.getTicket_id());
		em.getTransaction().begin();
		foundEmployee.setStatus(TicketStatus.RESOLVED);
		em.getTransaction().commit();
		em.close();
		
	}

	@Override
	public Ticket update(Ticket t) {
		// TODO Auto-generated method stub
		return null;
	}
	

}

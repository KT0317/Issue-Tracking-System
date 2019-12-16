package com.fdmgroup.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fdmgroup.model.Department;
import com.fdmgroup.model.Ticket;
import com.fdmgroup.model.TicketStatus;
import com.fdmgroup.model.User;

public class UserDao{
	
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String USERNAME = "trainee1";
	private static final String PASSWORD = "!QAZSE4";

	public User create(User t) {
		// TODO Auto-generated method stub
		return null;
	}

	public User findById(int id) {
		String query = "SELECT * FROM ITS_USER WHERE user_id = ?";
		try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement ps = con.prepareStatement(query);) {

			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			User user;
			
			while (rs.next()) {
				int ticket_id = rs.getInt("ticket_id");
				int customer_id= rs.getInt("customer_id");
				int priority = rs.getInt("issue_priority");
				String description = rs.getString("issue_description");
				
				Department dept = null;
				if (rs.getString("dept").equals("RETURNS_AND_REFUNDS") )
						dept = Department.RETURNS_AND_REFUNDS;
				else if (rs.getString("dept").equals("WRONG_PRODUCT_AND_DEFECTS") )
					dept = Department.WRONG_PRODUCT_AND_DEFECTS;
				else if (rs.getString("dept").equals("TECHNICAL_DIFFICULTIES") )
					dept = Department.TECHNICAL_DIFFICULTIES;
				
				TicketStatus status = null;
				if (rs.getString("status").equals("UNASSIGNED"))
					status = TicketStatus.UNASSIGNED;
				else if (rs.getString("status").equals("ASSIGNED"))
					status = TicketStatus.ASSIGNED;
				else if (rs.getString("status").equals("IN_PROGRESS"))
					status = TicketStatus.IN_PROGRESS;
				else if (rs.getString("status").equals("RESOLVED"))
					status = TicketStatus.RESOLVED;
				
				String feedback = rs.getString("feedback");
				int rating = rs.getInt("rating");

				
				temp = new Ticket(ticket_id, customer_id, priority, description, dept, status, feedback, rating);
				tickets.add(temp);
			}
			
			return tickets;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public User update(User t) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean remove(User t) {
		// TODO Auto-generated method stub
		return false;
	}

	public User findByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<User> findByFirstname(String firstname) {
		// TODO Auto-generated method stub
		return null;
	}

}

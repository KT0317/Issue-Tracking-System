package com.fdmgroup.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fdmgroup.util.IdGenerator;

@Entity
@Table(name = "ITS_USER")
public class User implements IStorable {

	@Id
	private int id;
	private String username;
	private String password;
	private String firstname;
	private String lastname;
	private String email;
	private boolean active;
	private UserType type;
	
	public User() {
		super();
	}

	public User(String username, String password, String firstname, String lastname, String email) {
		this(IdGenerator.generate(), username, password, firstname, lastname, email, true, UserType.CUSTOMER);
	}
	
	public User(String username, String password, String firstname, String lastname, String email, UserType usertype) {
		this(IdGenerator.generate(), username, password, firstname, lastname, email, true, usertype);
	}
	
	public User(int id, String username, String password, String firstname, String lastname, String email, boolean active, UserType type) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.active = active;
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public UserType getType() {
		return type;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", firstname=" + firstname
				+ ", lastname=" + lastname + ", email=" + email + ", active=" + active + ", type=" + type + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id != other.id)
			return false;
		return true;
	}
}

package com.fdmgroup.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "ITS_EMPLOYEE")
@DiscriminatorColumn(name = "employee_type", discriminatorType = DiscriminatorType.STRING, length = 20)
@DiscriminatorValue(value = "Employee")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@NamedQueries({
	@NamedQuery(name = "employee.findAll", query = "SELECT e FROM Employee e"),
	@NamedQuery(name = "employee.findAllActive", query = "SELECT e FROM Employee e WHERE e.active = true"),
	@NamedQuery(name = "employee.findByUsername", query = "SELECT e FROM Employee e where e.username = :ename"),
	@NamedQuery(name = "employee.findById", query = "SELECT e FROM Employee e where e.id = :id"),
	@NamedQuery(name = "employee.findByType", query = "SELECT e FROM Employee e where TYPE(e) = :type")
})
public class Employee implements IStorable {

	@Id
	@Column(name = "employee_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(length = 30, nullable = false, unique = true)
	private String username;
	
	@Column(name = "pw", length = 30, nullable = false, unique = true)
	private String password;
	private String firstname;
	private String lastname;
	private String email;
	
	private Department dept;
	
	@Column(columnDefinition = "Number(1)")
	private boolean active;
	
	public Employee() {
		super();
	}

	public Employee(String username, String password, String firstname, String lastname, String email, Department dept) {
		this(username, password, firstname, lastname, email, Department.EMPLOYEE, true);
	}
	
	public Employee(String username, String password, String firstname, String lastname, String email, Department dept, boolean active) {
		super();
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.dept = dept;
		this.active = active;
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


	@Override
	public String toString() {
		return "Employee [id=" + id + ", username=" + username + ", password=" + password + ", firstname=" + firstname
				+ ", lastname=" + lastname + ", email=" + email + ", dept=" + dept + ", active=" + active + "]";
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
		Employee other = (Employee) obj;
		if (id != other.id)
			return false;
		return true;
	}
}

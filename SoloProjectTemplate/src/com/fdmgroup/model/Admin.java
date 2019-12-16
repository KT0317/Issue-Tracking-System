package com.fdmgroup.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "Admin")
public class Admin extends Employee{
	
	public Admin() {
		super();
	}

	public Admin(String username, String password, String firstname, String lastname, String email) {
		super(username, password, firstname, lastname, email, Department.ADMIN);
	}

}

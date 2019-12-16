package com.fdmgroup.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "Support")
public class Support extends Employee{

	public Support() {
		super();
	}

	public Support(String username, String password, String firstname, String lastname, String email, Department dept) {
		super(username, password, firstname, lastname, email, dept);
	}

}

package com.fdmgroup.model;

public class Admin extends User{
	
	public Admin() {
		super();
	}

	public Admin(String username, String password, String firstname, String lastname, String email, UserType usertype) {
		super(username, password, firstname, lastname, email, usertype);
	}


	public void createCustomerSupport(Department dept){
		
	}
	
	public void assignUserToDept(Department dept, User user){
		
	}
	
	public void assignTicketToDepartment(Department dept, Ticket ticket){
		
	}
	
	public void setTicketPriority(Ticket ticket, int value){
		
	}
	
	public void reviewCustomerFeedback(){
		
	}
}

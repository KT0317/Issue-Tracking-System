package com.fdmgroup.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fdmgroup.util.IdGenerator;

@Entity
@Table(name = "ITS_TICKET")
public class Ticket implements IStorable{

	@Id
	private int ticket_id;
	private int customer_id;
	private int priority;
	private String issueDescription;
	private Department dept;
	private TicketStatus status;
	private String feedback;
	private int rating;
	
	public Ticket(){
		super();
	}
	
	public Ticket(int customer_id, String issueDescription, Department dept) {
		this(IdGenerator.generate(), customer_id, 1, issueDescription, dept, TicketStatus.UNASSIGNED, null, 0);
	}

	public Ticket(int ticket_id, int customer_id, int priority, String issueDescription, Department dept, TicketStatus status,
			String feedback, int rating) {
		super();
		this.ticket_id = ticket_id;
		this.customer_id = customer_id;
		this.priority = priority;
		this.issueDescription = issueDescription;
		this.dept = dept;
		this.status = status;
		this.feedback = feedback;
		this.rating = rating;
	}


	public int getTicket_id() {
		return ticket_id;
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public String getIssueDescription() {
		return issueDescription;
	}

	public void setIssueDescription(String issueDescription) {
		this.issueDescription = issueDescription;
	}

	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}
	
	public TicketStatus getStatus() {
		return status;
	}

	public void setStatus(TicketStatus status) {
		this.status = status;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Ticket [ticket_id=" + ticket_id + ", customer_id=" + customer_id + ", priority=" + priority
				+ ", issueDescription=" + issueDescription + ", status=" + status + ", feedback=" + feedback
				+ ", rating=" + rating + "]";
	}
	
	
}

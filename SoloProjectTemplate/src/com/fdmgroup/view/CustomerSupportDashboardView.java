package com.fdmgroup.view;

import java.util.Scanner;

import com.fdmgroup.controller.AuthenticationController;
import com.fdmgroup.controller.CustomerSupportController;
import com.fdmgroup.model.UserSession;

public class CustomerSupportDashboardView extends DashboardView{

	private AuthenticationController authenticationController;
	private CustomerSupportController customerSupportController;
	
	public CustomerSupportController getCustomerSupportController() {
		return customerSupportController;
	}

	public void setCustomerSupportController(CustomerSupportController customerSupportController) {
		this.customerSupportController = customerSupportController;
	}

	public CustomerSupportDashboardView() {
		super();
	}
	
	public CustomerSupportDashboardView(Scanner scanner) {
		super(scanner);
	}

	public CustomerSupportDashboardView(Scanner scanner, AuthenticationController authenticationController) {
		super(scanner, authenticationController);
	}
	
	@Override
	public void showDashboard() {
		System.out.println("Welcome " + UserSession.getLoggedInUser().getFirstname() + " " + UserSession.getLoggedInUser().getLastname() + "!");
		System.out.println("Please select one of the options below: ");
		System.out.println("1) Create new customer support user and assign to a department");
		System.out.println("2) Assign ticket to a department");
		System.out.println("3) Set ticket priority (max 5)");
		System.out.println("4) View customer feedback");
		System.out.println("5) Logout");
		String userInput = this.getScanner().nextLine();
		
		switch (userInput) {
//		case "1":
//			this.adminController.logout();
//			break;
//		case "2":
//			this.getAuthenticationController().logout();
//			break;
//		case "3":
//			this.getAuthenticationController().logout();
//			break;
//		case "4":
//			this.getAuthenticationController().logout();
//			break;
		case "5":
			this.getAuthenticationController().logout();
			break;
		default:
			System.out.println("The input was invalid.");
			showDashboard();
		}
	}
	
	public AuthenticationController getAuthenticationController() {
		return authenticationController;
	}

	public void setAuthenticationController(AuthenticationController authenticationController) {
		this.authenticationController = authenticationController;
	}

	
}

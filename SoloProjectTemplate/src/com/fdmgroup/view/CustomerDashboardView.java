package com.fdmgroup.view;

import java.util.Scanner;

import com.fdmgroup.controller.AuthenticationController;
import com.fdmgroup.model.UserSession;

public class CustomerDashboardView extends DashboardView {

	private AuthenticationController authenticationController;
//	private CustomerController;
	
	public CustomerDashboardView() {
		super();
	}
	
	public CustomerDashboardView(Scanner scanner) {
		super(scanner);
	}

	public CustomerDashboardView(Scanner scanner, AuthenticationController authenticationController) {
		super(scanner, authenticationController);
	}

	@Override
	public void showDashboard() {
		System.out.println("Welcome " + UserSession.getLoggedInUser().getFirstname() + " " + UserSession.getLoggedInUser().getLastname() + "!");
		System.out.println("Please select one of the options below: ");
		System.out.println("1) Create support ticket");
		System.out.println("2) Rate your customer service experience");
		System.out.println("3) Give feedback regarding your ticket");
		System.out.println("4) Get your list of support tickets");
		System.out.println("5) Logout");
		String userInput = this.getScanner().nextLine();
		
		switch (userInput) {
		case "1":
			this.getAuthenticationController().logout();
			break;
		case "2":
			this.getAuthenticationController().logout();
			break;
		case "3":
			this.getAuthenticationController().logout();
			break;
		case "4":
			this.getAuthenticationController().logout();
			break;
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

package com.fdmgroup.model;

public class UserSession {

	private static Employee loggedInUser;

	public static Employee getLoggedInUser() {
		return loggedInUser;
	}

	public static void setLoggedInUser(Employee loggedInUser) {
		UserSession.loggedInUser = loggedInUser;
	}
}

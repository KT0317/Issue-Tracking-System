package com.fdmgroup.app;

import java.util.Scanner;

import com.fdmgroup.controller.AdminController;
import com.fdmgroup.controller.AuthenticationController;
import com.fdmgroup.controller.HomeController;
import com.fdmgroup.dao.IUserDao;
import com.fdmgroup.dao.TicketDao;
import com.fdmgroup.dao.UserCollectionDao;
import com.fdmgroup.view.AdminDashboardView;
import com.fdmgroup.view.CustomerDashboardView;
import com.fdmgroup.view.CustomerSupportDashboardView;
import com.fdmgroup.view.DashboardView;
import com.fdmgroup.view.HomeView;

public class MainApp {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		IUserDao userDao = new UserCollectionDao();
		TicketDao ticketDao = new TicketDao();
		
		//Views
		HomeView homeView = new HomeView(scanner);
		DashboardView dashboardView = new DashboardView(scanner);
		AdminDashboardView adminDashboardView = new AdminDashboardView(scanner);
		CustomerDashboardView customerDashboardView = new CustomerDashboardView(scanner);
		CustomerSupportDashboardView customerSupportDashboardView = new CustomerSupportDashboardView(scanner);
		
		//Controllers
		HomeController homeController = new HomeController();
		AuthenticationController authenticationController = new AuthenticationController();
		AdminController adminController = new AdminController();
		
		homeController.setHomeView(homeView);
//		ac.setDashboardView(dv);
		authenticationController.setHomeView(homeView);
		authenticationController.setUserDao(userDao);
		
		authenticationController.setAdminDashboardView(adminDashboardView);
		authenticationController.setCustomerSupportDashboardView(customerSupportDashboardView);
		authenticationController.setCustomerDashboardView(customerDashboardView);
		
		homeView.setAuthenticationController(authenticationController);
		homeView.setHomeController(homeController);
		
		adminDashboardView.setAuthenticationController(authenticationController);
		adminDashboardView.setAdminController(adminController);
		adminController.setHomeView(homeView);
		
		customerSupportDashboardView.setAuthenticationController(authenticationController);
		customerDashboardView.setAuthenticationController(authenticationController);
		
		dashboardView.setAuthenticationController(authenticationController);
		
		
		homeController.showHome();
		
		scanner.close();
	}
}










package com.fdmgroup.controller;

import com.fdmgroup.dao.IUserDao;
import com.fdmgroup.model.User;
import com.fdmgroup.model.UserSession;
import com.fdmgroup.model.UserType;
import com.fdmgroup.view.AdminDashboardView;
import com.fdmgroup.view.CustomerDashboardView;
import com.fdmgroup.view.CustomerSupportDashboardView;
import com.fdmgroup.view.DashboardView;
import com.fdmgroup.view.HomeView;

public class AuthenticationController {

	private AdminDashboardView admindashboardView;
	private CustomerSupportDashboardView customersupportdashboardview;
	private CustomerDashboardView customerdashboardview; 
	private HomeView homeView;
	private IUserDao userDao;
	
	public AuthenticationController() {
		super();
	}

	public AuthenticationController(HomeView homeView, IUserDao userDao) {
		super();
		this.homeView = homeView;
		this.userDao = userDao;
	}

	public void login(String username, String password) {
		User user = userDao.findByUsername(username);
		if (user != null && user.getPassword().equals(password)) {
			UserSession.setLoggedInUser(user);
			
			System.out.println(user.getType());
			if (user.getType() == UserType.ADMIN){
				admindashboardView.showDashboard();
			}
			else if (user.getType() == UserType.CUSTOMER_SUPPORT){
				customersupportdashboardview.showDashboard();
			}
			else if (user.getType() == UserType.CUSTOMER){
				customerdashboardview.showDashboard();
			}
//			dashboardView.showDashboard();
			return;
		}
		
		homeView.showLoginOptions(true);
	}

	public void logout() {
		UserSession.setLoggedInUser(null);
		homeView.showInitialOptions(true);
	}

	public HomeView getHomeView() {
		return homeView;
	}

	public void setHomeView(HomeView homeView) {
		this.homeView = homeView;
	}

	public IUserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	
	public AdminDashboardView getAdmindashboardView() {
		return admindashboardView;
	}

	public void setAdminDashboardView(AdminDashboardView admindashboardView) {
		this.admindashboardView = admindashboardView;
	}

	public CustomerSupportDashboardView getCustomersupportdashboardview() {
		return customersupportdashboardview;
	}

	public void setCustomerSupportDashboardView(CustomerSupportDashboardView customersupportdashboardview) {
		this.customersupportdashboardview = customersupportdashboardview;
	}

	public CustomerDashboardView getCustomerdashboardview() {
		return customerdashboardview;
	}

	public void setCustomerDashboardView(CustomerDashboardView customerdashboardview) {
		this.customerdashboardview = customerdashboardview;
	}

}




















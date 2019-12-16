package com.fdmgroup.controller;

import com.fdmgroup.dao.IUserDao;
import com.fdmgroup.model.Employee;
import com.fdmgroup.model.UserSession;
import com.fdmgroup.view.AdminDashboardView;
import com.fdmgroup.view.CustomerDashboardView;
import com.fdmgroup.view.CustomerSupportDashboardView;
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
		Employee user = userDao.findByUsername(username);
		if (user != null && user.getPassword().equals(password)) {
			UserSession.setLoggedInUser(user);
			
//			System.out.println(user.getType());
//			if (user.getType() == EmployeeType.ADMIN){
//				admindashboardView.showDashboard();
//			}
//			else if (user.getType() == EmployeeType.HR || user.getType() == EmployeeType.IT){
//				customersupportdashboardview.showDashboard();
//			}
//			else if (user.getType() == EmployeeType.EMPLOYEE){
//				customerdashboardview.showDashboard();
//			}
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




















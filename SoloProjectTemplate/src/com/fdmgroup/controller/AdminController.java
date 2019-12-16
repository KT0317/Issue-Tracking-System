package com.fdmgroup.controller;

import com.fdmgroup.dao.IUserDao;
import com.fdmgroup.dao.TicketDao;
import com.fdmgroup.view.AdminDashboardView;
import com.fdmgroup.view.HomeView;

public class AdminController {

	private AdminDashboardView adminDashboardView; 
	private HomeView homeView;
	private IUserDao userDao;
	private TicketDao ticketDao;
	
	public AdminController() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AdminController(AdminDashboardView adminDashboardView, IUserDao userDao, TicketDao ticketDao) {
		super();
		this.adminDashboardView = adminDashboardView;
		this.userDao = userDao;
		this.ticketDao = ticketDao;
	}

	public AdminDashboardView getAdminDashboardView() {
		return adminDashboardView;
	}

	public void setAdminDashboardView(AdminDashboardView adminDashboardView) {
		this.adminDashboardView = adminDashboardView;
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

	public TicketDao getTicketDao() {
		return ticketDao;
	}

	public void setTicketDao(TicketDao ticketDao) {
		this.ticketDao = ticketDao;
	}
	
	
}

package com.fdmgroup.controller;

import com.fdmgroup.dao.IUserDao;
import com.fdmgroup.view.HomeView;

public class HomeController {

	private HomeView homeView;
	private IUserDao Dao;
	
	public HomeController() {
		super();
	}

	public HomeController(HomeView homeView) {
		super();
		this.homeView = homeView;
	}
	
	public void showHome() {
		homeView.showInitialOptions(false);
	}

	public HomeView getHomeView() {
		return homeView;
	}

	public void setHomeView(HomeView homeView) {
		this.homeView = homeView;
	}
}

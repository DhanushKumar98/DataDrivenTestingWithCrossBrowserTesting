package com.pageObjectManager;

import com.pageObjectModules.CheckOutPageObjectModules;
import com.pageObjectModules.HomePageObjectModules;
import com.pageObjectModules.LoginPageObjectModules;
import com.utility.FileReaderManager;

public class PageObjectManager {
	
	private LoginPageObjectModules loginPage;
	private HomePageObjectModules homePage;
	private CheckOutPageObjectModules checkOutPage;
	private FileReaderManager fileReaderManager;
	
	public LoginPageObjectModules getLoginPage() {
		if(loginPage == null) {
			loginPage = new LoginPageObjectModules();
		}
		return loginPage;
	}

	public HomePageObjectModules getHomePage() {
		if(homePage == null) {
			homePage = new HomePageObjectModules();
		}
		return homePage;
	}

	public CheckOutPageObjectModules getCheckOutPage() {
		if(checkOutPage == null) {
			checkOutPage = new CheckOutPageObjectModules();
		}
		return checkOutPage;
	}

	public FileReaderManager getFileReaderManager() {
		if(fileReaderManager == null) {
			fileReaderManager = new FileReaderManager();
		}
		return fileReaderManager;
	}

	
	
	
	
	
	
	
	
	
	

}

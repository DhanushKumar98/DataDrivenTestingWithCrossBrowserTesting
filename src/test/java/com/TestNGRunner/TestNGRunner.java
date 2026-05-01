package com.TestNGRunner;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pageObjectManager.PageObjectManager;

public class TestNGRunner extends BaseClass{
	
	PageObjectManager pageObjectManager = new PageObjectManager();
	
	
	
	@Parameters({"browser","url"})
	@BeforeTest
	public void setUp(String browser,String url) {
		browserLaunch(browser);
		launchUrl(url);
	}
	
	@Parameters({"username","password"})
	@Test(priority = 1)
	public void loginPageTest(String username, String password) { 
		
		pageObjectManager.getLoginPage().typeUsername(username);
		pageObjectManager.getLoginPage().typePassword(password);
		pageObjectManager.getLoginPage().clickOnLoginBtn();	
		setImplictWait(5000);
	}
	
	
	@Test(priority = 2)
	public void homePageTest() {
		pageObjectManager.getHomePage().clickProduct1();
		pageObjectManager.getHomePage().clickProduct2();
		pageObjectManager.getHomePage().clickProduct3();
		pageObjectManager.getHomePage().clickProduct4();
		pageObjectManager.getHomePage().clickProduct5();
		pageObjectManager.getHomePage().clickProduct6();
		
		pageObjectManager.getHomePage().clickOnCheckOut();
	}
	
	
	@Parameters({"firstName","last","zip"})
	@Test(priority = 3)
	public void checkOutPageTest(String firstName,String last,String zip) {
		pageObjectManager.getCheckOutPage().typeFirstName(firstName);
		pageObjectManager.getCheckOutPage().typeLastName(last);
		pageObjectManager.getCheckOutPage().typeZipCode(zip);
		pageObjectManager.getCheckOutPage().clickOnContinueBtn();
		pageObjectManager.getCheckOutPage().getTextShippingInformation();
		pageObjectManager.getCheckOutPage().getTextPriceTotal();
		pageObjectManager.getCheckOutPage().getTextTotal();
		pageObjectManager.getCheckOutPage().clickOnFinishBtn();
	}
	
	@Test(priority = 4)
	public void logoutPageTest() {
		pageObjectManager.getHomePage().clickOnMenuBtn();
	}
	
	@AfterTest
	public void tearDown() {
		closeBrowser();
	}
	
	
	
	

}

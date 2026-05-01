package com.pageObjectModules;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;
import com.interfaceElement.LoginPageInterfaceElement;

public class LoginPageObjectModules extends BaseClass implements LoginPageInterfaceElement{
	
	public LoginPageObjectModules() {
		PageFactory.initElements(getDriver(),this);
	}
	
	@FindBy(id = username_id)	
	private WebElement username;
	
	@FindBy(xpath = password_xpath)
	private WebElement password;
	
	@FindBy(css = loginBtn_css)
	private WebElement loginBtn;
	
	
	public void typeUsername(String user) {
		type(username, user);
	}
	
	public void typePassword(String pass) { 
		type(password,pass);
	}
	
	public void clickOnLoginBtn() {
		seleniumClick(loginBtn);
	}
	
	
	
	

}

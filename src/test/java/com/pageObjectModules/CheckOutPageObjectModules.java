package com.pageObjectModules;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;
import com.interfaceElement.CheckOutPageInterfaceElements;

public class CheckOutPageObjectModules extends BaseClass implements CheckOutPageInterfaceElements {
	
	public CheckOutPageObjectModules() {
		PageFactory.initElements(getDriver(),this);
	}
	
	@FindBy(id = firstName_id)
	private WebElement firstName;
	
	@FindBy(id = lastName_id)
	private WebElement lastName;
	
	@FindBy(id = zipCode_id)
	private WebElement zipCode;
	
	@FindBy(id = continue_id)
	private WebElement continues;
	
	@FindBy(xpath = shippingInformation_xpath)
	private WebElement shippingInformation;
	
	@FindBy(xpath = priceTotal_xpath)
	private WebElement priceTotal;
	
	@FindBy(xpath = total_xpath)
	private WebElement total;
	
	@FindBy(css = finish_css)
	private WebElement finish;
	
	@FindBy(xpath = confirmationMessage_xpath)
	private WebElement confirmationMessage;
	
	@FindBy(xpath = dispatchMessage_xpath)
	private WebElement dispatchMessage;
	
	@FindBy(xpath = backToHome_xpath)
	private WebElement backToHome;
	
	
	public void typeFirstName(String name) {
		type(firstName, name);
	}
	
	public void typeLastName(String last) {
		type(lastName,last);
	}
	
	public void typeZipCode(String zip) {
		type(zipCode, zip);
	}
	
	public void clickOnContinueBtn() {
		seleniumClick(continues);
	}
	

	public void clickOnFinishBtn() {
		seleniumClick(finish);
		seleniumClick(backToHome);
	}
	
	public void getTextShippingInformation() {
		 String actual =getText(shippingInformation);
		 assertEqual(actual,"Free Pony Express Delivery!");
	}
	
	public void getTextPriceTotal() {
		String actual = getText(priceTotal);
		assertEqual(actual,"Item total: $129.94");
	}
	
	public void getTextTotal() {
		String actual = getText(total);
		assertEqual(actual,"Total: $140.34");
	}
	
	

}

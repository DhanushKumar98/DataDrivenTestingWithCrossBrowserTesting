package com.pageObjectModules;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;
import com.interfaceElement.HomePageInterfaceElements;

public class HomePageObjectModules extends BaseClass implements HomePageInterfaceElements{
	
	public HomePageObjectModules() {
		PageFactory.initElements(getDriver(),this);
	}
	
	@FindBy(xpath = BackPacks_xpath)
	private WebElement BackPacks;
	
	@FindBy(xpath = BikeLight_xpath)
	private WebElement BikeLight;
	
	@FindBy(xpath = BoltShirt_xpath)
	private WebElement BoltShirt;
	
	@FindBy(xpath = FleeceJacket_xpath)
	private WebElement FleeceJacket;
	
	@FindBy(xpath = onesie_xpath)
	private WebElement onesie;
	
	@FindBy(xpath = ShitRed_xpath)
	private WebElement ShitRed;
	
	@FindBy(xpath = addToCart_xpath)
	private WebElement addToCart;
	
	@FindBy(xpath = remove_xpath)
	private WebElement remove;
	
	@FindBy(css = backToBtn_css)
	private WebElement backToBtn;
	
	@FindBy(xpath = checkOutBtn_xpath)
	private WebElement checkOutBtn;
	
	@FindBy(css = ClickOnCheckOutBtn_css)
	private WebElement ClickOnCheckOutBtn;
	
	@FindBy(xpath = menuBtn_xpath)
	private WebElement menuBtn;
	
	@FindBy(xpath = logOut_xpath)
	private WebElement logOut;
	
	
	
	public void clickProduct1() {
		seleniumClick(BackPacks);
		setImplictWait(3000);
		seleniumClick(addToCart);
		setImplictWait(3000);
		seleniumClick(backToBtn);
	}
	
	public void clickProduct2() {
		seleniumClick(BikeLight);
		setImplictWait(3000);
		seleniumClick(addToCart);
		setImplictWait(3000);
		seleniumClick(backToBtn);
	}
	
	
	public void clickProduct3() {
		seleniumClick(BoltShirt);
		setImplictWait(3000);
		seleniumClick(addToCart);
		setImplictWait(3000);
		seleniumClick(backToBtn);
		
	}
	
	public void clickProduct4() {
		seleniumClick(FleeceJacket);
		setImplictWait(3000);
		seleniumClick(addToCart);
		setImplictWait(3000);
		seleniumClick(backToBtn);
		
	}
	
	public void clickProduct5() {
		seleniumClick(onesie);
		seleniumClick(addToCart);
		seleniumClick(backToBtn);
		
	}
	
	public void clickProduct6() {
		seleniumClick(ShitRed);
		seleniumClick(addToCart);
		seleniumClick(backToBtn);
		setImplictWait(10000);
		
	}
	
	public void clickOnCheckOut() {
		seleniumClick(checkOutBtn);
		seleniumClick(ClickOnCheckOutBtn);
		
	}
	
	public void clickOnMenuBtn() {
		setImplictWait(5000);
		seleniumClick(menuBtn);
		setImplictWait(5000);
		seleniumClick(logOut);
		
	}
	
	
	
	
	
	
	

}

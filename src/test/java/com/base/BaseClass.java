package com.base;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class BaseClass {
		
	private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
	static SoftAssert soft = new SoftAssert();
	protected JavascriptExecutor js;
	
	
	
	
	
	// set Driver 
	public static void setDriver(WebDriver driverInstance) { 
		tlDriver.set(driverInstance);
	}
	//Get Driver 
	public static WebDriver getDriver() { 
		return tlDriver.get();
	}
	
	public void initJS() {
        js = (JavascriptExecutor) getDriver();
    }
	
	// Quit Driver 
	public static void quitDriver() { 
		try {
			if(tlDriver.get() != null) {
				tlDriver.get().quit();
				tlDriver.remove();
				System.out.println("Driver closed successfully");
			}
		}catch(Exception e) { 
			System.out.println("Error while quitting driver: "+e.getMessage());
		}
	}
	
	public static void browserLaunch(String browserName) { 
		
			WebDriver driver = null;
		try { 
			switch(browserName.toLowerCase()) { 
			
			case "chrome":
				driver = new ChromeDriver();
				break;
			case "firefox":
				driver = new FirefoxDriver();
				break;
			case "edge":
			driver = new EdgeDriver();
			break;
			
			default:
				throw new IllegalArgumentException("Browser not Supported: "+browserName);
			}
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			BaseClass.setDriver(driver);
			System.out.println("Driver initialized for : "+browserName);
		}catch(Exception e) { 
			System.out.println("Error Initialzing driver: "+e.getMessage());
			e.printStackTrace();
			
			throw new RuntimeException("Driver initialization failed for browser: "+ browserName, e);
		}
	}
	
	
	public static void launchUrl(String url) {
		try {
			BaseClass.getDriver().get(url);
		}catch(Exception  e) {
			throw new RuntimeException("Failed to Launch URL :"+url,e);
		}
	}
	
	public static String getTitle() {
		try {
			return BaseClass.getDriver().getTitle();
		}catch(Exception e) {
			throw new RuntimeException("Unable to get page title",e);
		}
	}
	
	public static String getCurrentUrl() {
		try {
			return BaseClass.getDriver().getCurrentUrl();
		}catch(Exception e) { 
			throw new RuntimeException("Unable to get current URL :",e);
		}
	}
	
	public static void closeBrowser() {
		BaseClass.quitDriver();
	}
	
	
	public static void setImplictWait(int seconds) { 
		BaseClass.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
	}
	
	
	public static void selectByVisibilityText(By locator,String text) { 
		try {
			Select dropdown = new Select(BaseClass.getDriver().findElement(locator));
			dropdown.selectByVisibleText(text);
		}catch(Exception e) {
			throw new RuntimeException("Dropdown selection failed: "+ text,e);
		}
	}
	
	public static void selectByIndex(By locator,int index) {
		try {
			Select dropdown = new Select(BaseClass.getDriver().findElement(locator));
			dropdown.selectByIndex(index);
		}catch(Exception e) {
			throw new RuntimeException("Dropdown selection failed: "+index,e);
		}
	}
	
	public static void selectByValue(By locator,String value) {
		try {
			Select dropdown = new Select(BaseClass.getDriver().findElement(locator));
			dropdown.selectByValue(value);
		}catch(Exception e) {
			throw new RuntimeException("Dropdown selection failed: "+value,e);
		}
	}
	
	public static WebElement waitForElementVisible(By locator,int timeout) {
		try {
			WebDriverWait wait = new WebDriverWait(BaseClass.getDriver(),Duration.ofSeconds(timeout));
			return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		}catch(Exception e) {
			throw new RuntimeException("Element not Visible: "+locator,e);
		}
	}
	
	public static void mouseHover(By locator) {
		try {
			Actions actions = new Actions(BaseClass.getDriver());
			actions.moveToElement(BaseClass.getDriver().findElement(locator)).perform();
		}catch(Exception e) {
			throw new RuntimeException("Mouse hover Failed",e);
		}
	}
	
	public static void clickByActions(By locator) {
		try {
			Actions actions = new Actions(BaseClass.getDriver());
			actions.moveToElement(BaseClass.getDriver().findElement(locator)).click().perform();
		}catch(Exception e) {
			throw new RuntimeException("Click is Failed ",e);
		}
	}
	
	public static void dragAndDrop(WebDriver driver,By sourceLocator,By targetLocator) { 
			WebDriverWait wait = new WebDriverWait(BaseClass.getDriver(),Duration.ofSeconds(10));
			
			WebElement source = wait.until(ExpectedConditions.visibilityOfElementLocated(sourceLocator));
			WebElement target = wait.until(ExpectedConditions.visibilityOfElementLocated(targetLocator));
			
			
			Actions actions = new Actions(BaseClass.getDriver());
			actions.clickAndHold(source)
				.moveToElement(target)
				.release()
				.perform();
	}
	
	
	public static void pressEnter() {
		try {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
		}catch(Exception e) {
			throw new RuntimeException("Robot Enter key Failed",e);
		}
	}
	
	public static void fileUpload(String location) {
		
		StringSelection file = new StringSelection(location);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(file, null);
		try {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		}catch(Exception e) {
			e.printStackTrace();
		}	
	}
	
	
	public static WebElement getElement(By locator) { 
		return BaseClass.getDriver().findElement(locator);
	}
	
	public static void click(By locator) {
		waitForElementVisible(locator, 10).click();
	}
	
	public static void sendKeys(By locator, String value) {
		WebElement element = waitForElementVisible(locator,10);
		element.clear();
		element.sendKeys(value);
	}
	
	public static void explicitWaitVisibilityOfElement(WebElement element,int seconds) {
		try {
			WebDriverWait wait = new WebDriverWait(getDriver(),Duration.ofSeconds(seconds));
			wait.until(ExpectedConditions.visibilityOf(element));
		}catch(Exception e) {
			throw new RuntimeException("Error Occurs During Explicit Wait"+ element, e);
		}
	}
	
	public static void explicitWaitClickableOfElement(WebElement element,int seconds) {
		try {
			WebDriverWait wait = new WebDriverWait(getDriver(),Duration.ofSeconds(seconds));
			wait.until(ExpectedConditions.elementToBeClickable(element));
		}catch(Exception e) {
			throw new RuntimeException("Error Occurs During Explicit wait"+ element,e);
		}
	}
	
	public static void type(WebElement element, String text) {
		try {
			explicitWaitVisibilityOfElement(element,10);
			element.clear();
			element.sendKeys(text);
		}catch(Exception e) {
			throw new RuntimeException("Error Occurs During Explicit wait"+ element,e);
		}
	}
	
	public static void seleniumClick(WebElement element) {
		try {
			setImplictWait(5000);
			explicitWaitClickableOfElement(element, 10);
			element.click();
		}catch(Exception e) {
			throw new RuntimeException("Error Occurs During Clicking"+ element,e);
		}
	}
	
	public static String getText(WebElement element) {
		try {
			explicitWaitVisibilityOfElement(element, 10);
			String value = element.getText();
			// FallBack if Text is empty
			if(value == null || value.trim().isEmpty()) { 
				value = element.getAttribute("textContent");
			}
			
			return value != null ? value.trim() : "";
		}catch(Exception e) {
			throw new RuntimeException("Failed to get text from element"+ element,e);
		}
	}
	
	
	public static void assertEquals(String actual,String expected) {
		try {
			Assert.assertEquals(actual, expected);
		}catch(Exception e) {
			Assert.fail("ERROR : OCCURS DURING ASSERT EQUALS");
		}
	}
	
	public static void assertFalse(boolean condition) { 
		try {
			Assert.assertFalse(condition);
		}catch(Exception e) {
			Assert.fail("ERROR : OCCURS DURING ASSERT FALSE");
		}	
	}
	
	
	public static void assertTextEquals(WebElement element,String expected) { 
		try {
			explicitWaitVisibilityOfElement(element, 10);
			String actual = element.getText();
			Assert.assertEquals(actual,expected);
		}catch(Exception e) {
			Assert.fail("Text Assert Failed. Expected: "+expected);
		}
	}
	
	public static void assertElementDisplayed(WebElement element,String expected) {
		try {
			explicitWaitVisibilityOfElement(element, 10);
			String actual = element.getText();
			Assert.assertEquals(actual,expected);
		}catch(Exception e) {
			Assert.fail("Test Assertion Failed. Expected : "+ expected);
		}
	}
	
	public static void assertElementDisplayed(WebElement element) { 
		try {
			explicitWaitVisibilityOfElement(element, 10);
			Assert.assertTrue(element.isDisplayed());
		}catch(Exception e) {
			Assert.fail("Element is Not Displayed");
		}
	}
	
	// Soft Assert
	public static void assertEqual(String actual, String expected) {
		soft.assertEquals(actual,expected);
	}
	
	
	
	public static void assertAll() {
		soft.assertAll();
	}
	
	
	public void jsClick(WebElement element) {
	    js.executeScript("arguments[0].click();", element);
	}
	
	public void jsSendKeys(WebElement element, String value) {
	    js.executeScript("arguments[0].value='" + value + "';", element);
	}
	
	public void scrollToElement(WebElement element) {
	    js.executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	public void scrollToBottom() {
	    js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
	}
	
	public void scrollToTop() {
	    js.executeScript("window.scrollTo(0, 0);");
	}
	
	public void highlightElement(WebElement element) {
	    js.executeScript("arguments[0].style.border='3px solid red'", element);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

package com.interfaceElement;

public interface HomePageInterfaceElements {
	
	
//	String clickOnProfile_xpath = "//div[contains(@class,'profile_dropdown')]";
//	String clickOnViewProfile_xpath = "//a[normalize-space()='View Profile']";
	
	// Ui Actions Add to Cart button
	String sauceLabsBackpack_css = "#add-to-cart-sauce-labs-backpack";
	String sauceLabsBikeLight_css = "#add-to-cart-sauce-labs-bike-light";
	String sauceLabsBoltTShirt_css = "#add-to-cart-sauce-labs-bolt-t-shirt";
	String sauceLabsFleeceKacket_css = "#add-to-cart-sauce-labs-onesie";
	String sauceLabsOnesie_css = "#add-to-cart-sauce-labs-fleece-jacket";
	String testALLTheThingsTShirtRed_id = "add-to-cart-test.allthethings()-t-shirt-(red)";
	

	// Assertions
	String sauceLabsBackPackPrice_xpath = "//div[@class='inventory_item' and .//div[text()='Sauce Labs Backpack']]//div[@class='inventory_item_price']";       // $29.99      
	String saucaLabsBikeLightPrice_xpath = "//div[@class='inventory_item' and .//div[text()='Sauce Labs Bike Light']]//div[@class='inventory_item_price']";		// $9.99
	String saucaLabsBoltTShirtPrice_xpath = "//div[@class='inventory_item' and .//div[text()='Sauce Labs Bolt T-Shirt']]//div[@class='inventory_item_price']";	// $15.99
	
	//Name of the Products
	String BackPacks_xpath = "//div[normalize-space()='Sauce Labs Backpack']";
	String BikeLight_xpath = "//div[normalize-space()='Sauce Labs Bike Light']";
	String BoltShirt_xpath = "//div[normalize-space()='Sauce Labs Bolt T-Shirt']";
	String FleeceJacket_xpath = "//div[normalize-space()='Sauce Labs Fleece Jacket']";
	String onesie_xpath = "//div[normalize-space()='Sauce Labs Onesie']";
	String ShitRed_xpath = "//div[normalize-space()='Test.allTheThings() T-Shirt (Red)']";
	
	String addToCart_xpath = "//*[@id='add-to-cart']";
	String remove_xpath = "#remove";
	
	String backToBtn_css = "#back-to-products";
	
	String checkOutBtn_xpath = "//div[@id='shopping_cart_container']/a";
	String ClickOnCheckOutBtn_css = "#checkout";
	
	String menuBtn_xpath = "//*[@id='react-burger-menu-btn']";
	String logOut_xpath = "//a[normalize-space()='Logout']";
	
	//#logout_sidebar_link
	
	
}

package com.interfaceElement;

public interface CheckOutPageInterfaceElements {
	
	String firstName_id = "first-name";
	String lastName_id = "last-name";
	String zipCode_id = "postal-code";
	String continue_id = "continue";
	
	String shippingInformation_xpath = "//div[contains(text(),'Free Pony Express Delivery!')]";
	String priceTotal_xpath = "//div[@class='summary_subtotal_label']";
	String total_xpath = "//div[@class='summary_total_label']";
	
	
	
	String finish_css = "#finish";
	String confirmationMessage_xpath = "//h2[contains(text(),'Thank you for your order!')]";
	String dispatchMessage_xpath = "//div[contains(text(),'Your order has been ')]";
	
	String backToHome_xpath = "//*[@id='back-to-products']";

}

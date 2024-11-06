package com.qa.swaglabs.pages;

import org.openqa.selenium.WebDriver;

import com.qa.swaglabs.utils.ElementUtil;
/**
 * @author Veena Hegde
 */
public class CartPage {
	
	private WebDriver driver;
	private ElementUtil eleUtil;

	public CartPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

}

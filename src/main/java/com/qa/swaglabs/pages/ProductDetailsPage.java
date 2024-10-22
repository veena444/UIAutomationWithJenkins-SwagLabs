package com.qa.swaglabs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.swaglabs.constants.AppConstants;
import com.qa.swaglabs.utils.ElementUtil;

public class ProductDetailsPage {
	
	private WebDriver driver;
	private ElementUtil eleUtil;
	
    private By productHeader = By.xpath("//div[@id='inventory_item_container']//div[@data-test='inventory-item-name']");
	private By itemPrice = By.cssSelector("div.inventory_details_price");
	private By addToCartBtn = By.id("add-to-cart");
	private By backToProductsBtn = By.id("back-to-products");

	public ProductDetailsPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}
	
	public String getProductHeader() {
		String producthHeaderValue = eleUtil.waitForElementVisible(productHeader,AppConstants.DEFAULT_SHORT_TIME_OUT).getText();
		System.out.println("Product header ===> "+producthHeaderValue);
		return producthHeaderValue;		
	}
	
	public String getProductItemsPrice() {
		String productPrice =  eleUtil.doGetElementText(itemPrice);
		return productPrice;
	}
	
	public void navigateBackToProductPage() {
		eleUtil.doClick(backToProductsBtn);
	}

}

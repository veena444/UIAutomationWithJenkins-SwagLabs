package com.qa.swaglabs.pages;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.swaglabs.constants.AppConstants;
import com.qa.swaglabs.utils.ElementUtil;

public class ProductDetailsPage {
	
	private WebDriver driver;
	private ElementUtil eleUtil;
	
    private By productHeader = By.xpath("//div[@class='inventory_details']//div[@data-test='inventory-item-name']");
    private By productDescription = By.xpath("//div[@id='inventory_item_container']//div[@data-test='inventory-item-desc']");
	private By productPrice = By.cssSelector("div.inventory_details_price");
	private By addToCartBtn = By.id("add-to-cart");
	private By backToProductsBtn = By.id("back-to-products");

	private Map<String,String> productMap;
	
	public ProductDetailsPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}
	
	public String getProductHeader() {
		String producthHeaderValue = eleUtil.waitForElementVisible(productHeader,AppConstants.DEFAULT_SHORT_TIME_OUT).getText();
		System.out.println("Product header ===> "+producthHeaderValue);
		return producthHeaderValue;		
	}
	
	public String getProductDescription() {
		String prodDescription = eleUtil.doGetElementText(productDescription);
		System.out.println("Product description ===> "+prodDescription);
		return prodDescription;
	}
	public String getProductPrice() {
		List<WebElement> priceList = eleUtil.getElements(productPrice);
		String price = priceList.get(0).getText();
		System.out.println("Product price is ===> "+price);
		return price;
	}
	
	public CartPage navigateToCartPage() {
		eleUtil.doClick(addToCartBtn);
		return new CartPage(driver);
	}
	
	public boolean backToProductsButtonExists() {
		return eleUtil.isElementDisplayed(backToProductsBtn);		
	}
	
	public void navigateBackToProductPage() {
		eleUtil.doClick(backToProductsBtn);
	}


}

package com.qa.swaglabs.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.swaglabs.constants.AppConstants;
import com.qa.swaglabs.utils.ElementUtil;
/**
 * @author Veena Hegde
 */
public class ProductPage {
	
	private WebDriver driver;
	private ElementUtil eleUtil;
	
	private By productPageLogo = By.xpath("//div[@class='app_logo']");
	private By productList = By.xpath("//div[@id='inventory_container']//div[@class='inventory_item']//div[@class='inventory_item_name ']");
	
	
	public ProductPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}
	
	public String getProductPageTitle() {
		String title = eleUtil.waitForTitleContainsAndReturn(AppConstants.PRODUCT_PAGE_TITLE, AppConstants.DEFAULT_SHORT_TIME_OUT);
		System.out.println("Product page page title: "+title);
		return title;
	}
	
	public String getProductPageURL() {
		String url = eleUtil.waitForURLContainsAndReturn(AppConstants.PRODUCT_PAGE_FRACTION_URL, AppConstants.DEFAULT_SHORT_TIME_OUT);
		System.out.println("Product page url: "+url);
		return url;
	}
	
	public boolean isProductPageLogoExists() {
		return eleUtil.isElementDisplayed(productPageLogo);
	}
	
	public int getProductsCount() {
		return eleUtil.waitForElementsVisible(productList, AppConstants.DEFAULT_MEDIUM_TIME_OUT).size();
	}
	
	public List<String> getProductList() {
		List<WebElement> invList = eleUtil.waitForElementsVisible(productList, AppConstants.DEFAULT_MEDIUM_TIME_OUT);
		List<String> invValueList = new ArrayList<String>();
		for(WebElement e:invList) {
			String text = e.getText().replaceAll("\\s+", " ").trim();
			System.out.println(text);
			invValueList.add(text);
		}
		return invValueList;
	}
	
	public ProductDetailsPage selectProduct(String productName) {
		System.out.println("Selecting product: "+ productName);
		eleUtil.doClick(By.linkText(productName));
		return new ProductDetailsPage(driver);
	}

}

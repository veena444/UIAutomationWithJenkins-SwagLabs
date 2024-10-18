package com.qa.swaglabs.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.swaglabs.constants.AppConstants;
import com.qa.swaglabs.utils.ElementUtil;

public class HomePage {
	
	private WebDriver driver;
	private ElementUtil eleUtil;
	
	private By homePageLogo = By.xpath("//div[@class='app_logo']");
	private By inventoryList = By.xpath("//div[@id='inventory_container']//div[@class='inventory_item']//div[@class='inventory_item_name ']");
	
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}
	
	public String getHomePageTitle() {
		String title = eleUtil.waitForTitleContainsAndReturn(AppConstants.HOME_PAGE_TITLE, AppConstants.DEFAULT_SHORT_TIME_OUT);
		System.out.println("Home page page title: "+title);
		return title;
	}
	
	public String getHomePageURL() {
		String url = eleUtil.waitForURLContainsAndReturn(AppConstants.HOME_PAGE_FRACTION_URL, AppConstants.DEFAULT_SHORT_TIME_OUT);
		System.out.println("Home page url: "+url);
		return url;
	}
	
	public boolean isHomePageLogoExists() {
		return eleUtil.isElementDisplayed(homePageLogo);
	}
	
	public int getHomePageInventoryListCount() {
		return eleUtil.waitForElementsVisible(inventoryList, AppConstants.DEFAULT_MEDIUM_TIME_OUT).size();
	}
	
	public List<String> getInventoryList() {
		List<WebElement> invList = eleUtil.waitForElementsVisible(inventoryList, AppConstants.DEFAULT_MEDIUM_TIME_OUT);
		List<String> invValueList = new ArrayList<String>();
		for(WebElement e:invList) {
			String text = e.getText().replaceAll("\\s+", " ").trim();
			System.out.println(text);
			invValueList.add(text);
		}
		return invValueList;
	}
	
	public void doClickItemFromInventoryList(String itemName) {
		eleUtil.doClick(inventoryList);
	}

}

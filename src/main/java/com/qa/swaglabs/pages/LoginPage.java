package com.qa.swaglabs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.swaglabs.constants.AppConstants;
import com.qa.swaglabs.utils.ElementUtil;

public class LoginPage {
	
	private WebDriver driver;
	private ElementUtil eleUtil;
	
	private By username = By.id("user-name");
	private By password = By.id("password");
	private By loginBtn = By.id("login-button");
	
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}
		
	
	public String getLoginPageTitle() {
		
		String title = eleUtil.waitForTitleContainsAndReturn(AppConstants.LOGIN_PAGE_TITLE, AppConstants.DEFAULT_SHORT_TIME_OUT);
		System.out.println("Login page title: "+title);
		return title;
	}

	public String getLoginPageURL() {
		String url = eleUtil.waitForURLContainsAndReturn(AppConstants.LOGIN_PAGE_URL, AppConstants.DEFAULT_SHORT_TIME_OUT);
		System.out.println("Login page url: "+url);
		return url;
	}
	
	public HomePage doLogin(String userName,String pwd) {
		
		eleUtil.waitForElementVisible(username, AppConstants.DEFAULT_MEDIUM_TIME_OUT).sendKeys(userName);
		eleUtil.doSendKeys(password, pwd);
		eleUtil.doClick(loginBtn);

		return new HomePage(driver);

	}
}

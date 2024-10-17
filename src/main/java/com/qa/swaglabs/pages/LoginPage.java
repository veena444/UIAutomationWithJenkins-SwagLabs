package com.qa.swaglabs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	private WebDriver driver;
	
	private By username = By.id("user-name");
	private By password = By.id("password");
	private By loginBtn = By.id("login-button");
	
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
		
	
	public String getLoginPageTitle() {
		String title = driver.getTitle();
		System.out.println("Login page title: "+title);
		return title;
	}

	public String getLoginPageURL() {
		String url = driver.getCurrentUrl();
		System.out.println("Login page url: "+url);
		return url;
	}
	
	public String doLogin(String userName,String pwd) {
		driver.findElement(username).sendKeys(userName);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(loginBtn).click();
		
		String homePageTitle = driver.getTitle();
		System.out.println("Home page title is: "+homePageTitle);
		return homePageTitle;
	}
}

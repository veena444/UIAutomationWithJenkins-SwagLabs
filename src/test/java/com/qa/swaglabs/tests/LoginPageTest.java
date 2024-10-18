package com.qa.swaglabs.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.swaglabs.base.BaseTest;
import com.qa.swaglabs.constants.AppConstants;

public class LoginPageTest extends BaseTest{
	
	@Test
	
	public void loginPageTitleTest() {
		String actualTitle = loginPage.getLoginPageTitle();
		Assert.assertEquals(actualTitle, AppConstants.LOGIN_PAGE_TITLE);
	}
	
	@Test
	
	public void loginPageURLTest() {
		String actualURL = loginPage.getLoginPageURL();
		Assert.assertEquals(actualURL, AppConstants.LOGIN_PAGE_URL);
	}
	
	
	@Test (priority = Integer.MAX_VALUE)
	
	public void loginTest() {
		homePage = loginPage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
		Assert.assertEquals(homePage.getHomePageTitle(), AppConstants.HOME_PAGE_TITLE);
	}

}

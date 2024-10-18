package com.qa.swaglabs.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.swaglabs.base.BaseTest;
import com.qa.swaglabs.constants.AppConstants;

public class HomePageTest extends BaseTest{
	
	@BeforeClass
	
	public void homePageSetup() {
		homePage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	@Test
	
	public void homePageTitleTest() {
		String actualTitle = homePage.getHomePageTitle();
		Assert.assertEquals(actualTitle, AppConstants.HOME_PAGE_TITLE);
	}
	
	@Test
	
	public void homePageURLTest() {
		String actualURL = homePage.getHomePageURL();
		Assert.assertTrue(actualURL.contains(AppConstants.HOME_PAGE_FRACTION_URL));
	}
	
	@Test
	
	public void logoExistsTest() {
		Assert.assertTrue(homePage.isHomePageLogoExists());
	}
	
	@Test
	
	public void homePageInventoryListCountTest() {
		Assert.assertEquals(homePage.getHomePageInventoryListCount(), AppConstants.HOME_PAGE_INVENTORY_LIST_COUNT);		
	}
	
	@Test
	
	public void homePageInventoryListTest() {
		List<String> actualInvList = homePage.getInventoryList();
		Assert.assertEquals(actualInvList, AppConstants.EXPECTED_HOME_PAGE_INVENTORY_LIST);
	}


}

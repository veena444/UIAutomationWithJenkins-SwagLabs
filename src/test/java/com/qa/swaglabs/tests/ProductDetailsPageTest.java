package com.qa.swaglabs.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.swaglabs.base.BaseTest;


public class ProductDetailsPageTest extends BaseTest{
	
	@BeforeClass

	public void productDetailsPageSetup() {
		 productPage =  loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@DataProvider
	public Object[][] getProductInfo(){
		return new Object[][] {
			{"Sauce Labs Backpack",
			"carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.",
			"$29.99"}
		};
	}
	
	@Test(dataProvider="getProductInfo")	
	public void productInfoTest(String productName, String productDescription, String productPrice) {
		productDetailsPage = productPage.selectProduct(productName);		
		Assert.assertEquals(productDetailsPage.getProductHeader(), productName);
		Assert.assertEquals(productDetailsPage.getProductDescription(), productDescription);
		Assert.assertEquals(productDetailsPage.getProductPrice(), productPrice);
		
		cartPage = productDetailsPage.navigateToCartPage();
	}
	

	
}

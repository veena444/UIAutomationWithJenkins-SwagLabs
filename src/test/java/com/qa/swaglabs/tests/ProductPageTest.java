package com.qa.swaglabs.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.swaglabs.base.BaseTest;
import com.qa.swaglabs.constants.AppConstants;

/**
 * @author Veena Hegde
 */
public class ProductPageTest extends BaseTest {

	@BeforeClass

	public void productPageSetup() {
		productPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test

	public void productPageTitleTest() {
		String actualTitle = productPage.getProductPageTitle();
		Assert.assertEquals(actualTitle, AppConstants.PRODUCT_PAGE_TITLE);
	}

	@Test

	public void productPageURLTest() {
		String actualURL = productPage.getProductPageURL();
		Assert.assertTrue(actualURL.contains(AppConstants.PRODUCT_PAGE_FRACTION_URL));
	}

	@Test

	public void logoExistsTest() {
		Assert.assertTrue(productPage.isProductPageLogoExists());
	}

	
	  @Test
	  
	  public void productPageProductCountTest() {
	  Assert.assertEquals(productPage.getProductsCount(),AppConstants.PRODUCT_COUNT); 
	  }
	 

	@Test

	public void productPageProductListTest() {
		List<String> actualProdList = productPage.getProductList();
		Assert.assertEquals(actualProdList, AppConstants.EXPECTED_PRODUCT_LIST);
	}
	
	@DataProvider	
	public Object[][] getProductData() {
		return new Object[][] {
			{"Sauce Labs Backpack"},
			{"Sauce Labs Bike Light"},
			{"Sauce Labs Bolt T-Shirt"},
			{"Sauce Labs Fleece Jacket"},
			{"Sauce Labs Onesie"},
			{"Test.allTheThings() T-Shirt (Red)"},
			
		};
	}
	  @Test(dataProvider="getProductData")	  
	  public void selectProductTest(String productName) {
		 productDetailsPage = productPage.selectProduct(productName);		 
		 String actualProductHeaderValue =  productDetailsPage.getProductHeader();
		 Assert.assertEquals(actualProductHeaderValue, productName);
		 productDetailsPage.navigateBackToProductPage();
	  }
	 

}

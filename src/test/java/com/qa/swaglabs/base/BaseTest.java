package com.qa.swaglabs.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import com.qa.swaglabs.factory.DriverFactory;
import com.qa.swaglabs.pages.CartPage;
import com.qa.swaglabs.pages.LoginPage;
import com.qa.swaglabs.pages.ProductDetailsPage;
import com.qa.swaglabs.pages.ProductPage;

public class BaseTest {
	
	WebDriver driver ;
	DriverFactory df ;
	protected SoftAssert softAssert;
	protected Properties prop ;
	
	protected LoginPage loginPage;
	protected ProductPage productPage;
	protected ProductDetailsPage productDetailsPage;
	protected CartPage cartPage;
	
	@BeforeTest
	
	public void setup() {
		df = new DriverFactory();
		prop = df.initProp();
		driver = df.initDriver(prop);
		loginPage = new LoginPage(driver);
		softAssert = new SoftAssert();
	}
	
	@AfterTest
	
	public void tearDown() {
		driver.quit();
	}

}

package com.qa.swaglabs.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.swaglabs.factory.DriverFactory;
import com.qa.swaglabs.pages.LoginPage;
import com.qa.swaglabs.pages.ProductDetailsPage;
import com.qa.swaglabs.pages.ProductPage;

public class BaseTest {
	
	WebDriver driver ;
	DriverFactory df ;
	protected Properties prop ;
	
	protected LoginPage loginPage;
	protected ProductPage productPage;
	protected ProductDetailsPage productDetailsPage;
	
	@BeforeTest
	
	public void setup() {
		df = new DriverFactory();
		prop = df.initProp();
		driver = df.initDriver(prop);
		loginPage = new LoginPage(driver);
	}
	
	@AfterTest
	
	public void tearDown() {
		driver.quit();
	}

}

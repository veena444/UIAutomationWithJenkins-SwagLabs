package com.qa.swaglabs.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.qa.swaglabs.errors.AppError;
import com.qa.swaglabs.exceptions.BrowserException;

public class DriverFactory {
	
	WebDriver driver;
	Properties prop;
	
	/**
	 * This method is used to initialize the driver on the basis of given browser name. 
	 * @param browserName
	 * @return It returns driver
	 */
	public WebDriver initDriver(Properties prop) {
		
		String browserName = prop.getProperty("browser");
		
		System.out.println("Browser name is: "+browserName);
		
		switch (browserName.toLowerCase().trim()) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;

		default:
			System.out.println(AppError.INVALID_BROWSER_MSG + browserName + " is invalid");
			throw new BrowserException(AppError.INVALID_BROWSER_MSG);
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));
		
		return driver;		

	}
	
	/**
	 * This method is used to initialize the properties from config.properties
	 * @return
	 */
	public Properties initProp() {
		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream("./src/test/resources/config/config.properties");
			try {
				prop.load(ip);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return prop;
		
	}

}

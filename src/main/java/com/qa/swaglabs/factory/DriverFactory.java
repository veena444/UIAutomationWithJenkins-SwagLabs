package com.qa.swaglabs.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;

import com.qa.swaglabs.errors.AppError;
import com.qa.swaglabs.exceptions.BrowserException;
import com.qa.swaglabs.exceptions.FrameworkException;
/**
 * @author Veena Hegde
 */
public class DriverFactory {
	
	WebDriver driver;
	Properties prop;
	
	public static String isHighlight;
	
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();
	
	/**
	 * This method is used to initialize the driver on the basis of given browser name. 
	 * @param browserName
	 * @return It returns driver
	 */
	public WebDriver initDriver(Properties prop) {
		
		String browserName = prop.getProperty("browser");
		
		System.out.println("Browser name is: "+browserName);
		
		isHighlight = prop.getProperty("highlight");
		
		OptionsManager optionsManager = new OptionsManager(prop);
		
		switch (browserName.toLowerCase().trim()) {
		case "chrome":
//			driver = new ChromeDriver(optionsManager.getChromeOptions());//without ThreadLocal
			tlDriver.set(new ChromeDriver(optionsManager.getChromeOptions()));//with ThreadLocal;
			break;
		case "firefox":
//			driver = new FirefoxDriver(optionsManager.getFirefoxOptions());
			tlDriver.set(new FirefoxDriver(optionsManager.getFirefoxOptions()));
			break;
		case "edge":
//			driver = new EdgeDriver(optionsManager.getEdgeOptions());
			tlDriver.set(new EdgeDriver(optionsManager.getEdgeOptions()));
			break;

		default:
			System.out.println(AppError.INVALID_BROWSER_MSG + browserName + " is invalid");
			throw new BrowserException(AppError.INVALID_BROWSER_MSG);
		}
		
//		driver.manage().window().maximize();
		getDriver().manage().window().maximize();
//		driver.manage().deleteAllCookies();
		getDriver().manage().deleteAllCookies();
//		driver.get(prop.getProperty("url"));
		getDriver().get(prop.getProperty("url"));
		
//		return driver;
		return getDriver();

	}
	
	/**
	 * This method is used to return the driver with ThreadLocal
	 * @return ThreadLocal driver
	 */
	public static WebDriver getDriver() {
		return tlDriver.get();
	}
	
	/**
	 * This method is used to initialize the properties from config.properties
	 * @return
	 */
	public Properties initProp() {
		prop = new Properties();
		FileInputStream ip = null; 
		
		String envName = System.getProperty("env");
		System.out.println("Running tests on env: "+envName);
		
		try {
		if(envName==null) {
			System.out.println("env is null...hence running tests on QA env");
			ip =  new FileInputStream("./src/test/resources/config/qa.config.properties");
		}
		else {
			switch (envName.toLowerCase().trim()) {
			case "qa":
				ip =  new FileInputStream("./src/test/resources/config/qa.config.properties");
				break;
			case "dev":
				ip =  new FileInputStream("./src/test/resources/config/dev.config.properties");
				break;
			case "uat":
				ip =  new FileInputStream("./src/test/resources/config/uat.config.properties");
				break;
			case "stage":
				ip =  new FileInputStream("./src/test/resources/config/stage.config.properties");
				break;
			case "prod":
				ip =  new FileInputStream("./src/test/resources/config/config.properties");
				break;

			default:
				System.out.println("Please pass the right env name..");
				throw new FrameworkException("INVALID ENV NAME");				
			}
		}
		prop.load(ip);	
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		return prop;
    }
	
	/**
	 * This method is used to take the screenshot.
	 * @param methodName
	 * @return It returns path of the file.
	 */
	public static String getScreenshot(String methodName) {
		File srcFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);//temp dir
		String path = System.getProperty("user.dir") + "/screenshot/" + methodName + "_" + System.currentTimeMillis()+ ".png";
		File destination = new File(path);
		try {
			FileHandler.copy(srcFile, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return path;
	}
		
}

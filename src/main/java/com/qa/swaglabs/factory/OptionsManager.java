package com.qa.swaglabs.factory;

import java.util.Properties;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;


public class OptionsManager {
	
	private Properties prop;
	private ChromeOptions co;
	private FirefoxOptions fo;
	private EdgeOptions eo;
	
	public OptionsManager(Properties prop) {
		this.prop = prop;
	}
	
	public ChromeOptions getChromeOptions() {
		co = new ChromeOptions();
		if(Boolean.parseBoolean(prop.getProperty("headless"))) 
				{
			System.out.println("...Running in headless...");
			co.addArguments("--headless");
			co.addArguments("--window-position=-2400,-2400"); //temporary fix
		}
		if(Boolean.parseBoolean(prop.getProperty("incognito"))){
			co.addArguments("--incognito");
		}

		return co;
	}
	
	public FirefoxOptions getFirefoxOptions() {
		fo = new FirefoxOptions();
		if(Boolean.parseBoolean(prop.getProperty("headless"))) {
			System.out.println("...Running in headless...");
			fo.addArguments("--headless");
			fo.addArguments("--window-position=-2400,-2400"); //temporary fix
		}
		if(Boolean.parseBoolean(prop.getProperty("incognito"))){
			fo.addArguments("--incognito");
		}

		return fo;
	}
	
	public EdgeOptions getEdgeOptions() {
		eo = new EdgeOptions();
		if(Boolean.parseBoolean(prop.getProperty("headless"))) {
			System.out.println("...Running in headless...");
			eo.addArguments("--headless");
			eo.addArguments("--window-position=-2400,-2400"); //temporary fix
		}
		if(Boolean.parseBoolean(prop.getProperty("incognito"))){
			eo.addArguments("--Inprivate");
		}

		return eo;
	}


}

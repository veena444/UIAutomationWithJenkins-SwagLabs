package com.qa.swaglabs.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptUtil {
	
	private WebDriver driver;
	private JavascriptExecutor js;
	
	
	public JavaScriptUtil(WebDriver driver) {
		this.driver=driver;
		js=(JavascriptExecutor)driver;		
	}
	
	public String getPageTitle() {
		return js.executeScript("return document.title;").toString();
	}
	
	public String getPageURL() { 
		return js.executeScript("return document.URL;").toString();
	}
	public void generateJsAlert(String message) {
		js.executeScript("alert('"+message+"')");
	}
	public String getPageInnerText() {
		return js.executeScript("return document.documentElement.innerText;").toString();
	}
	public void goBackWithJS() {
		js.executeScript("history.go(-1)");
	}
	public void goForwardWithJS() {
		js.executeScript("history.go(1)");
	}
	public void pageRefreshWithJS() {
		js.executeScript("history.go(0)");
	}
	/**
	 * example: "document.body.style.zoom = '400%'"
	 * @param zoomPercentage
	 */
	public void zoomBrowser(String zoomPercentage) {
		String zoom = "document.body.style.zoom = '"+zoomPercentage+"%'";
		js.executeScript(zoom);
	}
	/**
	 * example: "document.body.style.MozTransform = 'scale(0.5)'"
	 * @param zoomPercentage
	 */
	
	public void zoomFirefox(String zoomPercentage) {
		String zoom = "document.body.style.MozTransform = 'scale("+zoomPercentage+")'";
		js.executeScript(zoom);
	}
	
	public void scrollMiddlePageDown() {
		js.executeScript("window.scrollTo(0,document.body.scrollHeight/2);");
	}
	//page end
	public void scrollPageDown() {
		js.executeScript("window.scrollTo(0,document.body.scrollHeight);");
	}
	//top page
	public void scrollPageUp() {
		js.executeScript("window.scrollTo(document.body.scrollHeight,0);");
	}
	public void scrollPageDown(String height) {
		js.executeScript("window.scrollTo(0,'"+height+"');");
	}
	
	public void scrollIntoView(WebElement element) {
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	public void drawBorder(WebElement element) {
		js.executeScript("arguments[0].style.border='3px solid green'", element);
		
	}
	
	public void flash(WebElement element) {
		String bgcolor = element.getCssValue("backgroundColor");
		for(int i =0 ;i< 10;i++) {
			changeColor("rgb(0,200,0)",element);
			changeColor(bgcolor,element);
		}
	}
	
	private void changeColor(String color, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].style.backgroundColor = '"+color+"'", element);
		try {
			Thread.sleep(20);
		}
		catch(InterruptedException e) {
			
		}
	}


	
	
}

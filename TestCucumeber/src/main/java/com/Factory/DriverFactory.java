package com.Factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
	/*
	 * it initializes driver with threadsafe
	 * returns driver
	 */
	//public WebDriver driver;
	public static ThreadLocal<WebDriver> tldriver = new ThreadLocal<WebDriver>();

	public  WebDriver int_driver(String browser) 
	{

		if(browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			tldriver.set(new ChromeDriver());
		}

		else {

			System.out.print("Please enter only Chrome");
		}
		
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		return getDriver();

	}

	public static synchronized WebDriver getDriver() {
		
		return tldriver.get();
		
	}

}

package com.officemate.qa.base;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.officemate.qa.util.Utility;

public class BaseClass {

	public static WebDriver driver;
	public static Properties prop;
	public  static EventFiringWebDriver e_driver;

	public BaseClass(){
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("/Users/baskar.j/workspace/HomeTest/src/main/java/com/officemate/qa/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public static void initialization(){
		String browserName = prop.getProperty("browser");

		if(browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "C:/Users/baskar.j/Downloads/chromedriver.exe");	
			driver = new ChromeDriver(); 
		}
		else if(browserName.equals("FF")){
			System.setProperty("webdriver.gecko.driver", "C:/Users/baskar.j/Downloads/geckodriver.exe");	
			driver = new FirefoxDriver(); 
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Utility.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Utility.IMPLICIT_WAIT, TimeUnit.SECONDS);		
		driver.get(prop.getProperty("url"));

	}





}

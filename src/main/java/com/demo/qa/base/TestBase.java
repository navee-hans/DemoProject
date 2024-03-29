package com.demo.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.demo.qa.util.TestUtil;
import com.demo.qa.util.WebEventListener;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;

public class TestBase {
	
	public static Properties prop;
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	public static ThreadLocal<WebDriver> webdriverThreadLocal = new ThreadLocal<WebDriver>();
	
	@BeforeSuite
	public void getConfig(){
		
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome")){
			ChromeOptions options = new ChromeOptions();
			options.addArguments("start-maximized");
			webdriverThreadLocal.set(new ChromeDriver(options));
		}
		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();
		getDriver().manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		getDriver().manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		getDriver().get(prop.getProperty("url"));
	}
	
	public static WebDriver getDriver() {
		return webdriverThreadLocal.get();
	}
	
	@AfterSuite
	public void tearDown(){
		getDriver().quit();
		webdriverThreadLocal.remove();
	}
}

package com.demo.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import com.demo.qa.base.TestBase;
import com.relevantcodes.extentreports.LogStatus;


public class Blueapron_HomePage extends TestBase {
	WebDriver driver;
	
	String close = ".//a[@title=\"Close\"]";
	String pricing = "(.//a[@class='nav_pricing' and .='Pricing'])[2]";
	
	public Blueapron_HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void checkIfPopUp() {
		try {
			List<WebElement> elem = driver.findElements(By.xpath(close));	
			int present = elem.size();
			if (present == 1) {
				driver.findElement(By.xpath(close)).click();
			}
		}catch(Exception e)
		{

		}
	}
	
	public WebElement pricingButton() {
		return driver.findElement(By.xpath(pricing));
	}
	
	public void verifyPricingPageOpenSuccessfully() {
		checkIfPopUp();
		pricingButton().click();
		String title = driver.getTitle();
		Assert.assertTrue(title.contains("Pricing"));
	}
}

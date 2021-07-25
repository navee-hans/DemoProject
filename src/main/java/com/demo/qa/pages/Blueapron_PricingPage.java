package com.demo.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.demo.qa.base.TestBase;
import com.demo.qa.util.TestUtil;
import com.relevantcodes.extentreports.LogStatus;

public class Blueapron_PricingPage extends TestBase {
	WebDriver driver;
	
	String Signature = ".//h1[.='Signature']";
	String close = ".//a[@title=\"Close\"]";
	String twosignaturecost = ".//h1[.='Signature']/..//span/span[@uit='serving-price-value-with-discount']";
	String twosignatureship = ".//h1[.='Signature']/..//span[@uit='shipping-price-value']";
	String foursignaturecost = ".//h1[.='Signature for 4']/..//span/span[@uit='serving-price-value-with-discount']";
	String foursignatureship = ".//h1[.='Signature for 4']/..//span[@uit='shipping-price-value']";
	String selecttwovalue = "(.//ul[@class='pom-QuantitySelector pom-QuantitySelector__circle']/li/button[.='2'])[1]";
	String selecttwovalueforsecond = "(.//ul[@class='pom-QuantitySelector pom-QuantitySelector__circle']/li/button[.='3'])[2]";
	String slectbutton = "(.//button/span[.='Select']/..)[1]";
	
	public Blueapron_PricingPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void checkIfPopUp() {	
		try {
		List<WebElement> elem = driver.findElements(By.xpath(close));	
		int present = elem.size();
		if (present == 1) {
			driver.findElement(By.xpath(close)).click();
		}
		}catch(Exception e) {
		}
	}
	
	public void verify2ServingSignatureCostShipping(String costcheck, String shippingcheck) {
		checkIfPopUp();
		TestUtil.scrollToElement(By.xpath(twosignaturecost));
		String cost = driver.findElement(By.xpath(twosignaturecost)).getText();
		String shipping = driver.findElement(By.xpath(twosignatureship)).getText();
		Assert.assertEquals(cost, costcheck);
		Assert.assertEquals(shipping, shippingcheck);
	}
	
	public void verify4ServingSignatureCostShipping(String costcheck, String shippingcheck) {
		String cost = driver.findElement(By.xpath(foursignaturecost)).getText();
		String shipping = driver.findElement(By.xpath(foursignatureship)).getText();
		Assert.assertEquals(cost, costcheck);
		Assert.assertEquals(shipping, shippingcheck);
	}
	
	public void change2SignatureTwoRecipes() {	
		driver.findElement(By.xpath(selecttwovalue)).click();
	}
	
	public void change4SignatureTwoRecipes() {
		driver.findElement(By.xpath(selecttwovalueforsecond)).click();
	}
	
	public void clickSelectButton() {
		driver.findElement(By.xpath(slectbutton)).click();	
	}

}

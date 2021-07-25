package com.demo.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.demo.qa.base.TestBase;
import com.demo.qa.util.TestUtil;
import com.relevantcodes.extentreports.LogStatus;

public class Blueapron_SignupPage extends TestBase {
	WebDriver driver;
	
	String close = ".//a[@title=\"Close\"]";
	String getstarted = ".//h1[@class='title' and .='Get Started']";
	String appleid = ".//div[@aria-label='Continue with Apple']";
	String buttoncontinue = ".//button[.='Continue']";
	String errorcheck = ".//div[@class='pom-InputError' and .='Invalid email address']";
	
	public Blueapron_SignupPage(WebDriver driver) {
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
	
	public void verifySignupPage() {
		try {
		checkIfPopUp();
		WebDriverWait wait = new WebDriverWait(driver, 4);
		WebElement elem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(getstarted)));
		Assert.assertTrue(elem.isDisplayed(),AppMsg.FAIL_SIGNUP_MESSAGE);
		}catch(Exception e) {
		}
	}
	
	public void verifyAppleID() {	
		try {
		WebDriverWait wait = new WebDriverWait(driver, 6);
		TestUtil.scrollToElement(By.xpath(appleid));
		WebElement elem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(appleid)));
		Assert.assertTrue(elem.isDisplayed(),AppMsg.FAIL_APPLEID_MESSAGE);
		}catch(Exception e) {
		}
	}
	
	public void clickContinueButton() {
		driver.findElement(By.xpath(buttoncontinue)).click();
	}
	
	public void verifyErrorForEmail() {
		WebDriverWait wait = new WebDriverWait(driver, 4);
		WebElement elem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(errorcheck)));
		Assert.assertTrue(elem.isDisplayed(),AppMsg.FAIL_ERROR_MESSAGE);
	}

}

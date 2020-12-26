package com.demo.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.demo.qa.base.TestBase;
import com.demo.qa.util.TestUtil;


public class CategoryPage extends TestBase {
	
	WebDriver driver;
	
	public CategoryPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickCategory(String categoryName) {
		driver.findElement(By.xpath("//a[.='"+categoryName+"']"));
	}
	
	public void expandCategoryAndChooseSubcategory(String[] categories) {
		Actions action = new Actions(driver);
		for(int i = 0 ; i< categories.length;i++) {
			WebElement elem = driver.findElement(By.xpath("//a[.='"+categories[i]+"']"));
			if(i==categories.length-1) {
				elem.click();
			}
			else {
				action.moveToElement(elem).perform();
			}
		}
	}

	public void clickMoreForItem(String itemName) {
		TestUtil.hoverOver(By.xpath("//a[@title='"+itemName+"']"));
		TestUtil.scrollToAndClick(By.xpath("//a[@title='"+itemName+"']/ancestor::li//a[@title='More']"));
	}
	
	
	public void clickAddToCart(String itemName){
		TestUtil.hoverOver(By.xpath("//a[@title='"+itemName+"']"));
		
		TestUtil.scrollToAndClick(By.xpath("//a[@title='"+itemName+"']/ancestor::li//a[@title='Add to cart']"));
	}
	
	/*
	 * Verification Methods Below
	 */

	public void verifyProductAddedMessage() {
		WebDriverWait wait = new WebDriverWait(driver, 4);
		WebElement elem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='layer_cart']//h2[normalize-space(.)='"+AppMsg.PRODUCT_ADDED_TO_CART_MESSAGE+"']")));
		Assert.assertTrue(elem.isDisplayed(),AppMsg.PRODUCT_ADDED_TO_CART_MESSAGE+ " message is found ");
	}
	
	public void failverifyProductAddedMessage() {
		WebDriverWait wait = new WebDriverWait(driver, 4);
		WebElement elem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='layer_cart']//h2[normalize-space(.)='"+AppMsg.FAIL_PRODUCT_ADDED_TO_CART_MESSAGE+"']")));
		Assert.assertTrue(elem.isDisplayed(),AppMsg.FAIL_PRODUCT_ADDED_TO_CART_MESSAGE+ " message is found ");
	}
}

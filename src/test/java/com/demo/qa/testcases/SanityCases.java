package com.demo.qa.testcases;
import org.testng.annotations.Test;

import com.demo.qa.base.TestBase;
import com.demo.qa.pages.CategoryPage;


public class SanityCases extends TestBase{
	CategoryPage categoryPage;
	
	@Test(priority=1, enabled = false, description = "Verify user can add a item from the T-shirts category")
	public void testScriptCall1 (){
		testscript();
	}
	
	@Test(priority=1, enabled = false, description = "Verify user can add a item from the T-shirts category")
	public void testScriptCall2 (){
		testscript();
	}
	
	@Test(priority=1, description = "Verify user can add a item from the T-shirts category")
	public void testScriptCall3 (){
		testscript();
	}
	
	@Test(priority=1, description = "Verify user can add a item from the T-shirts category")
	public void selectDressAndAddToCart2(){
		categoryPage = new CategoryPage(getDriver());
		String[] categories = {"Women","Tops","T-shirts"};
		categoryPage.expandCategoryAndChooseSubcategory(categories);
		categoryPage.clickAddToCart("Faded Short Sleeve T-shirts");
		categoryPage.failverifyProductAddedMessage();
	}
	
	public void testscript() {
		categoryPage = new CategoryPage(getDriver());
		String[] categories = {"Women","Tops","T-shirts"};
		categoryPage.expandCategoryAndChooseSubcategory(categories);
		categoryPage.clickAddToCart("Faded Short Sleeve T-shirts");
		categoryPage.verifyProductAddedMessage();
	}
}
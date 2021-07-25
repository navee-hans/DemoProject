package com.demo.qa.testcases;
//import org.testng.annotations.AfterSuite;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.demo.qa.base.TestBase;
import com.demo.qa.pages.Blueapron_HomePage;
import com.demo.qa.pages.Blueapron_PricingPage;
import com.demo.qa.pages.Blueapron_SignupPage;
import com.demo.qa.util.TestUtil;
//import com.relevantcodes.extentreports.ExtentReports;
//import com.relevantcodes.extentreports.ExtentTest;
//import com.relevantcodes.extentreports.LogStatus;
//

public class Blueapron_Tests extends TestBase{
	

	Blueapron_HomePage homePage;
	Blueapron_SignupPage signupPage;
	Blueapron_PricingPage pricePage;
	
	
	@Test(priority=0, enabled = true, description = "Verify User lands on Pricing Page")
	public void testScriptCall1 (){
		homePage = new Blueapron_HomePage(getDriver());
		homePage.verifyPricingPageOpenSuccessfully();
	}
	
	@Test(priority=1, enabled = true, description = "Verify Cost And Shipping Charges For 2-Serving Signature")
	public void testScriptCall2 (){
	pricePage = new Blueapron_PricingPage(getDriver());
	pricePage.verify2ServingSignatureCostShipping("$9.99", "FREE");
	}
	
	@Test(priority=2, enabled = true, description = "Verify Cost And Shipping Charges")
	public void testScriptCall3 (){
		pricePage.verify4ServingSignatureCostShipping("$8.99", "FREE");
		
	}
	
	@Test(priority=3, enabled = true, description = "Change 2-Serving Signature from three recipes to two recipes per week")
	public void testScriptCall4 (){
		pricePage.change2SignatureTwoRecipes();
		
	}
	
	@Test(priority=4, enabled = true, description = "change 4-Serving Signature from two to three recipes per week")
	public void testScriptCall5 (){
		pricePage.change4SignatureTwoRecipes();
		TestUtil.wait(1000);
	}
	
	@Test(priority=5, enabled = true, description = "Verify Cost and Shipping Charges after changing per week for 2-Serving Signature")
	public void testScriptCall6 (){
		pricePage.verify2ServingSignatureCostShipping("$9.99", "$7.99");
	}
	
	@Test(priority=6, enabled = true, description = "Verify Cost and Shipping Charges after changing per week for 4-Serving Signature")
	public void testScriptCall7 (){
		pricePage.verify4ServingSignatureCostShipping("$7.99", "FREE");
	}
	
	@Test(priority=7, enabled = true, description = "Click Select Button for Any Item")
	public void testScriptCall8 (){
		pricePage.clickSelectButton();
	}
	
	@Test(priority=8, enabled = true, description = "Verif User is on Signup Page")
	public void testScriptCall9 (){
		signupPage = new Blueapron_SignupPage(getDriver());
		signupPage.verifySignupPage();
	}
	
	@Test(priority=9, enabled = true, description = "Verif Apple SignUp Button Is Displayed")
	public void testScriptCall_1 (){
		signupPage.verifyAppleID();
	}
	
	@Test(priority=10, enabled = true, description = "Verify Error When click the Continue button without entering the email address")
	public void testScriptCall_2 (){
		signupPage.clickContinueButton();
		TestUtil.wait(1000);
		signupPage.verifyErrorForEmail();
		
	}
}
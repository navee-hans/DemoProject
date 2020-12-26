package com.demo.qa.util;
	
import org.testng.ITestListener;		
import org.testng.ITestResult;
public class CustomITestListener implements ITestListener{
    public void onTestStart(ITestResult Result){		
    	TestUtil.testname = Result.getName();					
    }
	
    public void onTestFailure(ITestResult Result) {	
    	//Take Screenshot
    	try {
    		TestUtil.takeScreenshotAtEndOfTest(Result.getName());
    	}
    	catch(Exception e) {
    		System.out.println("Some Exception");
    	}
    }	
}

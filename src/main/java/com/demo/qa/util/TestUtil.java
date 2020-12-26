package com.demo.qa.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.demo.qa.base.TestBase;

public class TestUtil extends TestBase {

	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 20;
	public static String testname = null;


	static JavascriptExecutor js;

//	public void switchToFrame() {
//		driver.switchTo().frame("mainpanel");
//	}
//
//	public static Object[][] getTestData(String sheetName) {
//		FileInputStream file = null;
//		try {
//			file = new FileInputStream(TESTDATA_SHEET_PATH);
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
//		try {
//			book = WorkbookFactory.create(file);
//		} catch (InvalidFormatException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		sheet = book.getSheet(sheetName);
//		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
//		// System.out.println(sheet.getLastRowNum() + "--------" +
//		// sheet.getRow(0).getLastCellNum());
//		for (int i = 0; i < sheet.getLastRowNum(); i++) {
//			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
//				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
//				// System.out.println(data[i][k]);
//			}
//		}
//		return data;
//	}
	


	public static String takeScreenshotAtEndOfTest(String fileName) throws IOException {
		
		File scrFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		File Dest = new File(currentDir+"/screenshots/" + fileName + ".png");
		FileUtils.copyFile(scrFile, Dest);
		String errflpath = Dest.getAbsolutePath();
		return errflpath;
	}
	
	public static void scrollToElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView(true)", element);
	}
	
	public static void scrollToElement(By element) {
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView(true)", getDriver().findElement(element));
	}
	
	public static void scrollToAndClick(By element) {
		WebElement elem = getDriver().findElement(element);
		scrollToElement(elem);
		elem.click();
	}
	
	public static void hoverOver(By element) {
		Actions action = new Actions(getDriver());
		scrollToElement(element);
		action.moveToElement(getDriver().findElement(element)).perform();
	}
	
	public static void wait(int timeInMs) {
		try {
			Thread.sleep(timeInMs);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

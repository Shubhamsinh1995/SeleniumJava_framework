package com.crm.qa.util;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import com.google.common.io.Files;

public class ScreenShot_Utility{
	
	public static String captureScreenshot(WebDriver driver, String testcaseName) {
		
		try {
			TakesScreenshot ts=(TakesScreenshot) driver;
			File src=ts.getScreenshotAs(OutputType.FILE);
			Files.copy(src, new File("./ScreenShots/"+testcaseName+".png"));
		} catch (Exception e) {
		
			System.out.println("Exception while getting screenshot "+e.getMessage() );
		} 
		return System.getProperty("user.dir")+"\\ScreenShots\\"+testcaseName+".png";
		
	}
}

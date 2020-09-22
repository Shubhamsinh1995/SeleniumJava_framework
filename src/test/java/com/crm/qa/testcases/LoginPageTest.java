package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.ScreenShot_Utility;

public class LoginPageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest() { 
		super();
		
	}
	
	@BeforeMethod
	public void setUp() 
	{
		initialization();
		loginPage=new LoginPage();
	}
	
	@Test(priority = 1)
	public void loginPageTitle()
	{
		String title=loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Cogmento CRM");
	}
	
	@Test(priority = 2)
	public void loginTest() throws Exception
	{
		homePage=loginPage.login(prop.getProperty("username"),prop.getProperty("password") );
		ScreenShot_Utility.captureScreenshot(driver, "Login");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}

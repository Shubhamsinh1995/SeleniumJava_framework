package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class HomePageTest extends TestBase {

	HomePage homePage;
	LoginPage loginPage;
	ContactsPage contactsPage;
	
	public HomePageTest() {
		super();
	}
	
	
	// testcase should be seperated -- independent to each other
	// before each testcase -- launch the browser and login
	// @Test-- execute test case
	// after each test case-- close the browser
	
	@BeforeMethod
	public void setUp() 
	{
		initialization();
		loginPage=new LoginPage();
		contactsPage=new ContactsPage();
		homePage=loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	@Test(priority = 1)
	public void verifyHomePageTitleTest()
	{
		String title=homePage.verifyHomePageTitle();
		Assert.assertEquals(title, "Cogmento CRM","Home page title not matched");
	}
	
	@Test(priority = 2)
	public void verifyusernameTest()
	{
		Assert.assertTrue(homePage.verifyusernameLable()); 
	}
	
	@Test(priority = 3)
	public void clickOnConctsLinkTest()
	{
		contactsPage=homePage.clickOnConctsLink();
	}

	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
}

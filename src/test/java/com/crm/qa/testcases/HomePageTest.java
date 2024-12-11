package com.crm.qa.testcases;

import com.crm.qa.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;


public class HomePageTest extends BaseTest {

	HomePage homePage;
	LoginPage loginPage;
	ContactsPage contactsPage;

	// testcase should be seperated -- independent to each other
	// before each testcase -- launch the browser and login
	// @Test-- execute test case
	// after each test case-- close the browser
	
	
	@Test(priority = 1)
	public void verifyHomePageTitleTest()
	{
		loginPage=new LoginPage();
		contactsPage=new ContactsPage();
		homePage = loginPage.doLogin();
		
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

	
}

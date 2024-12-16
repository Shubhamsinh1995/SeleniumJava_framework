package com.crm.qa.testcases;

import com.crm.qa.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends BaseTest {

	LoginPage loginPage;
	HomePage homePage;
	
	@Test(priority = 1)
	public void loginPageTitle()
	{
		loginPage = new LoginPage();
		String title=loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Cogmento CRM");
	}
	
	@Test(priority = 2)
	public void loginTest() throws Exception
	{
		loginPage = new LoginPage();
		homePage = loginPage.doLogin();
	}

}

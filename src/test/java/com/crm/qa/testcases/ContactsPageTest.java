package com.crm.qa.testcases;

import java.util.ArrayList;
import java.util.Iterator;

import com.crm.qa.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestDataUtils;

public class ContactsPageTest extends BaseTest {

	HomePage homePage;
	LoginPage loginPage;
	ContactsPage contactsPage;
	
	   // testcase should be seperated -- independent to each other
		// before each testcase -- launch the browser and login
		// @Test-- execute test case
		// after each test case-- close the browser

		
		@Test(priority = 1)
		public void verifyContactsPageLableTest()
		{
			loginPage=new LoginPage();
			homePage=loginPage.doLogin();
			contactsPage=homePage.clickOnConctsLink();
			Assert.assertTrue(contactsPage.verifycontactsLable()," contacts labe is missing on the page");
		}
		
		@Test(priority=2)
		public void selectSingleContactsTest()
		{
			loginPage=new LoginPage();
			homePage=loginPage.doLogin();
			contactsPage=homePage.clickOnConctsLink();
			contactsPage.selectContactByName("Akshay bhagat");
		}
		
		@Test(priority=3)
		public void selectMultipleContactsTest()
		{
			loginPage=new LoginPage();
			homePage=loginPage.doLogin();
			contactsPage=homePage.clickOnConctsLink();
			contactsPage.selectContactByName("Akshay bhagat");
			contactsPage.selectContactByName("pooja  patil");
		}
		
		@DataProvider
		public Iterator<Object[]> getCRMTestData()
		{
			ArrayList<Object[]> data=TestDataUtils.getTestDataFromExcel();
			return data.iterator();
		}
		
		@Test(priority=4, dataProvider ="getCRMTestData" )
		public void clickNewContactTest(String fname, String lname, String comp, String status)
		{
			loginPage=new LoginPage();
			homePage=loginPage.doLogin();
			contactsPage=homePage.clickOnConctsLink();
			contactsPage.clickOnNewContactLink();
			contactsPage.createNewContact(fname, lname, comp, status);
		}
}
		
		

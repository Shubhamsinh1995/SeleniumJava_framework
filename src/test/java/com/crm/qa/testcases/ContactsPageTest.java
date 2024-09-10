package com.crm.qa.testcases;

import java.util.ArrayList;
import java.util.Iterator;

import org.apache.log.Priority;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestDataUtils;

public class ContactsPageTest extends TestBase {

	HomePage homePage;
	LoginPage loginPage;
	ContactsPage contactsPage;
	
	public ContactsPageTest() {
		super();
	}
	
	// testcase should be seperated -- independent to each other
		// before each testcase -- launch the browser and login
		// @Test-- execute test case
		// after each test case-- close the browser
		
	/*
	 * @BeforeMethod public void setUp() { initialization(); loginPage=new
	 * LoginPage(); contactsPage=new ContactsPage();
	 * homePage=loginPage.login(prop.getProperty("username"),prop.getProperty(
	 * "password")); contactsPage=homePage.clickOnConctsLink(); }
	 */
		
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
		
		@Test(priority=4,groups = "contacts", dataProvider ="getCRMTestData" )
		public void clickNewContactTest(String fname, String lname, String comp)
		{
			loginPage=new LoginPage();
			homePage=loginPage.doLogin();
			contactsPage=homePage.clickOnConctsLink();
			contactsPage.clickOnNewContactLink();
			//contactsPage.createNewContact("arti", "mahalle", "xyz");
			contactsPage.createNewContact(fname, lname, comp);
		}
}
		
		

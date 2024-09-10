package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath="//span[contains(text(),'shubham baiyas')]")
    WebElement usernameLable;
	
	@FindBy(xpath = "//i[@class='users icon']")
	WebElement usernIcon;
	
	@FindBy(xpath="//span[contains(text(),'Contacts')]")
    WebElement contactsLink;
	
	@FindBy(xpath="//span[contains(text(),'Deals')]")
    WebElement dealsLink;
	
	@FindBy(xpath="//span[contains(text(),'Tasks')]")
    WebElement taskLink;
	
	//initializing the Page Objects
	public HomePage()  {
		PageFactory.initElements(driver,this);
		}
	
	// Actions
	public String verifyHomePageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean verifyusernameLable()
	{
		return  usernameLable.isDisplayed();
	}
	
	
	public ContactsPage clickOnConctsLink()
	{
		Actions actions = new Actions(driver);	
		actions.moveToElement(usernIcon).perform();
		contactsLink.click();
		return new ContactsPage();
	}
	
	
	public DealsPage clickOnDealsLink()
	{
		contactsLink.click();
		return new DealsPage();
	}
	
	public TasksPage clickOnTasksLink()
	{
		contactsLink.click();
		return new TasksPage();
	}

}

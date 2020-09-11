package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {

	@FindBy(xpath="//div[text()='Contacts']")
	WebElement contactsLable;
	
	@FindBy(xpath="//button[text()='New']")
    WebElement newContactsLink;
	
	@FindBy(xpath="//input[@name='first_name']")
	WebElement firstName;
	
	@FindBy(xpath="//input[@name='last_name']")
	WebElement lastName;
	
	@FindBy(xpath="//input[@class='search']")
	WebElement company;
	
	@FindBy(xpath="//i[@class='save icon']")
	WebElement saveBtn;
	
//	@FindBy(name="status")
//	WebElement status;
	
//	@FindBy(xpath="//td[text()='Akshay bhagat']//preceding-sibling::td[@class='']//div[@class='ui fitted read-only checkbox']")
//	WebElement checkBox;
	
	
	//initializing the Page Objects
	public ContactsPage() {
		PageFactory.initElements(driver,this);
	}
	
	// Actions
	public boolean verifycontactsLable()
	{
		return contactsLable.isDisplayed();
	}
	
	public void selectContactByName(String name)
	{
		driver.findElement(By.xpath("//td[text()='"+name+"']//preceding-sibling::td[@class='']"
				+ "//div[@class='ui fitted read-only checkbox']")).click();
	}
	
	public void clickOnNewContactLink()
	{
		newContactsLink.click();
	}
	
	public void createNewContact(String fname, String lname, String comp)
	{
		firstName.sendKeys(fname);
		lastName.sendKeys(lname);
		company.sendKeys(comp);
		
//		Select select=new Select(driver.findElement(By.name("status")));
//		select.selectByVisibleText(status);
		
		saveBtn.click();
	}

}

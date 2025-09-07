package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.Base;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ContactsPage extends Base {

	@FindBy(xpath="//span[@class='selectable ' and text()='Contacts']")
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
	
	@FindBy(name="status")
	WebElement status;
	
	@FindBy(xpath="//td[text()='Akshay bhagat']//preceding-sibling::td[@class='']//div[@class='ui fitted read-only checkbox']")
	WebElement checkBox;
	
	
	//initializing the Page Objects
	public ContactsPage() {
		PageFactory.initElements(driver,this);
	}
	
	// Actions
	public boolean verifycontactsLable()
	{
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3000));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));

		getWebDriverWait(20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Contacts']")));
		Actions actions = new Actions(driver);	
		actions.moveToElement(contactsLable).build().perform();
		return contactsLable.isDisplayed();
	}
	
	public void selectContactByName(String name)
	{
		
		driver.findElement(By.xpath("//a[text()='"+name+"']/parent::td/preceding-sibling::td/div[@class='ui fitted read-only checkbox']")).click();
	}
	
	
	public void clickOnNewContactLink()
	{
		newContactsLink.click();
	}
	
	public void createNewContact(String fname, String lname, String comp, String statusName)
	{
		firstName.sendKeys(fname);
		lastName.sendKeys(lname);
		company.sendKeys(comp);
		
		Select select=new Select(status);
		select.selectByVisibleText(statusName);

		saveBtn.click();
	}

}

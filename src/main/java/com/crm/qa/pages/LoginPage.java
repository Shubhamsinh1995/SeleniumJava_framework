package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.Base;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends Base {

	
	// Page Factory -- OR
	@FindBy(xpath="//input[@name='email']")
     WebElement username;
	
	@FindBy(xpath="//input[@type='password']")
	 WebElement password;
	
	@FindBy(xpath="//div[text()='Login']")
	WebElement loginBtn;
	
	@FindBy(xpath="//a[text(),'Sign Up']")
	WebElement signUpBtn;
	
	//initializing the Page Objects
	public LoginPage() 
    {
		PageFactory.initElements(driver,this);
	}
	
	 
	// Actions
	public String validateLoginPageTitle()
	{
		return driver.getTitle();
	}
	
	public void loginWithUserNameAndPassword(String un, String pwd) 
	{
		getWebDriverWait(3000).until(ExpectedConditions.visibilityOf(username));
		getWebDriverWait(3000).until(ExpectedConditions.visibilityOf(password));
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		
	}
	
	public HomePage doLogin() {
		loginWithUserNameAndPassword(prop.getProperty("username"),prop.getProperty("password"));
		return new HomePage();
		
	}
	
	
}

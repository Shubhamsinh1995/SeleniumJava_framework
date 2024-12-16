package com.crm.qa.base;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    private static WebDriver driver;
    private static Properties prop;
	private static Base base;

	public BaseTest()
	{
	}

	@BeforeMethod(alwaysRun=true)
	public void setup() {
		base = new Base();
        prop = base.initProperties();
        driver = base.initBrowser();
	}

	@AfterMethod(alwaysRun=true)
	public void tearDown() {
		driver.quit();
	}

}

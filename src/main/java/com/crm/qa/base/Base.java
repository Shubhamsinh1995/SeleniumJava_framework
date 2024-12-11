package com.crm.qa.base;

import com.crm.qa.util.TestUtil;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Base64;
import java.util.Properties;

public class Base {

    public static WebDriver driver;
    public static Properties prop;

    public WebDriver initBrowser() {
        String browsername = prop.getProperty("browser").trim();

        System.out.println("Browser name is: "+browsername);

        if(browsername.equals("Chrome"))
        {
            //WebDriverManager.chromedriver().setup(); // using selenium version 4.xx.x
            //System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Drivers\\chromedriver.exe");
            driver= new ChromeDriver();
        }
        if(browsername.equals("Firefox"))
        {
            driver= new FirefoxDriver();
        }
        if(browsername.equals("edge"))
        {
            driver= new EdgeDriver();
        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        //deleteBrowserCache();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.PAGE_LOAD_TIME_OUT));

        driver.get(prop.getProperty("url"));
        return driver;
    }


    public Properties initProperties() {
        try {
            prop=new Properties();
            FileInputStream ip=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
            prop.load(ip);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }

    public static String takeScreenshot() {
        // Define the path where the screenshot will be saved
        String path = System.getProperty("user.dir") + "/screenShots/" + System.currentTimeMillis() + ".png";

        // Take the screenshot using Selenium
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        try {
            // Save the screenshot to the specified path
            FileHandler.copy(srcFile, new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Convert the screenshot to a byte array for Base64 encoding
        byte[] buffer = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

        // Convert the byte array to a Base64 encoded string
        String base64Path = Base64.getEncoder().encodeToString(buffer);

        return base64Path;
    }

    public static void deleteBrowserCache(){
        try {
            Runtime.getRuntime().exec("RunDll32.exe InetCpl.cpl,ClearMyTracksByProcess 255");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public WebDriverWait getWebDriverWait(long timeOutInSeconds) {
        return ((WebDriverWait)new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds)).ignoring(NoSuchElementException.class, StaleElementReferenceException.class));
    }

    public WebDriver getDriver(){
        return driver;
    }



}

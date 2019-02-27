package com.qa.TestNG.com.qa.TestNG;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FreeCRMLoginTest {
	WebDriver driver;
	
	@BeforeTest
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver", "Driver/chromedriver.exe");
	}
	
	@BeforeMethod
	public void getURL()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
		driver.get("https://classic.crmpro.com/index.html");
	}
	
	@Test(priority=2,dependsOnMethods="validateloginpagetitle")
	public void login() throws InterruptedException
	{
		WebElement username=driver.findElement(By.name("username"));
		WebElement password=driver.findElement(By.name("password"));
		WebElement loginbtn=driver.findElement(By.xpath("//input[@value='Login']"));
		username.clear();
		username.sendKeys("naveenautomation");
		password.clear();
		password.sendKeys("test@123");
		Thread.sleep(5000);
		loginbtn.click();
	    driver.switchTo().frame("mainpanel");
		WebElement logoutbtn=driver.findElement(By.xpath("/html[1]/body[1]/table[1]/tbody[1]/tr[2]/td[1]/div[1]/table[1]/tbody[1]/tr[1]/td[4]/a[1]"));
		logoutbtn.click();
	}
	
	
	@Test(priority=1,invocationCount=1)
	//Invocation count is used to run the test cases multiple times,primarily used to create or dump the test data to sheet or somewhere else.
	public void validateloginpagetitle()
	{
		String title=driver.getTitle();	
		Assert.assertEquals("CRMPRO - CRM software for customer relationship management, sales, and support.", title);
	
	}
	
	//Difference between driver.quit(),driver.close() and driver.dispose()
	//Driver.Close()Close the browser window that the driver has focus of but the 
	//driver instance still remain in memory and can be used to handle other open browser windows.
	//Driver.Quit() - Calls Dispose(),it is used to shut down the web driver instance or destroy the web driver instance(Close all the windows).
	//Driver.Dispose() Closes all browser windows and safely ends the session.
	//You should use driver.quit whenever you want to end the program. It will close all opened browser windows and terminates the WebDriver session. If you do not use driver.quit at the end of the program, the WebDriver 
	//session will not close properly and files would not be cleared from memory. This may result in memory leak errors.
	
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
	
	
	
	
	

	
	
	
}

package com.qa.TestNG.com.qa.TestNG;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DynamicXpaths {
	WebDriver driver;
	
	@BeforeMethod
	
	public void setup()
	{
	System.setProperty("webdriver.chrome.driver", "Driver/chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
    driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
	driver.get("https://classic.crmpro.com/index.html");
	}
	
	@Test(retryAnalyzer= Analyzer.RetryAnalyzer.class)
	public void contacts() throws InterruptedException
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
		WebElement contactslink=driver.findElement(By.xpath("//a[text()='Contacts']"));
		contactslink.click();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		List<WebElement> ls=driver.findElements(By.xpath("//a[text()='anu s']//parent::td[@class='datalistrow']//preceding-sibling::td[@class='datalistrow']"));		
		Iterator<WebElement> it=ls.iterator();
		while(it.hasNext())
		{
			WebElement we=it.next();
			we.click();
		}
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}

}

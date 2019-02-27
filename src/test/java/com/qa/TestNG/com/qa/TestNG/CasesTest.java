package com.qa.TestNG.com.qa.TestNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CasesTest {

WebDriver driver;
Actions actionobj;
//If you have @beforeclass but if you haven't used @afterclass,TestNg will throw an error
	
	@BeforeClass
	public void getURL()
	{
		System.setProperty("webdriver.chrome.driver", "Driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
		driver.get("https://classic.crmpro.com/index.html");
	}
	
	@BeforeMethod
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
	}
	
	
	@Test
	
	public void clickCasesTest() throws InterruptedException
	{
		driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	    actionobj=new Actions(driver);
	    driver.switchTo().frame("mainpanel");
	    WebElement tasks=driver.findElement(By.xpath("/html[1]/body[1]/table[1]/tbody[1]/tr[3]/td[1]/div[1]/div[1]/ul[1]/li[6]/a[1]"));  
	    WebElement newtask=driver.findElement(By.xpath("//a[@title='New Task']"));
	    actionobj.moveToElement(tasks).click(newtask).build().perform();
	    Thread.sleep(5000);
	    WebElement taskid=driver.findElement(By.xpath("//input[@id='title']"));
	    Assert.assertTrue(taskid.isDisplayed());
	    WebElement logoutbtn=driver.findElement(By.xpath("//a[contains(text(),'Logout')]"));
		logoutbtn.click();
	}
	

	
	@AfterMethod
	public void logout()
	{
		driver.quit();
	}
	
}

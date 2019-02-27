package com.qa.TestNG.com.qa.TestNG;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Analyzer.MyScreenRecorder;

public class DynamicWebTableHandling {
	
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
	
	@Test
	//Test to check more than one checkboxes from the list of contacts into the contacts form screen.
	public void contacts() throws Exception
	{
		MyScreenRecorder.startRecording("contacts");
		WebElement username=driver.findElement(By.name("username"));
		WebElement password=driver.findElement(By.name("password"));
		WebElement loginbtn=driver.findElement(By.xpath("//input[@value='Login']"));
		username.clear();
		username.sendKeys("naveenautomation");
		password.clear();
		password.sendKeys("test@123");
		Thread.sleep(5000);// it's a hard wait,it will pause your execution,not a good wait.
		loginbtn.click();
		driver.switchTo().frame("mainpanel");
		WebElement contactslink=driver.findElement(By.xpath("//a[text()='Contacts']"));
		contactslink.click();
		
		String before_xpath = "//form[@id='vContactsForm']//tbody//tr[";
		String after_xpath = "]/td[2]//a";
		List<WebElement> ls=driver.findElements(By.xpath("//input[@name='contact_id']"));
		int size=ls.size()-2;
		System.out.println(size);
		for(int i=4; i<=size; i++){
			String name = driver.findElement(By.xpath(before_xpath + i + after_xpath)).getText();
			System.out.println(name);
			if(name.contains("ajit")){ //i=6
				//*[@id='vContactsForm']/table/tbody/tr[6]/td[1]/input
				driver.findElement(By.xpath("//form[@id='vContactsForm']//tbody//tr["+i+"]//td[1]//input")).click();
			}
		}
		Thread.sleep(5000);
		MyScreenRecorder.stopRecording();
		driver.quit();
		
//		String before_Xpath="//form[@id='vContactsForm']//tbody//tr[";
//		String after_Xpath="]//td[2]//a";
//		//form[@id='vContactsForm']//tbody//tr[8]//td[2]
//		//List<WebElement> ls=driver.findElements(By.xpath("//form[@id='vContactsForm']//tbody//tr"));
//		for(int i=4;i<=7;i++)
//		{
//			String name=driver.findElement(By.xpath("before_Xpath + i + after_Xpath")).getText();
//			if(name.contains("anu s"))
//			{
//				driver.findElement(By.xpath("//form[@id='vContactsForm']//tbody//tr["+i+"]//td[1]//input")).click();
//		}
//		
//	  }
	}


}
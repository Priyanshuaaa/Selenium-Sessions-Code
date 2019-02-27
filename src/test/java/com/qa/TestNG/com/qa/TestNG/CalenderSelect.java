package com.qa.TestNG.com.qa.TestNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CalenderSelect {
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
	public void contacts() throws InterruptedException
	{
		WebElement username=driver.findElement(By.name("username"));
		WebElement password=driver.findElement(By.name("password"));
		WebElement loginbtn=driver.findElement(By.xpath("//input[@value='Login']"));
		username.clear();
		username.sendKeys("Priyanshua");
		password.clear();
		password.sendKeys("Chetu@123");
		Thread.sleep(5000);
		loginbtn.click();
		driver.switchTo().frame("mainpanel");
		String date="31-October-2005";
		String datearr[]=date.split("-");
		String dates=datearr[0];
		String month=datearr[1];
		String year=datearr[2];
		WebElement months=driver.findElement(By.xpath("//select[@name='slctMonthss']"));
		Select selectmonth=new Select(months);
		selectmonth.selectByVisibleText(month);
		WebElement years=driver.findElement(By.xpath("//select[@name='slctYear']"));
		Select selectyear=new Select(years);
		selectyear.selectByVisibleText(year);
		//table[@align='center']//td[@align='left']//td[@align='left']//tbody//tbody//tr[2]//td[4]
		//table[@align='center']//td[@align='left']//td[@align='left']
		String before_xpath = "//table[@align='center']//td[@align='left']//td[@align='left']//tbody//tbody//tr[";
		String middle_xpath = "]//td[";
		String after_xpath="]";
		//List<WebElement> ls=driver.findElements(By.xpath("//table[@align='center']//td[@align='left']//td[@align='left']"));
		final int daysvalue=7;
		String daysfinal=null;
		boolean flag=false;
		for(int row=2; row<=daysvalue; row++){
			for(int col=1; col<=7; col++)
			{
				try
				{
			daysfinal= driver.findElement(By.xpath(before_xpath + row + middle_xpath + col + after_xpath)).getText();
				}
			catch(NoSuchElementException e)
			{
				System.out.println("Please enter correct date");
				flag=false;
				break;
			}
			System.out.println(daysfinal);
			if(daysfinal.contains(dates)){ 
				driver.findElement(By.xpath("//table[@align='center']//td[@align='left']//td[@align='left']//tbody//tbody//tr["+row+"]//td["+col+"]")).click();
				flag=true;
				break;
			}
				}
				
			

			if(flag)
			{
				break;
			}
		    
	}
	}
}




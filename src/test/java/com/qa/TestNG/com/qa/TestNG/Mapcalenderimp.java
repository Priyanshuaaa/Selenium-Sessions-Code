package com.qa.TestNG.com.qa.TestNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import Utilities.Hashmapexp;

public class Mapcalenderimp {
//Hash map can be used where the application could have more than 1 role to work on
	/*Customer Login
	 *Add to cart
	 * Checkout
	 * Place Order
	 * logout
	 * Login with admin
	 * Check the orders placed by customers
	 * logout
	
	/*
	 * Use to store the values where the values into a dropdown or list are continously and frequently updating
	 * Examples are dropdowns,date calenders
	 * Can be used to validate the date selected from the date picker controls.
	 */
	
	static WebDriver driver;
	public static void main(String args[]) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "Driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	    driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
		driver.get("https://classic.crmpro.com/index.html");
		WebElement username=driver.findElement(By.name("username"));
		WebElement password=driver.findElement(By.name("password"));
		String usercreden=(String) Hashmapexp.logincredentials().get("Employee");	
		String montharr[]=usercreden.split("-");
		username.clear();
		username.sendKeys(montharr[0]);
		password.clear();
		password.sendKeys(montharr[1]);
		WebElement loginbtn=driver.findElement(By.xpath("//input[@value='Login']"));	
		Thread.sleep(5000);
		loginbtn.click();
		driver.switchTo().frame("mainpanel");
		driver.quit();
	}

}

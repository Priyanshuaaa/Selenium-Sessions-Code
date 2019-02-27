package com.qa.TestNG.com.qa.TestNG;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class LoginPage {
	
	@FindBy(how = How.NAME, using = "username")
    public WebElement username;

	@FindBy(how = How.NAME, using = "password")
	public WebElement password;

	@FindBy(how = How.XPATH, using = "//*[@id=\"loginForm\"]/div/div/inputxvvhvhfhdfkvdfvdgk")
	public WebElement loginbtn;

	@FindBy(how = How.CSS, using = ".navbar-brand > img:nth-child(1)")
	WebElement crmlogo;
	
	public void login(String user,String pass) throws InterruptedException
	{
		username.clear();
		username.sendKeys(user);
		password.clear();
		password.sendKeys(pass);
		Thread.sleep(5000);
		loginbtn.click();
	}
	
	

}

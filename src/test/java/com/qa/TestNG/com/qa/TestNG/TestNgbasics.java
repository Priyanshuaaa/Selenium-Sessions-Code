package com.qa.TestNG.com.qa.TestNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNgbasics {
  /*
   * Sequence would be @BeforeSuite,@Before Test,@Before Class,@Before Method
   * 
   * 
   * 
   */
	//Preconditions Annotations---Starting with @Before
	@BeforeSuite//1.
	public void setup()
	{
		System.out.println("@BeforeSuite----Set Up System Property for Chrome");
	}

	@BeforeTest//2.
	public void launchbrowser()
	{
		System.out.println("BeforeTest----launch browser");
	}

	@BeforeClass//3.
	public void login()
	{
		System.out.println("BeforeClass----login to application");
	}

	@BeforeMethod//4.
	public void enterURL()

	{
		System.out.println("BeforeMethod-----EnterURL");
	}
	
	@Test//1.1
	
	public void googletitletest()

	{
		System.out.println("Google Title Test");
	}
	
	@Test//1.2
	
	public void searchtest()

	{
		System.out.println("goggle tests search");
	}
	
   @Test//1.3
	
	public void logotest()

	{
		System.out.println("Google Logo Test");
	}

	//Preconditions Annotations---Starting with @After
	
	@AfterMethod//6
	public void logout()
	
	{
       System.out.println("AfterMethod---Logout from the application");
	}
	
	@AfterClass//7
	public void closeBrowser()
	{
	System.out.println("AfterClass----Close the Browser");
	}
	
	@AfterTest//8
	public void deleteallcookies()
	{
	System.out.println("AfterTest----Delete All Cookies");
	}
	
	
	@AfterSuite//9
	public void generatetestreport()
	{
		System.out.println("AfterSuite----Generate Test Report");
	}
		

}

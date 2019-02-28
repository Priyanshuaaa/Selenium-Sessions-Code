package com.qa.TestNG.com.qa.TestNG;

import org.testng.annotations.Test;

public class TestNG_InvocationCount {
	@Test(invocationCount=10)
	public void createDataTest(){
		System.out.println("hello");
	}
	

}

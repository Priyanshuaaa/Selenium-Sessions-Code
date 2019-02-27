package com.qa.TestNG.com.qa.TestNG;

import org.testng.annotations.Test;

public class ExpectedExceptions {
	//if you write the exception name in expectedExceptions attribute,it will skip the exception and test got passed.
	@Test(priority=1,expectedExceptions=NumberFormatException.class)
	public void testecpectedexception()
	{
		String number="1000AA";
		int no=Integer.parseInt(number);
		System.out.println(no);
	}

}

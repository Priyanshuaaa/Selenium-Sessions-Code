package com.qa.TestNG.com.qa.TestNG;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PDFReaderTest {
    static WebDriver driver;
	
	@Test
	public void readPDFTest() throws InvalidPasswordException, IOException
	{   //if you scan the content from the scanner in a PDF and then trying parsing it,this code won't work in that case,it won't print anything into the console..
		System.setProperty("webdriver.chrome.driver", "Driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("file:///E:/Ipsidypayment-PYMT/Coding%20Comments%20and%20Guidelines/Git%20and%20BitBucket%20Commit%20Guidelines.pdf");
		driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
		URL url=new URL(driver.getCurrentUrl());
		InputStream is = url.openStream();
        BufferedInputStream fileToParse = new BufferedInputStream(is);
        PDDocument document = null;
        document = PDDocument.load(fileToParse);
        String pdfcontent = new PDFTextStripper().getText(document);
        //System.out.println(pdfcontent);
        Assert.assertTrue(pdfcontent.contains("Branches"));
        Assert.assertTrue(pdfcontent.contains("Eddie branches  to , obtaining amaster eddie_develop"));
        Assert.assertTrue(pdfcontent.contains("provide some code for Eddie"));
        driver.quit();
	}
}



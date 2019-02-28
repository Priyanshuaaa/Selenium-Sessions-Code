package com.qa.TestNG.com.qa.TestNG;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DownloadFile {
	 WebDriver driver;
	    File folder;

	    @BeforeMethod
	    public void setUp() throws Exception {
	        folder = new File(UUID.randomUUID().toString());
	        folder.mkdir();

//	        Firefox
//	        FirefoxProfile profile = new FirefoxProfile();
//	        profile.setPreference("browser.download.dir", folder.getAbsolutePath());
//	        profile.setPreference("browser.download.folderList", 2);
//	        profile.setPreference("browser.helperApps.neverAsk.saveToDisk",
//	                "image/jpeg, application/pdf, application/octet-stream");
//	        profile.setPreference("pdfjs.disabled", true);
//	        driver = new FirefoxDriver(profile);

//	        Chrome
	    	System.setProperty("webdriver.chrome.driver", "Driver/chromedriver.exe");
	        ChromeOptions options = new ChromeOptions();
	        Map<String, Object> prefs = new HashMap<>();
	        prefs.put("profile.default_content_settings.popups", 0);
	        prefs.put("download.default_directory", folder.getAbsolutePath());
	        options.setExperimentalOption("prefs", prefs);
	        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
	        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
	        driver = new ChromeDriver(capabilities);
	    }

	    @AfterMethod
	    public void tearDown() throws Exception {
	        driver.quit();
	        for (File file: folder.listFiles()) {
	            file.delete();
	        }
	        folder.delete();
	    }

	    @Test
	    public void download() throws Exception {
	        driver.get("http://the-internet.herokuapp.com/download");
	        driver.findElement(By.cssSelector(".example a")).click();
	        // Wait 2 seconds to download file
	        Thread.sleep(2000);
	        File[] listOfFiles = folder.listFiles();
	        // Make sure the directory is not empty
	        Assert.assertTrue(listOfFiles.length>0);
	        for (File file : listOfFiles) {
	            // Make sure the downloaded file(s) is(are) not empty
	        	//Assert.assertEquals(file.length(), is(not((long) 0)));
		        Assert.assertTrue(file.length()>0);

	        }
	    }
	    

}

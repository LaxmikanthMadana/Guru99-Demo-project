package com.miniProj.testCases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.PropertyConfigurator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.miniProj.utilities.ReadConfig;

public class baseClass {
	
	ReadConfig rc = new ReadConfig();
	
	public String baseURL = rc.getApplicationURL();
	public String userID = rc.getUserID();
	public String password = rc.getPassword();
	public static WebDriver driver;
	
	public static Logger logger = null;
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br)
	{
		if(br.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", rc.getChromePath());
			driver = new ChromeDriver();	
		}
		else if(br.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", rc.getFirefoxPath());
			driver = new FirefoxDriver();
		}
		else if(br.equals("ie"))
		{
			System.setProperty("webdriver.ie.driver", rc.getIEPath());
			driver = new InternetExplorerDriver();
		}
		driver.get(baseURL);
		
		
		logger = LogManager.getLogger("CitiBank");
	
		PropertyConfigurator.configure("log4j.properties");
	
	}
	
	
	@AfterClass
	public void teardown()
	{
		driver.quit();
	}
	
	public void captureScreenshot(WebDriver driver, String tname) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = 	new File(System.getProperty("user.dir") + "/Screenshots" + tname + ".png");
		//FileUtils.copyFile(source,target);
		org.apache.commons.io.FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
	
	public String randomString()
	{
		String randomtext = RandomStringUtils.randomAlphanumeric(10);
		return randomtext;
	}

	public String randomNumber()
	{
		String randomno10 = RandomStringUtils.randomNumeric(10);
		return randomno10;
	}

	public String randomNumber2()
	{
		String randomno6 = RandomStringUtils.randomNumeric(6);
		return randomno6;
	}
	
}

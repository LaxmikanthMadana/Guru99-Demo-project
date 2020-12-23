package com.miniProj.testCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import java.io.IOException;

import com.miniProj.pageObjects.LoginPage;

public class TC_LoginTestCase_001 extends baseClass {

	
	@Test
	public void loginTest() throws InterruptedException, IOException
	{
		//driver.get(baseURL);
		//logger.info("Browser has been initiated successfully");
		
		LoginPage lp = new LoginPage(driver);
		lp.enterUserName(userID);
		logger.info("User name was entered");
		lp.enterPassword(password);
		logger.info("Password was entered");
		lp.clkButtonLogin();
		logger.info("clicked on Login button");
		Thread.sleep(3000);
		System.out.println(driver.getTitle());
		
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			AssertJUnit.assertTrue(true);
			logger.info("Page title was matched and validation is pass");
		}
		else
		{
			captureScreenshot(driver, "loginTest" );
			AssertJUnit.assertTrue(false);
			logger.info("Page title was not matched and validation is fail");
		}
	}
	
}

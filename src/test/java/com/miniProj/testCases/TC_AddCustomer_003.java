package com.miniProj.testCases;

import java.io.IOException;
import java.time.LocalDate;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.miniProj.pageObjects.AddCustomer;
import com.miniProj.pageObjects.LoginPage;

public class TC_AddCustomer_003 extends baseClass
{
	@Test
	public void addcustomer() throws InterruptedException, IOException
	{
		LoginPage lp = new LoginPage(driver);
		lp.enterUserName(userID);
		lp.enterPassword(password);
		lp.clkButtonLogin();
		driver.manage().window().maximize();
		Thread.sleep(3000);
		
		
		AddCustomer ac = new AddCustomer(driver);
		
		((AddCustomer) ac).clickNewCustomer();
		
		ac.getCustomerName("Raju");
		ac.getRadiobutton("female");
		Thread.sleep(3000);
		//ac.dob("12122000");
		//ac.dob(Keys.TAB);
		ac.DOB("05","MAY","1988");
		//ac.DOB(, dd, yyyy);
		Thread.sleep(3000);
		ac.getAddress("MH A404 Bangalore");
		ac.getCity("Bangalore");
		ac.getState("Karnataka");
		ac.getPin(randomNumber2());
		ac.getPhoneno(randomNumber());
		String email = randomString() + "@gmail.com";
		ac.email(email);
		ac.getPwd("Test@123");
		ac.submit();
		
//		LocalDate df = LocalDate.now().minusMonths(40);
//		ac.DOB(df);
//		
		Thread.sleep(3000);
		
		boolean result = driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if (result == true)
		{
			Assert.assertTrue(true);
		}
		else
		{
			captureScreenshot(driver,"addcustomer");
			Assert.assertTrue(false);
		}
	}
	


}


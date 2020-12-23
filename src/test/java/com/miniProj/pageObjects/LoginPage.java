package com.miniProj.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver localdriver;

	public LoginPage(WebDriver remotedriver) {
		localdriver = remotedriver;
		PageFactory.initElements(remotedriver, this);
	}

	@FindBy(name = "uid")
	WebElement txtUserID;
	
		
	@FindBy(name="password")
	WebElement txtPassword;
	
	@FindBy(name = "btnLogin")
	WebElement btnLogin;
	
	@FindBy(xpath="//a[contains(text(),'Log out')]")
	WebElement btnLogout;
	
	/******************* Action Methods *************/
	
	public void enterUserName(String userId)
	{
		txtUserID.sendKeys(userId);
	}
	
	public void enterPassword(String pwd)
	{
		txtPassword.sendKeys(pwd);
	}
	
	public void clkButtonLogin()
	{
		btnLogin.click();
	}

	public void clkLogout()
	{
		btnLogout.click();
	}
	
}

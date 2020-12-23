package com.miniProj.pageObjects;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class AddCustomer {

	WebDriver localdriver;

	public AddCustomer(WebDriver remotedriver) {   ///created constructor
		localdriver = remotedriver;
		PageFactory.initElements(remotedriver, this);
	}
	
	@FindBy(xpath = "//a[contains(text(),'New Customer')]")
	WebElement newCustomerhyperlink;
	
	@FindBy(xpath = "//input[@name='name']")
	WebElement txtcustomerName;
	
	//List<WebElement> radio = localdriver.findElements(By.name("rad1"));
	@FindBy(name = "rad1")
	WebElement radiobutton;
	
	@FindBy(id = "dob")
	WebElement dobDate;
	
	@FindBy(name="addr")
	WebElement addressTextarea;
	
	@FindBy(name="city")
	WebElement txtCity;

	@FindBy(name="state")
	WebElement txtState;

	@FindBy(name="pinno")
	WebElement txtPIN;

	@FindBy(name="telephoneno")
	WebElement txtPhonenumber;
	
	@FindBy(name="emailid")
	WebElement txtEmailaddress;
	
	@FindBy(xpath ="//input[@type='password']")
	WebElement txtPassword;

	@FindBy(name ="sub")
	WebElement btnSubmit;
	
	@FindBy(name = "res")
	WebElement btnReset;
	
//	public void clickNewCustomer() 
//	{
//		newCustomerhyperlink.click();
//	}
	
	public void getCustomerName(String cName)
	{
		txtcustomerName.sendKeys(cName);
	}
	
	public void getRadiobutton(String gender)
	{
		
		radiobutton.click();
	}
	
	public void DOB(String dd, String mm, String yy)
	{
		dobDate.sendKeys(dd);
		dobDate.sendKeys(mm);
		dobDate.sendKeys(Keys.TAB);
		dobDate.sendKeys(yy);
	}
	
	


	public void getAddress(String addr)
	{
		addressTextarea.sendKeys(addr);
	}
		
	public void getCity(String city)
	{
		txtCity.sendKeys(city);
	}
	
	public void getState(String state)
	{
		txtState.sendKeys(state);
	}
	
	public void getPin(String pin)
	{
		txtPIN.sendKeys(String.valueOf(pin));
	}
	
	public void getPhoneno(String telephone)
	{
		txtPhonenumber.sendKeys(telephone);
	}
	
	public void email(String emailAddress)
	{
		txtEmailaddress.sendKeys(emailAddress);
	}
	
	public void getPwd(String pwd)
	{
		txtPassword.sendKeys(pwd);
	}
	
	public void submit()
	{
		btnSubmit.click();
	}
	
	public void reset()
	{
		btnReset.click();
	}

	public void clickNewCustomer() {
		// TODO Auto-generated method stub
		newCustomerhyperlink.click();
	}

//	public void DOB(LocalDate df) {
//		dobDate.toString();
//		// TODO Auto-generated method stub
//		String.valueOf(df);
//	}
	
	
	
}

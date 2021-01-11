package pages;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import base.Payment_base;

public class UPI extends Payment_base {
	static @FindBy(xpath="//div[@data-id='UPI']") WebElement upi;
	static @FindBy(xpath="//input[@placeholder='Enter UPI ID']") WebElement upiph;
	static @FindBy(xpath="//form[@id='payment_form_upi']/button") WebElement upibt;
	static @FindBy(xpath="//button[@aria-label='Try again']") WebElement close;
	public UPI()
	{
		PageFactory.initElements(driver,this);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	public void selectupi()
	{
		upi.click();
	}
	
	public void enter_no(String str)
	{
		upiph.sendKeys(str);
	}
	
	public void upipay()
	{
		upibt.click();
	}
	
	public void upitransac()
	{
		try {
		String fail=close.getText();
		if(fail.contains("Try"))
		{
			Thread.sleep(2000);
			log=ext.createTest("UPI failed payment");
			log.log(Status.PASS, "Failed Transaction by UPI method");
			takescreenshot("UPI_fail.png");
		}
		else
		{
			Thread.sleep(2000);
			log=ext.createTest("UPI successful payment");
			log.log(Status.FAIL, "Sucessful Transaction by UPI method");
			takescreenshot("UPI_success.png");
		}
		}catch(Exception e) {}
		close.click();
	}
	
}

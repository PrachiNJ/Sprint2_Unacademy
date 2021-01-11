package pages;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import base.Payment_base;

public class Wallet extends Payment_base{
	
	static @FindBy(xpath="//div[@data-id='WALLETS']") WebElement wallet;
	static @FindBy(xpath="//div/h6[text()='Olamoney']") WebElement ola;
	static @FindBy(xpath="//form[@id='payment_form_wallets']/button") WebElement walpay;
	static @FindBy(xpath="//input[@type='number']") WebElement number;
	static @FindBy(xpath="//button[@aria-label='Try again']") WebElement close;
	
	public Wallet()
	{
		PageFactory.initElements(driver,this);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	public void selectwall()
	{
		new Actions(driver).moveToElement(wallet).perform();
		wallet.click();
	}
	
	public void choosewal(String x) throws Exception
	{
		ola.click();
		number.clear();
		number.sendKeys(x);
	}
	
	
	public void wallet_pay()
	{
		new Actions(driver).moveToElement(walpay).perform();
		walpay.click();
	}
	
	public void waltransac()
	{
		try {
		String fail=close.getText();
		if(fail.contains("Try"))
		{
			log=ext.createTest("Wallet failed payment");
			log.log(Status.PASS, "Failed Transaction by Wallet method");
			takescreenshot("Wallet_fail.png");
		}
		else
		{
			log=ext.createTest("Wallet successful payment");
			log.log(Status.FAIL, "Sucessful Transaction by Wallet method");
			takescreenshot("Wallet_success.png");
		}
		}catch(Exception e) {}
		close.click();
	}

}

package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import base.Payment_base;

public class Netbanking extends Payment_base {
	
	static @FindBy(xpath="//div[@data-id='NET_BANKING']") WebElement net;
	static @FindBy(xpath="//form[@id='payment_form_nb']/div/div[3]") WebElement nethdfc;
	static @FindBy(xpath="//form[@id='payment_form_nb']/button") WebElement netpay;
	
	public Netbanking()
	{
		PageFactory.initElements(driver,this);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	public void selectnet()
	{
		net.click();
	}
	
	public void selectbank()
	{
		nethdfc.click();
	}
	
	public void netbanking_pay()
	{
		new Actions(driver).moveToElement(netpay).perform();
		netpay.click();
	}
	
	public void nettransac() throws Exception
	{
		Thread.sleep(5000);
		String nettitle=driver.getTitle();
		if(nettitle.contains("HDFC"))
		{
			log=ext.createTest("Netbanking Bank_Page");
			log.log(Status.PASS, "Bank Page opened Sucessfully");
			takescreenshot("Netbanking_Bank.png");
		}
		else
		{
			log=ext.createTest(" Netbanking Bank_Page");
			log.log(Status.FAIL, "Bank Page did not open Sucessfully");
			takescreenshot("Netbanking_Bank.png");
		}
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.history.go(-1)");
	}
	
}

package pages;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import base.Payment_base;

public class Login extends Payment_base {
	
	static @FindBy(xpath="//input[@placeholder='Enter your mobile number']") WebElement w1;
	static @FindBy(xpath="//button[@aria-label='Login']") WebElement w2;
	static @FindBy(xpath="//input[@placeholder='One time password']") WebElement w3;
	static @FindBy(xpath="//button[@aria-label='Verify OTP']") WebElement w4;
	static @FindBy(xpath="//button[@data-analytics='goal-getSubscription']") WebElement subbutton;
	static @FindBy(xpath="//button[@aria-label='Proceed to pay']") WebElement pro;
	static @FindBy(xpath="//div/h6[text()='Change duration']") WebElement duration;
	
	public Login()
	{
		PageFactory.initElements(driver,this);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	public void openurl()
	{
		driver.get(prop.getProperty("url"));
	}
	
	public void subscription()
	{
		subbutton.click();
		pro.click();
	}
	
	public void signin()
	{
		w1.sendKeys("9987467156");
		w2.click();
		Scanner sc=new Scanner(System.in);
		String s= sc.nextLine();
		w3.sendKeys(s);
		w4.click();
	}
	
	public void changeduration() throws Exception
	{
		Thread.sleep(5000);
		duration.click();
	}
	
	public void backtopayment() throws Exception
	{
		Thread.sleep(5000);
		try {
			String l=pro.getText();
			if(l.contains("Proceed to pay"))
			{
				log=ext.createTest("Subscription plans page");
				log.log(Status.PASS, "Subscription plan page is displayed");
				takescreenshot("Plans.png");
			}
			else
			{
				log=ext.createTest("Subscription plan page");
				log.log(Status.FAIL, "Subscription plan page is not displayed");
				takescreenshot("Plans.png");
			}
			}catch(Exception e) {}
		pro.click();
	}
}

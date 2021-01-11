package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import base.Payment_base;

public class Card extends Payment_base{
	
	static @FindBy(xpath="//div[@data-id='CARD']") WebElement card;
	static @FindBy(name="card_number") WebElement c1;
	static @FindBy(name="card_exp_month") WebElement c2;
	static @FindBy(name="card_exp_year") WebElement c3;
	static @FindBy(name="security_code") WebElement c4;
	static @FindBy(name="name_on_card") WebElement c5;
	static @FindBy(xpath="//form[@id='payment_form_new_card']/button") WebElement c6;
	static @FindBy(xpath="//button[@aria-label='Try again']") WebElement close;
	
	public Card()
	{
		PageFactory.initElements(driver,this);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	public void selectcard()
	{
		card.click();
	}
	
	public void entervalues(String arg1, String arg2, String arg3, String arg4, String arg5)
	{
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='card_number_iframe']")));
		c1.sendKeys(arg1);
		driver.switchTo().defaultContent();
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='card_exp_month_iframe']")));
		c2.sendKeys(arg2);
		driver.switchTo().defaultContent();
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='card_exp_year_iframe']")));
		c3.sendKeys(arg3);
		driver.switchTo().defaultContent();
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='security_code_iframe']")));
		c4.sendKeys(arg4);
		driver.switchTo().defaultContent();
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='name_on_card_iframe']")));
		c5.sendKeys(arg5);
		driver.switchTo().defaultContent();
	}
	
	public void card_pay()
	{
		new Actions(driver).moveToElement(c6).perform();
		c6.click();
	}
	
	public void cardtransac()
	{
		try {
		String fail=close.getText();
		if(fail.contains("Try"))
		{
			Thread.sleep(2000);
			log=ext.createTest("Card failed payment");
			log.log(Status.PASS, "Failed Transaction by Card method");
			takescreenshot("Card_fail.png");
		}
		else
		{
			Thread.sleep(2000);
			log=ext.createTest("Card successful payment");
			log.log(Status.FAIL, "Sucessful Transaction by Card method");
			takescreenshot("Card_success.png");
		}
		}catch(Exception e) {}
		close.click();
	}
}

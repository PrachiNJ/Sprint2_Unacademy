package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import base.Unacdemysub_base;

public class Un_Startlearning extends Unacdemysub_base
{
        @FindBy(xpath="//button[text()='Start learning']") WebElement startlearning;
       // @FindBy(xpath="/html/body/div/div[1]/div/div[1]/ul/li[4]/a/h4") WebElement exammodule;
       // @FindBy(xpath="//p[text()='2.9k courses']") WebElement course;
        
      
        public void openurl()
    	{
        	PageFactory.initElements(driver,this);
    		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        	driver.get(prop.getProperty("url"));	
    	}
    	public void validate_button() throws Exception
    	{
    		Thread.sleep(5000);
    		if(startlearning.isDisplayed())
    		{
    			log=ext.createTest("StartLearning_Button");
    			log.log(Status.PASS, "Button is Displayed");
    			takescreenshot("StartLearning.png");
    			startlearning.click();
    		}
    		else
    		{
    			log=ext.createTest("StartLearning_Button");
    			log.log(Status.FAIL, "Button is not Displayed");
    			takescreenshot("StartLearning.png");
    		}
    		
    	}
    	public void exam_module() throws Exception
    	{

    		Thread.sleep(5000);
    		String title=driver.getTitle();
    		if(title.contains("Goals | Unacademy"))
    		{
    			log=ext.createTest("Exam_Modules");
    			log.log(Status.PASS, "Exam Module Page is Displayed");
    			takescreenshot("Exam_Modules.png");	
    		}
    		else
    		{
    			log=ext.createTest("Exam_Modules");
    			log.log(Status.PASS, "Exam Module Page is not Displayed");
    			takescreenshot("Exam_Modules.png");
    		}
    	}
    	public void select_exammodule() throws Exception
    	{
    		 WebElement e=driver.findElement(By.xpath("//ul/li[4]/a"));
     		e.click();
     		Thread.sleep(2000);
    	}
    	public void courses_offered() throws Exception
    	{
    		WebElement c=driver.findElement(By.xpath("(//div/div/p)[15]"));
    		c.click();
    		Thread.sleep(5000);
    	}
    	public void display_subscriptionpage() throws Exception
    	{
    		String title1=driver.getTitle();
    		if(title1.contains("CDS/AFCAT/CAPF | Unacademy"))
    		{
    			log=ext.createTest("Subscription_Page");
    			log.log(Status.PASS, "Subscription Page is Displayed");
    			takescreenshot("Subscription_Page.png");	
    		}
    		else
    		{
    			log=ext.createTest("Subscription_Page");
    			log.log(Status.PASS, "Subscription Page is not Displayed");
    			takescreenshot("Subscription_Page");
    		}
    	}
    	
}

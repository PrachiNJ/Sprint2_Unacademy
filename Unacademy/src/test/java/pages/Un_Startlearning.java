package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import base.Unacdemysub_base;

public class Un_Startlearning extends Unacdemysub_base
{
        @FindBy(xpath="//button[text()='Start learning']") WebElement startlearning;
        @FindBy(xpath="//p[text()='Defense Exams']") WebElement exammodule;
        @FindBy(xpath="//p[text()='2.9k courses']") WebElement course;
        
       /* public Un_Startlearning()
        {
        	PageFactory.initElements(driver,this);
    		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        }*/
        
        public void openurl()
    	{
        	PageFactory.initElements(driver,this);
    		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        	driver.get(prop.getProperty("url"));
    		
    	}
    	public void validate_button() throws Exception
    	{
    		Thread.sleep(5000);
    		//String title=driver.get();
    		//if(title.contains("Online Shopping"))
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
    			exammodule.click();
    		}
    		else
    		{
    			log=ext.createTest("Exam_Modules");
    			log.log(Status.PASS, "Exam Module Page is not Displayed");
    			takescreenshot("Exam_Modules.png");
    		}
    	}
        
}

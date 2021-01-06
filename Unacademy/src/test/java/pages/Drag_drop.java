package pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Drag_drop {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		 ChromeDriver d1=new ChromeDriver();    
	        d1.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			d1.manage().window().maximize();
			d1.get("http://www.jqueryui.com/droppable/");
			d1.switchTo().frame(d1.findElementByXPath("//iframe[@class='demo-frame']"));
			WebElement w1=d1.findElement(By.id("draggable"));
			WebElement w2=d1.findElement(By.id("droppable"));
			new Actions(d1).dragAndDrop(w1,w2).perform();
			
			
			d1.switchTo().defaultContent();//switch back to main window
            d1.findElement(By.linkText("Selectable")).click();
                      
            JavascriptExecutor js=d1;    //javascript obj is assigned with browser obj..
            js.executeScript("window.scrollTo(0,300)");   //scrollTo(Horizontal scroll bar,vert scrl bar)..moves vrt scrlbar 300px down
            
            d1.switchTo().frame(d1.findElement(By.xpath("//iframe[@class='demo-frame']")));
            
            
            Thread.sleep(2000);
            
            WebElement ollist=d1.findElement(By.id("selectable"));
            List<WebElement> lst=  ollist.findElements(By.tagName("li"));
            new Actions(d1)
                 .keyDown(ollist,Keys.CONTROL)
                 .click(lst.get(1))
                 .click(lst.get(3))
                  .click(lst.get(5))
                  .keyUp(ollist,Keys.CONTROL)
                  .perform();
            
            
	}

}

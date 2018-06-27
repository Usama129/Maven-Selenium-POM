package PagesPackage;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.openqa.selenium.WebElement;

public class ResultsPage extends BasePage {
	
	//Constructor
    public ResultsPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    
    //Methods
    public void page3() throws InterruptedException {
    	Thread.sleep(900);
    	click(By.xpath("//*[@id=\"pagn\"]/span[4]/a"));
    }
    
    public void v7thResult(String str2, String str3, String str4) throws InterruptedException {
		Thread.sleep(4000);
		
		boolean a = false, b = false, c = false, d = false;
		String str1;
		
		List<WebElement> firstSeven = driver.findElements(By.xpath("//li[starts-with(@id,'result')]/div/div[2]/div/div[2]/div[1]/div[1]/a/h2"));
		
		for ( WebElement we: firstSeven) { 
	             str1 = we.getText();
	             if(str1.toLowerCase().contains(str2.toLowerCase()))
	     			b = true;
	     		 if(str1.toLowerCase().contains(str3.toLowerCase()))
	     			c = true;
	     		 if(str1.toLowerCase().contains(str4.toLowerCase()))
	     			d = true;
	     		
	     		 if(b == true || c == true || d == true)
	     			a = true;
	     			
	     		 Assert.assertTrue(a);
	    }
	}
}

package PagesPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;

public class GetAnEmail extends BasePage {

	//Constructor
    public GetAnEmail(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    
    //Input
    String baseURL = "http://qamail.ala.se/";
    
    
    //Method
    public String getEmail() throws InterruptedException {
    	driver.get(baseURL);
    	Thread.sleep(2500);
    	click(By.xpath("//*[@id=\"top-menu\"]/div/div[3]/button[1]"));
    	Thread.sleep(500);
    	WebElement eText = driver.findElement(By.id("current_mailbox_address"));
    	return ((eText).getText());
    }
    
}

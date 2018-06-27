package PagesPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HomePage extends BasePage {
	 
    //Constructor
    public HomePage (WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
 
    //Input and Navigation
    String baseURL = "https://www.amazon.com/ ";
    Actions builder = new Actions(driver);
 
    //Methods
    public void goToAmazon (){
        driver.get(baseURL);
    }
 
    public void goToSignUpPage (){
    	//Actions builder = new Actions(driver);
    	//WebElement we = driver.findElement(By.linkText("Start here."));
    	//builder.moveToElement(we).perform();
    	//By locator = By.linkText("Start here.");
    	//driver.click(locator);
    	WebElement na = driver.findElement(By.xpath("//*[@id=\"nav-link-accountList\"]"));
    	builder.moveToElement(na).perform();
        click(By.xpath("//*[@id=\"nav-flyout-ya-newCust\"]/a")); 
    }
}
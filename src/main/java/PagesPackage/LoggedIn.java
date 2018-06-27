package PagesPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class LoggedIn extends BasePage {
	
	//Constructor
    public LoggedIn(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    
    //Input and Navigation
    Actions builder = new Actions(driver);
    
    //Methods
    public void createAList(String listName) throws InterruptedException {
    	WebElement we = driver.findElement(By.id("nav-link-accountList"));
    	builder.moveToElement(we).perform();
    	//men_menu = driver.find_element_by_css_selector("li[data-nav-tracking=men]")
        //actions.move_to_element(men_menu).perform()
    	click(By.xpath("//*[@id=\"nav-al-wishlist\"]/a[1]/span"));
    	Thread.sleep(1000);
    	click(By.id("createList-announce"));
    	Thread.sleep(2500);
    	click(By.xpath("//*[@id=\"WLNEW_section_wlType\"]/div[2]/div[1]/div/div/span/div/label/i"));
    	click(By.xpath("//*[@id=\"WLNEW_privacy_public\"]/span/input"));
    	Thread.sleep(1500);
    	writeText(By.id("WLNEW_list_name"), listName);
    	Thread.sleep(1500);
    	click(By.xpath("//*[@id=\"a-popover-content-3\"]/form/div[2]/span[3]/span/span/input"));	
    }
    
    //Assertion
    public void verifyListCreated(String text) throws InterruptedException {
    	Thread.sleep(4000);
    	Assert.assertEquals(readText(By.xpath("//*[@id=\"wfaLink\"]/span/a")), text);
    }
}

package PagesPackage;

//import java.awt.Desktop.Action;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;



public class WiListManage extends BasePage{

	//Constructor
    public WiListManage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    
    Actions builder = new Actions(driver);
    
    //Methods
    public void moveToWiList() throws InterruptedException {
    	Thread.sleep(4000);
    	click(By.xpath("//*[contains(text(), 'Shopping List for automation testing')]"));
    	WebElement wl = driver.findElement(By.xpath("/HTML[1]/BODY[1]/DIV[1]/DIV[3]/DIV[1]/DIV[1]/DIV[1]/DIV[1]/DIV[1]/DIV[2]/DIV[4]/DIV[3]/DIV[1]/UL[1]/LI[1]/SPAN[1]/DIV[1]/DIV[1]/DIV[2]/DIV[3]/DIV[1]/DIV[2]/DIV[1]/DIV[1]/DIV[1]/DIV[1]/SPAN[1]/SPAN[1]/SPAN[1]/SPAN[1]"));
    	//Thread.sleep(800);
    	wl.click();
    	builder.sendKeys(Keys.DOWN)
    		.sendKeys(Keys.RETURN)
    		.sendKeys(Keys.RETURN);
    	org.openqa.selenium.interactions.Action selectMultiple = builder.build();
    	Thread.sleep(800);
    	selectMultiple.perform();
    	//wl.sendKeys(Keys.DOWN);
    	//Thread.sleep(10000);
    	
    	//wl.sendKeys(Keys.RETURN);
    	//Thread.sleep(1000);
    	//click(By.xpath("//*[contains(text(), 'Wish List')]"));
    }
    
    public void openWishList() throws InterruptedException {
    	Thread.sleep(1000);
    	click(By.linkText("Wish List"));
    }
    
    public void delete1stItem() throws InterruptedException {
    	Thread.sleep(750);
    	click(By.name("submit.deleteItem"));
    }
    
    //Assertion
    public void verifyDeletedIdea(String conf) throws InterruptedException {
    	Thread.sleep(900);
    	String actualString = driver.findElement(By.xpath("//*[@id=\"content-right\"]")).getText();
    	Assert.assertTrue(actualString.contains(conf));
    }
}

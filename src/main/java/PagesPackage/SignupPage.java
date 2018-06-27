package PagesPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

//import TestsPackage.BaseTest;
//import TestsPackage.TestInstantiation;

public class SignupPage extends BasePage {
	//Constructor
	public SignupPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
  
  //Input
    String name = "Usama Humayun";
    //public String email = TestInstantiation.email;
    String password = "amzntstng";
    
  //Page Methods
    public void createAccount (String email) throws InterruptedException{
        writeText(By.xpath("//label[contains(.,'Your name')]/following::input[1]"), name);
        writeText(By.xpath("//label[contains(.,'Email')]/following::input[1]"), email);
        writeText(By.xpath("//label[contains(.,'Password')]/following::input[1]"), password);
        writeText(By.xpath("//label[contains(.,'Re-enter password')]/following::input[1]"), password);
        Thread.sleep(1000);
        click(By.id("continue"));
        //click(By.xpath("//input[@value=\"Create your Amazon account\"]"));
    }
    
    
    //Assertion
    public void verifyLogin(String text) throws InterruptedException {
    	Thread.sleep(700);
    	Assert.assertEquals(readText(By.xpath("//*[@id=\"nav-link-accountList\"]/span[1]")), text);
    }
}

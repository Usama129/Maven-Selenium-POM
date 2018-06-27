package TestsPackage;

//import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
	public WebDriver driver;
    public WebDriverWait wait;
    //Scanner inp = new Scanner(System.in);
	//public static String InputEmail;
    
    @BeforeClass
    public void setup () {
	    //System.out.println("Enter Email that will be used to create Amazon account: ");
	    //TestInstantiation.email = inp.next();
	    
        //Creating a web driver object
    	System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
        driver = new ChromeDriver();
        String baseUrl = "https://www.google.com";
        driver.get(baseUrl);
 
        //Creating a wait object
        wait = new WebDriverWait(driver,30);
 
        //Maximize the window
        driver.manage().window().maximize();
    }
 
    @AfterClass
    public void teardown () {
        driver.quit();
    }
}

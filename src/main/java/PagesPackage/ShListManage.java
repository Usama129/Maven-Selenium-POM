package PagesPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ShListManage extends BasePage{
	
	//Constructor
    public ShListManage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    
    //Methods
	public void addIdea(String idea, boolean click) throws InterruptedException {
		if (click == true)
			click(By.partialLinkText("Add Idea to List"));
		click(By.id("wfaTextInput"));
		writeText(By.id("wfaTextInput"), idea);
		Thread.sleep(500);
		click(By.id("wfa-note-add-button"));
	}
	
	//Assertion
	public void verifyAddedIdea(String idea) throws InterruptedException {
		Thread.sleep(3500);
		String actualString = driver.findElement(By.xpath("//*[@id=\"content-right\"]")).getText();
		Assert.assertTrue(actualString.contains(idea));		//verifies name of the idea
		Assert.assertEquals(readText(By.className("itemWfaBadgeText")), "Added as an idea");	//verifies that the name of the idea is found IN the list
	}
	
	public void openShoppingList() throws InterruptedException {
		Thread.sleep(1000);
		click(By.xpath("/HTML[1]/BODY[1]/DIV[1]/DIV[3]/DIV[1]/DIV[1]/DIV[1]/DIV[1]/DIV[1]/DIV[1]/DIV[1]/NAV[1]/UL[1]/LI[1]/SPAN[1]/A[1]/DIV[1]/DIV[1]/DIV[1]/DIV[1]"));
	}
	
	public void topSearchResults() throws InterruptedException {
		Thread.sleep(600);
		click(By.xpath("/HTML[1]/BODY[1]/DIV[1]/DIV[3]/DIV[1]/DIV[1]/DIV[1]/DIV[1]/DIV[1]/DIV[2]/DIV[4]/DIV[3]/DIV[1]/UL[1]/LI[1]/SPAN[1]/DIV[1]/DIV[1]/DIV[2]/DIV[3]/DIV[1]/DIV[2]/DIV[1]/SPAN[1]/SPAN[1]/SPAN[1]"));
	}
	
}


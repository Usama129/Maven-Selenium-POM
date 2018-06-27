package TestsPackage;

import org.testng.annotations.Test;

import PagesPackage.GetAnEmail;
import PagesPackage.HomePage;
import PagesPackage.ShListManage;
import PagesPackage.LoggedIn;
import PagesPackage.ResultsPage;
import PagesPackage.SignupPage;
import PagesPackage.WiListManage;

public class TestInstantiation extends BaseTest {
	 
    // In @BeforeClass driver and wait variables were declared
    // These variables are sent to each page class with the Page Object Instantiations in the testInstance() method 
    // The super() method in the page classes sends the driver and wait variables values to the BasePage class. 
 
	//String for Email
    public static String email;
	
    @Test (priority = 0)
    public void testInstance () throws InterruptedException {
        
        //Page Object Instantiations
        HomePage homePage = new HomePage(driver, wait);
        SignupPage snupPage = new SignupPage(driver, wait);
        LoggedIn loggedIn = new LoggedIn(driver, wait);
        ShListManage SlistManage = new ShListManage(driver, wait);
        WiListManage WlistManage = new WiListManage(driver, wait);
        ResultsPage rPage = new ResultsPage(driver, wait);
        GetAnEmail gEmail = new GetAnEmail(driver, wait);
        
        
        
        
        //Methods
        
        //Go to qamail.ala.se to get an Email
        email = gEmail.getEmail();
        
        //Open Amazon HomePage
        homePage.goToAmazon();
 
        //Go to Sign Up Page
        homePage.goToSignUpPage();
        
        //Create Account with obtained Email
        snupPage.createAccount(email);
 
        //Assert that Login is successful with created account (Amazon logs in automatically after account creation)
        snupPage.verifyLogin("Hello, Usama");
        
        //Create a List
        loggedIn.createAList(" for automation testing");
        
        //Assert that Shopping List is created
        loggedIn.verifyListCreated("+ Add Idea to List");
        
        //Add Amazon Kindle to Shopping List
        SlistManage.addIdea("Amazon Kindle", true);
        
        //Assert that Amazon Kindle is added to List
        SlistManage.verifyAddedIdea("Amazon Kindle");
        
        //Add iPhone 8 to Shopping List
        SlistManage.addIdea("iPhone 8", false);
        
        //Move iPhone 8 to Wish List
        WlistManage.moveToWiList(); //Clicking first appearance of Move button in DOM (New items appear at the top in Shopping List)
        
        //Open Wish List
        WlistManage.openWishList();
        
        //Assert that iPhone 8 is moved to Wish List
        SlistManage.verifyAddedIdea("iPhone 8");
        
        //Delete iPhone 8 from Wish List
        WlistManage.delete1stItem();
        
        //Assert that iPhone 8 is deleted from Wish List
        WlistManage.verifyDeletedIdea("Deleted");
        
        //Return to Shopping List
        SlistManage.openShoppingList();
        
        //Open top search results for Amazon Kindle
        SlistManage.topSearchResults();
        
        //Go to Page 3 of search results
        rPage.page3();
        
        //Assert that the first seven search results contains "Amazon" or "Kindle" or "Fire" (Some search results bring up Amazon Fire instead of Kindle)
        Thread.sleep(3000);
        rPage.v7thResult("Amazon", "Kindle", "Fire");
    }
 
}

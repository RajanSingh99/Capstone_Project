package automationExercise.testCases;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import automationExercise.base.BaseConfigurations;
import automationExercise.pageObjects.AccountCreatedPage;
import automationExercise.pageObjects.AccountDeleted;
import automationExercise.pageObjects.AddedPopUp;
import automationExercise.pageObjects.CartPage;
import automationExercise.pageObjects.HomePage;
import automationExercise.pageObjects.LoginPage;
import automationExercise.pageObjects.ProductDetailsPage;
import automationExercise.pageObjects.ProductsPage;
import automationExercise.pageObjects.SignUpPage;
import config.ConfigProperties;
import extra.AddRemover;

public class TestCase2 extends BaseConfigurations {
	
	AccountCreatedPage accntCreatedObj;
	AccountDeleted     accntDelObj;
	AddedPopUp         addedPopObj;
	CartPage           cartObj;
	HomePage           homeObj;
	LoginPage          LoginObj;
	ProductDetailsPage ProductDetailsObj;
	ProductsPage       ProductsObj;
	SignUpPage         SignUpObj;
	AddRemover         adRmvObj;
	WebDriver          driver;
	String             port;
	
	@Parameters({"Port"})
	@BeforeClass
	public void initialSetup(String Port) throws MalformedURLException{
		ConfigProperties.initializePropertyFile();
		port=Port;
		driver=setUp(Port);
		accntCreatedObj = new AccountCreatedPage(driver);
		accntDelObj = new AccountDeleted(driver);
		addedPopObj = new AddedPopUp(driver);
		cartObj = new CartPage(driver);
		homeObj = new HomePage(driver);
		LoginObj = new LoginPage(driver);
		ProductDetailsObj = new ProductDetailsPage(driver);
		ProductsObj = new ProductsPage (driver);
		SignUpObj = new SignUpPage (driver);
	}
	
	@BeforeMethod
	public void createAcct() throws InterruptedException {
		homeObj.signupLoginLink.click();
		LoginObj.newUserSignUpConstant(port);
		SignUpObj.fillAccountInformation();
		accntCreatedObj.verifyAccountCreated();
		homeObj.logoutBtn.click();
		Thread.sleep(1000);
		homeObj.orangeHome.click();
	}
	
	@Test
    public void scenarioTc2() throws InterruptedException {
    	homeObj.verifyHome();
    	homeObj.signUpLoginClick();
    	LoginObj.fillLoginDetails("email",port);
    	homeObj.verifyUsername();
    	homeObj.delAccnt();
    	accntDelObj.verifyAcctDel();
    	driver.quit();
    }
}

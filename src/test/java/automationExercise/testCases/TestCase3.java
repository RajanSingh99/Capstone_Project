package automationExercise.testCases;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
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
import utils.AddRemover;

public class TestCase3 extends BaseConfigurations {

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
	
	@Parameters({"Port"})
	@BeforeClass
	public void initialSetup(String Port) throws MalformedURLException{
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
	
	@Test
	public void scenarioTc3() {
		homeObj.verifyHome();
		homeObj.signupLoginLink.click();
		LoginObj.fillWrongDetails();
		LoginObj.verifyError();
		driver.quit();
	}
	
}

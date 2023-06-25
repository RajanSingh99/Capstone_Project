package automationExercise.testCases;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import automationExercise.base.BaseConfigurations;
import automationExercise.pageObjects.AccountCreatedPage;
import automationExercise.pageObjects.AccountDeleted;
import automationExercise.pageObjects.CartPage;
import automationExercise.pageObjects.HomePage;
import automationExercise.pageObjects.LoginPage;
import automationExercise.pageObjects.ProductDetailsPage;
import automationExercise.pageObjects.ProductsPage;
import automationExercise.pageObjects.SignUpPage;
import config.ConfigProperties;
import utils.AddRemover;

public class TestCase6 extends BaseConfigurations {
	AccountCreatedPage accntCreatedObj;
	AccountDeleted     accntDelObj;
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
		cartObj = new CartPage(driver);
		homeObj = new HomePage(driver);
		LoginObj = new LoginPage(driver);
		ProductDetailsObj = new ProductDetailsPage(driver);
		ProductsObj = new ProductsPage (driver);
		adRmvObj=new AddRemover(driver);
		SignUpObj = new SignUpPage (driver);
	}
	
	@Test
	public void scenarioTc6() throws InterruptedException {
		homeObj.prdctsLnk.click();
		adRmvObj.removeAdd();
		homeObj.prdctsLnk.click();
		ProductsObj.verifyPage();
		adRmvObj.removeAdd();
		scrollDown();
		waits();
		ProductsObj.viewPrdctBtn.click();
		if(driver.getTitle().equals("Automation Exercise - All Products")) {
			ProductsObj.viewPrdctBtn.click();
		}
		ProductDetailsObj.verifyWurLabel();
		scrollDown();
		ProductDetailsObj.enterReview();
		ProductDetailsObj.verifyReviewLbl();
		driver.quit();
	}
	
}

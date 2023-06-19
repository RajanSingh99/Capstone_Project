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
import extra.AddRemover;

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
	
	@Parameters({"Port"})
	@BeforeClass
	public void initialSetup(String Port) throws MalformedURLException{
		System.out.println(Port);
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
	public void scenarioTc6() {
		homeObj.prdctsLnk.click();
		adRmvObj.removeAdd();
		homeObj.prdctsLnk.click();
		ProductsObj.verifyPage();
		adRmvObj.removeAdd();
		ProductsObj.viewPrdctBtn.click();
		ProductDetailsObj.verifyWurLabel();
		ProductDetailsObj.enterReview();
		ProductDetailsObj.verifyReviewLbl();
	}
	
}

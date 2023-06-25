package automationExercise.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utils.AddRemover;

public class AccountCreatedPage {
	
	WebDriver driver;
	AddRemover adRmv;
	public AccountCreatedPage(WebDriver driver) {
		this.driver=driver;
		adRmv=new AddRemover(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//*[text()='Account Created!']")
	public WebElement accntCreatedLbl;
	
	@FindBy(xpath="//*[@data-qa='continue-button']")
	public WebElement continueBtn;
	
	
	public void verifyAccountCreated() {
		Assert.assertEquals(accntCreatedLbl.isDisplayed(), true);
		continueBtn.click();
		adRmv.removeAdd();
		if(driver.getTitle().equals("Automation Exercise - Account Created")) {
			continueBtn.click();
		}
	}
	
	
}

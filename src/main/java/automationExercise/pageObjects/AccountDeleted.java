package automationExercise.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import extra.AddRemover;

public class AccountDeleted {
	
	WebDriver driver;
	   AddRemover adRmv;
		public AccountDeleted(WebDriver driver) {
			this.driver=driver;
			adRmv=new AddRemover(driver);
			PageFactory.initElements(driver, this);
		}
	
	@FindBy(xpath="//*[text()='Account Deleted!']")
	public WebElement accntDeletedLbl;
	
	@FindBy(xpath="//*[@data-qa='continue-button']")
	public WebElement continueBtn;
	
	public void verifyAcctDel() throws InterruptedException {
		Assert.assertEquals(accntDeletedLbl.isDisplayed(), true);
		Thread.sleep(1000);
		continueBtn.click();
//		if(accntDeletedLbl.isDisplayed()==true) {
//			continueBtn.click();
//		}
	}
	
}

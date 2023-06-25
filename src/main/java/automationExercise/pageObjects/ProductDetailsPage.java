package automationExercise.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utils.AddRemover;

public class ProductDetailsPage {
	
	WebDriver driver;
	   AddRemover adRmv;
		public ProductDetailsPage(WebDriver driver) {
			this.driver=driver;
			adRmv=new AddRemover(driver);
			PageFactory.initElements(driver, this);
		}
	
	@FindBy(xpath="//*[text()='Write Your Review']")
	public WebElement writeUrReviewLbl;
	
	@FindBy(xpath="//*[@id='name']")
	public WebElement nameInpt;
	
	@FindBy(xpath="//*[@id='email']")
	public WebElement emailInpt;
	
	@FindBy(xpath="//*[@id='review']")
	public WebElement reviewInpt;
	
	@FindBy(xpath="//*[@id='button-review']")
	public WebElement submitReviewBtn;
	
	@FindBy(xpath="//*[text()='Thank you for your review.']")
	public WebElement thanks4ReviewLbl;
	
	public void verifyWurLabel() {
		Assert.assertEquals(writeUrReviewLbl.isDisplayed(), true);
	}
	public void enterReview() {
		emailInpt.sendKeys("pllp@gmail.com");
		nameInpt.sendKeys("pllp");
		reviewInpt.sendKeys("nice!");
		submitReviewBtn.click();
	}
	public void verifyReviewLbl() {
		Assert.assertEquals(thanks4ReviewLbl.isDisplayed(), true);
	}
}

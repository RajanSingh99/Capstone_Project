package automationExercise.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import extra.AddRemover;

public class CartPage {
 	
	WebDriver driver;
	   AddRemover adRmv;
		public CartPage(WebDriver driver) {
			this.driver=driver;
			adRmv=new AddRemover(driver);
			PageFactory.initElements(driver, this);
		}
	
	@FindBy(xpath="//*[@class='cart_quantity_delete']")
	public WebElement productRmvBtn;
	
	@FindBy(xpath="//*[@href='/product_details/1']")
	public WebElement productInCartName;
	
	@FindBy(xpath="//*[text()='Cart is empty!']")
	public WebElement emtyCartLbl;
	
	public void verifycartPage() {
		Assert.assertEquals(driver.getTitle(),"Automation Exercise - Checkout");
	}
	
	public void remove5prdct() throws InterruptedException {
		for(int i=1;i<=5;i++) {
			productRmvBtn.click();
			Thread.sleep(2000);
		}
	}
	public void verifyEmptyCart() {
		Assert.assertEquals(emtyCartLbl.isDisplayed(), true);
	}
	
}

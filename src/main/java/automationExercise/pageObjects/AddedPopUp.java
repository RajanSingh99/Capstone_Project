package automationExercise.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import extra.AddRemover;

public class AddedPopUp {
	
	WebDriver driver;
	   AddRemover adRmv;
		public AddedPopUp(WebDriver driver) {
			this.driver=driver;
			adRmv=new AddRemover(driver);
			PageFactory.initElements(driver, this);
		}
	
	
	@FindBy(xpath="//*[text()='Continue Shopping']")
	public WebElement continueShoppingBtn;
	
	
}

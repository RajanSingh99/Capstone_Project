package automationExercise.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import extra.AddRemover;

public class LoginPage {
	
	WebDriver driver;
	   AddRemover adRmv;
		public LoginPage(WebDriver driver) {
			this.driver=driver;
			adRmv=new AddRemover(driver);
			PageFactory.initElements(driver, this);
		}
	
	@FindBy(xpath="//*[text()='New User Signup!']")
	public WebElement newUserSignupLabel;
	
	@FindBy(xpath="//*[@data-qa='signup-name']")
	public WebElement nameNewUserSignUp;
	
	@FindBy(xpath="//*[@data-qa='signup-email']")
	public WebElement emailNewUserSignUp;
	
	@FindBy(xpath="//*[@data-qa='signup-button']")
	public WebElement signUpButton;
	
	
	@FindBy(xpath="//*[text()='Login to your account']")
	public WebElement loginAccntLbl;
	
	@FindBy(xpath="//*[@data-qa='login-email']")
	public WebElement  emailLogin;
	
	@FindBy(xpath="//*[@data-qa='login-password']")
	public WebElement passwordLogin;
	
	@FindBy(xpath="//*[@data-qa='login-button']")
	public WebElement loginButton;
	
	@FindBy(xpath="//*[text()='Your email or password is incorrect!']")
	public WebElement incrctEmailPassLbl;
	
	public void verifyNewUserSignUp() {
		Assert.assertEquals(newUserSignupLabel.isDisplayed(), true);
		
	}
	public void newUserSignUpDetails() {
		nameNewUserSignUp.sendKeys("Rajan");
		emailNewUserSignUp.sendKeys("a24@gmail.com");
		signUpButton.click();
	}
	public void verifyLoginLbl() {
		Assert.assertEquals(loginAccntLbl.isDisplayed(), true);
	}
	public void fillLoginDetails() {
		emailLogin.sendKeys("pllp@gmail.com");
		passwordLogin.sendKeys("pllp");
		loginButton.click();
	}
	public void fillWrongDetails() {
		emailLogin.sendKeys("gullu@pullu.com");
		passwordLogin.sendKeys("gullu");
		loginButton.click();
	}
	public void verifyError() {
		Assert.assertEquals(incrctEmailPassLbl.isDisplayed(), true);
	}
}

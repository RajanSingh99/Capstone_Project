package automationExercise.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import config.ConfigProperties;
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
	public void newUserSignUpConstant(String port) {
		nameNewUserSignUp.sendKeys(ConfigProperties.property.getProperty("name"));
		if(port.equals("6666")) {
			  emailNewUserSignUp.sendKeys(ConfigProperties.property.getProperty("email6666"));
			}else {
			  emailNewUserSignUp.sendKeys(ConfigProperties.property.getProperty("email"));
			}
		signUpButton.click();
	}
	public void newUserSignUpDetails(String port) {
		nameNewUserSignUp.sendKeys(ConfigProperties.property.getProperty("name"));
		if(port.equals("6666")) {
		  emailNewUserSignUp.sendKeys(Math.round((Math.random()*1000))+ ConfigProperties.property.getProperty("email6666"));
		}else {
		  emailNewUserSignUp.sendKeys(Math.round((Math.random()*1000))+ ConfigProperties.property.getProperty("email"));
		}
		signUpButton.click();
	}
	public void verifyLoginLbl() {
		Assert.assertEquals(loginAccntLbl.isDisplayed(), true);
	}
	public void fillLoginDetails(String str,String  Port) {
		if(Port.equals("6666")&& str.equals("email")) {
		  emailLogin.sendKeys(ConfigProperties.property.getProperty("email6666"));
		}else {
			emailLogin.sendKeys(ConfigProperties.property.getProperty(str));
		}
		passwordLogin.sendKeys(ConfigProperties.property.getProperty("password"));
		loginButton.click();
	}
	public void fillWrongDetails() {
		emailLogin.sendKeys("c"+ConfigProperties.property.getProperty("email"));
		passwordLogin.sendKeys(ConfigProperties.property.getProperty("wrongPass"));
		loginButton.click();
	}
	public void verifyError() {
		Assert.assertEquals(incrctEmailPassLbl.isDisplayed(), true);
	}
}

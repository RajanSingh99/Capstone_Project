package automationExercise.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import config.ConfigProperties;
import extra.AddRemover;

public class SignUpPage {
	
   WebDriver driver;
   AddRemover adRmv;
	public SignUpPage(WebDriver driver) {
		this.driver=driver;
		adRmv=new AddRemover(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//*[text()='Enter Account Information']")
	public WebElement enterAccountInformationLabel;
	
	@FindBy(id ="id_gender1")
	public WebElement mrRadioOptn;
	
	@FindBy(id="id_gender2")
	public WebElement mrsRadioOptn;
	
	@FindBy(xpath ="//*[@id='password']")
	public WebElement passwordInput;
	
	@FindBy(xpath="//*[@id='days']")
	public WebElement daysDropdown;
	
	@FindBy(xpath="//*[@id='months']")
	public WebElement monthDropdown;
	
	@FindBy(xpath="//*[@id='years']")
	public WebElement yearsDropdown;
	
	@FindBy(xpath="//*[text()='Sign up for our newsletter!']")
	public WebElement newsletterChkbox;
	
	@FindBy(xpath="//*[text()='Receive special offers from our partners!']")
	public WebElement offersChkbox;
	
	@FindBy(xpath="//*[@id='first_name']")
	public WebElement firstNameInpt;
	
	@FindBy(xpath="//*[@id='last_name']")
	public WebElement lastNameInpt;
	
	@FindBy(xpath="//*[@id='company']")
	public WebElement companyInpt;
	
	@FindBy(xpath="//*[@id='address1']")
	public WebElement address1Inpt;
	
	@FindBy(xpath="//*[@id='address2']")
	public WebElement address2Inpt;
	
	@FindBy(xpath="//*[@id='state']")
	public WebElement stateInpt;
	
	@FindBy(xpath="//*[@id='city']")
	public WebElement cityInpt;
	
	@FindBy(xpath="//*[@id='zipcode']")
	public WebElement zipcodeInpt;
	
	@FindBy(xpath="//*[@id='mobile_number']")
	public WebElement mobileNumberInpt;
	
	@FindBy(xpath ="//*[@data-qa='create-account']")
	public WebElement createAcntBtn;
	
	@FindBy(xpath="//*[@id='country']")
	public WebElement countryDrpdwn;
	
	public void verifyEnterLbl() {
		Assert.assertEquals(enterAccountInformationLabel.isDisplayed(), true);
	}
	public void fillAccountInformation() {
		adRmv.removeAdd();
		mrRadioOptn.click();
		passwordInput.sendKeys(ConfigProperties.property.getProperty("password"));
		selection(daysDropdown).selectByValue(ConfigProperties.property.getProperty("day"));
		selection(monthDropdown).selectByValue(ConfigProperties.property.getProperty("month"));
		selection(yearsDropdown).selectByValue(ConfigProperties.property.getProperty("year"));
		newsletterChkbox.click();
		offersChkbox.click();
		firstNameInpt.sendKeys(ConfigProperties.property.getProperty("name"));
		lastNameInpt.sendKeys(ConfigProperties.property.getProperty("lastName"));
		companyInpt.sendKeys(ConfigProperties.property.getProperty("CompanyName"));
		address1Inpt.sendKeys(ConfigProperties.property.getProperty("Address1"));
		address2Inpt.sendKeys(ConfigProperties.property.getProperty("Address2"));
		selection(countryDrpdwn).selectByValue(ConfigProperties.property.getProperty("country"));
		stateInpt.sendKeys(ConfigProperties.property.getProperty("state"));
		cityInpt.sendKeys(ConfigProperties.property.getProperty("city"));
		zipcodeInpt.sendKeys(ConfigProperties.property.getProperty("zipcode"));
		mobileNumberInpt.sendKeys(ConfigProperties.property.getProperty("mobileNo"));
		createAcntBtn.click();
	}
	
	public Select selection(WebElement element) {
		Select se=new Select(element);
		return se;
	}
}

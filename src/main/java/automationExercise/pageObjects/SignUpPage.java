package automationExercise.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

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
		passwordInput.sendKeys("Hellooo");
		selection(daysDropdown).selectByValue("2");
		selection(monthDropdown).selectByValue("3");
		selection(yearsDropdown).selectByValue("1972");
		newsletterChkbox.click();
		offersChkbox.click();
		firstNameInpt.sendKeys("bittu");
		lastNameInpt.sendKeys("halder");
		companyInpt.sendKeys("ABC");
		address1Inpt.sendKeys("abc road");
		address2Inpt.sendKeys("jahangir para");
		selection(countryDrpdwn).selectByValue("Canada");
		stateInpt.sendKeys("manipur");
		cityInpt.sendKeys("Agra");
		zipcodeInpt.sendKeys("1234");
		mobileNumberInpt.sendKeys("838388443");
		createAcntBtn.click();
	}
	
	public Select selection(WebElement element) {
		Select se=new Select(element);
		return se;
	}
}

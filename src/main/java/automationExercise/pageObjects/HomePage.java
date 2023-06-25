package automationExercise.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import config.ConfigProperties;
import utils.AddRemover;

public class HomePage {
	
	WebDriver  driver;
    AddRemover adRmv;
    Actions    act;
    AddedPopUp addPopObj;
    JavascriptExecutor js;
	public HomePage(WebDriver driver) {
		this.driver=driver;
		adRmv=new AddRemover(driver);
		act=new Actions(driver);
		addPopObj=new AddedPopUp(driver);
		js = (JavascriptExecutor) driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@href='/']")
	 public WebElement orangeHome;
	
	@FindBy(xpath="//*[@href='/login']")
	public WebElement signupLoginLink;
	
	@FindBy(xpath="//a[text()=' Logged in as ']/b")
	public WebElement loginNameLbl;
	
	@FindBy(xpath="//*[@href='/delete_account']")
	public WebElement deleteAccountBtn;
	
	@FindBy(xpath="//*[@href='/view_cart']")
	public WebElement cartLnk;
	
	@FindBy(xpath="//*[text()=' Logout']")
	public WebElement logoutBtn;
	
	@FindBy(xpath="//*[@href='/products']")
	public WebElement prdctsLnk;
	
	public void verifyHome() {
		Assert.assertEquals(driver.getTitle(), "Automation Exercise");
	}
	public void scrollDown() {
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("window.scrollBy(0,350)", "");
    }
	public void signUpLoginClick() {
		signupLoginLink.click();
	}
	
	public void verifyUsername() {
		Assert.assertEquals(loginNameLbl.getText(), ConfigProperties.property.getProperty("name"));
	}
	public void delAccnt() {
		deleteAccountBtn.click();
		adRmv.removeAdd();
		if((driver.getTitle()).equals("Automation Exercise")) {
			deleteAccountBtn.click();
		}
	}
	public void addFivePrdct() throws InterruptedException {
		Thread.sleep(1000);
		adRmv.removeAdd();
		scrollDown();
		Thread.sleep(1000);
		for(int i=1;i<=5;i++) {
			js.executeScript("arguments[0].click();", driver.findElement(By.xpath("(//*[text()='Add to cart'])["+i*2+"]")));
			Thread.sleep(1000);
			addPopObj.continueShoppingBtn.click();
		}
	}
	
}

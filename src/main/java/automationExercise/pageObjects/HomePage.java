package automationExercise.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import extra.AddRemover;

public class HomePage {
	
	WebDriver  driver;
    AddRemover adRmv;
    Actions    act;
    AddedPopUp addPopObj;
	public HomePage(WebDriver driver) {
		this.driver=driver;
		adRmv=new AddRemover(driver);
		act=new Actions(driver);
		addPopObj=new AddedPopUp(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@href='/'][@style='color: orange;']")
	 public WebElement orangeHome;
	
	@FindBy(xpath="//*[@href='/login']")
	public WebElement signupLoginLink;
	
	@FindBy(xpath="//a[text()=' Logged in as ']/b")
	public WebElement loginNameLbl;
	
	@FindBy(xpath="//*[@href='/delete_account']")
	public WebElement deleteAccountBtn;
	
	@FindBy(xpath="//*[@href='/view_cart']")
	public WebElement cartLnk;
	
	@FindBy(xpath="//*[@href='/products']")
	public WebElement prdctsLnk;
	
	public void verifyHome() {
		Assert.assertEquals(driver.getTitle(), "Automation Exercise");
	}
	public void signUpLoginClick() {
		signupLoginLink.click();
	}
	
	public void verifyUsername(String username) {
		Assert.assertEquals(loginNameLbl.getText(), username);
	}
	public void delAccnt() {
		deleteAccountBtn.click();
		adRmv.removeAdd();
		deleteAccountBtn.click();
	}
	public void addFivePrdct() throws InterruptedException {
		Thread.sleep(1000);
		adRmv.removeAdd();
		Thread.sleep(1000);
		for(int i=1;i<=5;i++) {
			act.moveToElement(driver.findElement(By.xpath("(//*[@class='productinfo text-center'])["+i+"]"))).build().perform();
			Thread.sleep(2000);
			System.out.println("(//*[@class='productinfo text-center'])["+i+"]");
			driver.findElement(By.xpath("(//*[text()='Add to cart'])["+i*2+"]")).click();
			Thread.sleep(1000);
			addPopObj.continueShoppingBtn.click();
		}
	}
	
}

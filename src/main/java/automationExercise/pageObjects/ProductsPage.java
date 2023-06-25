package automationExercise.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utils.AddRemover;

public class ProductsPage {
	
	WebDriver driver;
    AddRemover adRmv;
    Actions   act;
    AddedPopUp addPopObj;
    JavascriptExecutor js;
	public ProductsPage(WebDriver driver) {
		this.driver=driver;
		adRmv=new AddRemover(driver);
		act = new Actions(driver);
		addPopObj=new AddedPopUp(driver);
		js = (JavascriptExecutor) driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[text()='All Products']")
	public WebElement allProductsLbl;

	@FindBy(xpath="//*[@id='search_product']")
	public WebElement searchInpt;
	
	@FindBy(xpath="//*[@id='submit_search']")
	public WebElement searchBtn;
	
	@FindBy(xpath="//*[text()='Searched Products']")
	public WebElement searchPrdctsLbl;
	
	@FindBy(xpath="//*[@id='data-product-id='3']")
	public WebElement addDress1;
	
	@FindBy(xpath="//*[@id='data-product-id='4']")
	public WebElement addDress2;
	
	@FindBy(xpath="//*[@id='data-product-id='16']")
	public WebElement addDress3;
	
	@FindBy(xpath="//*[@id='data-product-id='19']")
	public WebElement addDress4;
	
	@FindBy(xpath="//*[@id='data-product-id='20']")
	public WebElement addDress5;
	
	@FindBy(xpath="//*[@id='data-product-id='21']")
	public WebElement addDress6;
	
	@FindBy(xpath="//*[@id='data-product-id='22']")
	public WebElement addDress7;
	
	@FindBy(xpath="//*[@id='data-product-id='23']")
	public WebElement addDress8;
	
	@FindBy(xpath="//*[@id='data-product-id='38']")
	public WebElement addDress9;
	
	@FindBy(xpath="//*[@id='data-product-id='1']")
	public WebElement addProduct;
	
	@FindBy(xpath="//*[text()='View Product']")
	public WebElement viewPrdctBtn;
	
	public void verifyPage() {
		System.out.println(driver.getTitle());
		Assert.assertEquals(driver.getTitle(), "Automation Exercise - All Products");
	}
	public void search() {
		searchInpt.sendKeys("Dress");
		searchBtn.click();
		Assert.assertEquals(searchPrdctsLbl.isDisplayed(), true);
	}
	
	public void addSrchedPrdct() throws InterruptedException {
		Thread.sleep(1000);
		adRmv.removeAdd();
		Thread.sleep(1000);
		for(int i=1;i<=9;i++) {
			js.executeScript("arguments[0].click();", driver.findElement(By.xpath("(//*[text()='Add to cart'])["+i*2+"]")));	
			Thread.sleep(1000);
			addPopObj.continueShoppingBtn.click();
		}
	}
	public void verifyProductsAdded() {
		int id[]= {3,4,16,19,20,21,22,23,38};
		for(int i=0;i<id.length;i++) {
			Assert.assertEquals(driver.findElement(By.id("product-"+id[i])).isDisplayed(), true);
		}
	}
}

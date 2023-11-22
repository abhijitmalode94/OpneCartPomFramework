package Com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Com.qa.opencart.constat.AppConstants;
import Com.qa.opencart.utility.ElementUtil;

public class ProductSeachPage {
	
	private WebDriver driver;
	private ElementUtil eutil;
	
	//private By productname=By.linkText("MacBook Pro");
	// we do not use by locator here because it is hardcoded values 
	//suppose tommarow we want to search anoter prosuct
	
	private By searchProductName=By.cssSelector("div#content  div.product-layout");

	public ProductSeachPage(WebDriver driver) {
		
		this.driver=driver;
		eutil=new ElementUtil(driver);
	}
	
	
	public int getsearchProductCount() {
		int productsearchCount=eutil.waitForElementsVisible(searchProductName, AppConstants.DEFAULT_MEDIUM_TIMEOUT).size();
		return productsearchCount;
		
	}
	
	
	//before this method run we need to do some to do validation on this page , so the before this we need to write some text
	public productInfoPage selectProduct(String productName) {
		
		By productLocator=By.linkText(productName);
		
		eutil.waitForElementVisible(productLocator,AppConstants.DEFAULT_MEDIUM_TIMEOUT).click();
		return new productInfoPage(driver);
		
	}

}

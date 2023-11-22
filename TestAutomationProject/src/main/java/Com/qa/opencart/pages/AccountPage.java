package Com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Com.qa.opencart.utility.ElementUtil;

public class AccountPage {
	
	private  WebDriver driver;
	private ElementUtil eutil;
	
	//Create locator for account page
	
	private By logoutLink=By.linkText("Logout");
	private By accountHeader=By.cssSelector("div#content h2");
	private By search=By.xpath("//input[@name=\"search\"]");
	private By serachicon=By.cssSelector(" button[class='btn btn-default btn-lg']");	
	
	
	public AccountPage( WebDriver driver) {
		this.driver=driver;
		eutil=new ElementUtil(driver);
	}
	
	public String getAccountsPageTitle() {
		String title=driver.getTitle();
		System.out.println("Account Page title is="+title);
		return title;
	}
	public String getAccountPageUrl()
	{
		String url=driver.getCurrentUrl();
		System.out.println("Account Page Url is ="+url);
		return url;
	}
	
	public boolean logoutlinkExist() {
		return driver.findElement(logoutLink).isDisplayed();
	}
	
	public boolean isSearchDisplayed() {
		return driver.findElement(search).isDisplayed();
	}
	
	public List<WebElement> getAccountPageHeaderList() {
		List<WebElement> accHeaderList=driver.findElements(accountHeader);
		List<String> accHeaderArryList=new ArrayList<String>();
		
		for(WebElement e:accHeaderList) {
			String text=e.getText();
			accHeaderArryList.add(text);
		}
		return accHeaderList;
	}
	
	//driver.findElements(accountHeader);
	
	
	public ProductSeachPage performSearch(String searchKey) {
		
		if(isSearchDisplayed()) {
			
			eutil.doSendKeys( search, searchKey);
			eutil.doClick(serachicon);
			return new ProductSeachPage(driver);
		}
		else {
			System.out.println("Seach filed not present on the page");
			return null;
		}
		
	}

}

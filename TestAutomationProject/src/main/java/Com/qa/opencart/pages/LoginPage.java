package Com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Com.qa.opencart.constat.AppConstants;
import Com.qa.opencart.utility.ElementUtil;

public class LoginPage {
	
	private  WebDriver driver;
	private ElementUtil eutil;
	//Here the default values of driver is pointing towards null
	//1.private by locator
	private By emailId=By.id("input-email");
	private By password=By.id("input-password");
	private By loginBtn=By.xpath("//input[@value=\"Login\"]");
	private By forgotPwdLink=By.linkText("Forgotten Password");
	private By searchField=By.xpath("//input[@name=\"search\"]");
	private By allLinkofMiddleLoginPage=By.cssSelector("div.list-group a");
	
	//2.page constructor...
	
	public LoginPage( WebDriver driver) {
		this.driver=driver;
		eutil=new ElementUtil(driver);
	}
	
	//3.page action /methods/behaviour of page
	public String getLoginPageTitle() {
		
		String title=eutil.waitForTitleContainsAndFetch(AppConstants.DEFAULT_MEDIUM_TIMEOUT,AppConstants.LOGIN_PAGE_TITLE_VALUES);
//		String title=driver.getTitle();
		System.out.println("LoginPage Title is-"+title);
		return title;
	}
	
	public String getLoginPageUrl() {
		
		
//		String url=driver.getCurrentUrl();
		
	String url=eutil.waitForURLContainsAndFetch(AppConstants.DEFAULT_MEDIUM_TIMEOUT,AppConstants.LOGIN_PAGE_URL_FRACTION_VALUES);
		System.out.println("login page url is-"+url);
		return url;
	}
	public boolean isForgotPwdlinkExist() {
		return eutil.waitForElementVisible(forgotPwdLink, AppConstants.DEFAULT_MEDIUM_TIMEOUT).isDisplayed();
		
		//return driver.findElement(forgotPwdLink).isDisplayed();
		
	}
	
	
	public boolean idSearchFieldisplayed() {
		return driver.findElement(searchField).isDisplayed();
	}
	
	public List<WebElement> loginPageMiddleLinkExist() {
		List<WebElement> allmiddleLink=driver.findElements(allLinkofMiddleLoginPage);
		List<String> allmiddleLinkArryList=new ArrayList<String>();
		for (WebElement e:allmiddleLink) {
			String text=e.getText();
			allmiddleLinkArryList.add(text);
		}
		return allmiddleLink;
	
		}
	
	public AccountPage doLogin(String un, String pwd) {
		System.out.println("Your app credential are"+un+":"+pwd);
		
		eutil.waitForElementVisible(emailId, AppConstants.DEFAULT_MEDIUM_TIMEOUT).sendKeys(un);
		eutil.doSendKeys(password, pwd);
		eutil.doClick(loginBtn);
		return new AccountPage(driver);
		 
		
		
	
		
//		driver.findElement(emailId).sendKeys(un);
//		driver.findElement(password).sendKeys(pwd);
//		driver.findElement(loginBtn).click();
//		// this metd has reposibilty for next page - n
//		return new AccountPage(driver);// this will return next page object
//		
//		// this is page chaining in POM which is used to lauch the other page
	}
	
		
	}


package com.qa.opencart.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import Com.qa.opencart.factory.DriverFactory;
import Com.qa.opencart.pages.AccountPage;
import Com.qa.opencart.pages.LoginPage;
import Com.qa.opencart.pages.ProductSeachPage;

public class BaseTest {
	
	//create the ref  of driverfactory class , don't use static and unncessary inheritance
	
	DriverFactory df;
	WebDriver driver;
	protected LoginPage loginPage;
	protected AccountPage accPage;
	protected ProductSeachPage psp;
	protected Properties prop;
	
	@BeforeTest
	public void setUp() {
		df = new DriverFactory();

		// df.initDriver("Chrome");-it will returning webdriver so make webdriver driver
		// at class level
		
		prop=df.initProp();
		driver = df.initDriver(prop);
		loginPage = new LoginPage(driver);
		//we created object of login page becasue it is staring page of application
		//
		
		
		//loginPage.doLogin(null, null)-because this impacted loginPage
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}


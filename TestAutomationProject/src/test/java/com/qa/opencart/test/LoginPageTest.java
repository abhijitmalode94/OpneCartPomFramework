package com.qa.opencart.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;

import Com.qa.opencart.constat.AppConstants;

public class LoginPageTest extends BaseTest {	

	@Test(priority=1)
	public void loginPageTitleTest() {

		String ActualTitle = loginPage.getLoginPageTitle();

		Assert.assertEquals(ActualTitle,AppConstants.LOGIN_PAGE_TITLE_VALUES);

	}
	@Test(priority=2)
	public void loginPageUrlTest() {
		String ActualUrl= loginPage.getLoginPageUrl();
		Assert.assertTrue(ActualUrl.contains(AppConstants.LOGIN_PAGE_URL_FRACTION_VALUES));
	}
	
	@Test(priority=3)
	public void forgotpasswordLinkExist() {
		Assert.assertTrue(loginPage.isForgotPwdlinkExist());
	}
	
	@Test(priority=5)
	public void loginpagetest() {
		accPage=loginPage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
		Assert.assertTrue(accPage.logoutlinkExist());
		
		//can we write assertion for this test
		//this metd give the acc page ref
	}
	
	@Test(priority=4)
	public void searchfieldExixt() {
		Assert.assertTrue(loginPage.idSearchFieldisplayed());
		
	}
	
//	@Test
//	public void getAllmidleLoginpagelink() {
//		List<WebElement> actual_allLinkSize=loginPage.loginPageMiddleLinkExist();
//		System.out.println("all login page middle link list is"+actual_allLinkSize);
//		Assert.assertEquals(actual_allLinkSize.size(),13 );
//		
//		
//		
//		
//	}
}

package com.qa.opencart.test;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;

import Com.qa.opencart.constat.AppConstants;

public class AccountPagetest extends BaseTest {

	// without login we can not come on this page

	@BeforeClass
	public void accountPagesetUp() {

		accPage=loginPage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
		// so it return the account page so we created the ref in base class and use it in this class
		// so we store it in the ref
		

	}
	
	@Test
	public void accountPageTitleTest() {
		String actualTitle=accPage.getAccountsPageTitle();
		Assert.assertEquals(actualTitle, "My Account");
		
	}
	@Test
	public void accountPageUrltest() {
		String url=accPage.getAccountPageUrl();
		Assert.assertTrue(url.contains("route=account"));
	}
	@Test
	public void isLogoutLinkExist() {
		Assert.assertTrue(accPage.logoutlinkExist());
	}
	@Test
	public void accAccountPageHeaderList() {
		List<WebElement>accheaderList=accPage.getAccountPageHeaderList();
		System.out.println("Account page header list"+accheaderList);
		Assert.assertEquals(accheaderList.size(),AppConstants.ACCOUNT_PAGE_HEADERS_COUNT);
	}
	
	//chek header correct or not
	
	@Test
	public void accoutPageHeaderValues() {
		List<WebElement>accheaderList=accPage.getAccountPageHeaderList();
		System.out.println("Account page header list"+accheaderList);
		Assert.assertEqualsNoOrder(accheaderList,AppConstants.EXPECTED_ACCOUNT_PAGE_HEADERS_VALUE_lIST);
		//it will comapre the both list 
	}
	
	@Test
	public void searchTest() {
		psp=accPage.performSearch("Macbook");
		//psp.getsearchProductCount();
		Assert.assertTrue(psp.getsearchProductCount()>0);
		// if product show 0 then TC is failed
		
	}
	
//	@Test
//	public void searchProduct() {
//		psp=
//				
//	}
	

}

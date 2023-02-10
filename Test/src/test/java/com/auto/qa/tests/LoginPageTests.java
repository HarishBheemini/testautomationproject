package com.auto.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.auto.qa.base.TestBase;
import com.auto.qa.pages.LoginPage;
import com.auto.qa.util.Utilities;

public class LoginPageTests extends TestBase {
	public LoginPage lp;
	
	public LoginPageTests() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initiliaseWebDriver();
		lp = new LoginPage();
	}
	
	@Test(enabled = false)
	public void verifyNavigateToCartPage() {
		lp.navigateToCartPage();
		Assert.assertTrue(lp.getPageTitle().contains("Cart"), "Cart page is not loaded");
		
	}
	
	
	@Test(enabled = false)
	public void verifyNavigateToHomePage() {
		Assert.assertTrue(lp.getPageTitle().contains("Amazon"), "Home page is not loaded");
		
	}
	
	@Test(groups= {"regression"}, enabled = false)
	public void groupTest() {
		System.out.println("Group Test1");
		
	}
	
	@Test(groups= {"regression"}, enabled = false)
	public void groupTest2() {
		System.out.println("Group Test2");
		
	}
	
	@Test(dataProvider = "getTestDataProvider", dataProviderClass = Utilities.class)
	public void testdataprovidertest(String name, String age, String role) {
		System.out.println("Name: "+name+ " Age is: "+ age+ " and the role is "+ role);
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	

}

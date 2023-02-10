package com.auto.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.auto.qa.base.TestBase;

public class LoginPage extends TestBase{

	// Page Factory   or Object Repository
	
	@FindBy(xpath="//a[@id='nav-cart']")
	WebElement cartLink;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	public HomePage navigateToCartPage() {
		cartLink.click();
		return new HomePage();
		
	}
}


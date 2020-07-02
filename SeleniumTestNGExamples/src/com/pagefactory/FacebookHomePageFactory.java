package com.pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class FacebookHomePageFactory {
	
	@FindBy(id = "email") @CacheLookup WebElement usernameInput;
	@FindBy(id = "pass") @CacheLookup WebElement passwordInput;
	@FindBy(how = How.XPATH, using = "//input[@value='Log In']") @CacheLookup WebElement loginButton;
	
WebDriver driver;
	
	public FacebookHomePageFactory( WebDriver driver){
		this.driver = driver;
	}
	
	public void loginUser(CharSequence username, CharSequence password) {
		usernameInput.sendKeys(username);
		passwordInput.sendKeys(password);
		loginButton.click();
	}

}

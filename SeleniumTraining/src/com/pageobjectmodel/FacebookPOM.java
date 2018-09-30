package com.pageobjectmodel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FacebookPOM {
	
	By usernameInput = By.id("email");
	By passwordInput = By.id("pass");
	By LogInBtn = By.xpath("//input[@value='Log In']");
	
	WebDriver driver;
	
	public FacebookPOM( WebDriver driver){
		this.driver = driver;
	}
	
	public void loginUser(CharSequence username, CharSequence password) {
		driver.findElement(usernameInput).sendKeys(username);
		driver.findElement(passwordInput).sendKeys(password);
		driver.findElement(LogInBtn).click();
	}

}

package com.facebook.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.training.utilities.TakeScreenshot;

public class LoginPage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	protected String username;
	protected String password;
	
	public LoginPage(WebDriver driver, WebDriverWait wait)
	{
		this.driver=driver;
		this.wait=wait;
	}
	
	public void doLogin(String username, String password) throws IOException 
	{
		this.username=username;
		this.password=password;
		lauchPage();
		validateLaunch();
		TakeScreenshot.captureScreenNew(driver);
		enterUserName(username);
		TakeScreenshot.captureScreenNew(driver);
		enterPassword(password);
		TakeScreenshot.captureScreenNew(driver);
		hitSubmit();
		validateLogIn();
		TakeScreenshot.captureScreenNew(driver);
	}

	private void validateLogIn() {
		// TODO Auto-generated method stub
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"reg-link\"]")));
	}

	private void validateLaunch() {
		// TODO Auto-generated method stub
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Forgotten account?')]")));
	}

	private void hitSubmit() {
		// TODO Auto-generated method stub
		driver.findElement(By.id("loginbutton")).click();
	}

	private void enterPassword(String password2) {
		// TODO Auto-generated method stub
		driver.findElement(By.id("pass")).sendKeys(password2);
	}

	private void enterUserName(String username2) {
		// TODO Auto-generated method stub
		driver.findElement(By.id("email")).sendKeys(username2);
	}

	private void lauchPage() {
		// TODO Auto-generated method stub
		driver.get("https://www.facebook.com/");
		
	}

}

package com.newtours.pages;

import java.io.IOException;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.training.utilities.TakeScreenshot;

public class LoginPage {
	WebDriver driver;
	WebDriverWait wait;
	public LoginPage(WebDriver driver,WebDriverWait wait)
	{
		this.driver=driver;
		this.wait=wait;
	}
	public void enterCredentials(String username,String password) throws IOException
	{
		enterUserName(username);
		enterPassword(password);
		TakeScreenshot.captureScreen(driver);
		submit();
		if(!validateSignIn())
			System.out.println("TIMED OUT");
		TakeScreenshot.captureScreen(driver);
	}
	private void enterPassword(String password) {
		// TODO Auto-generated method stub
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
		
	}
	private void enterUserName(String username) {
		// TODO Auto-generated method stub
		driver.findElement(By.xpath("//input[@name='userName']")).sendKeys(username);
		
	}
	private void submit() {
		// TODO Auto-generated method stub
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
	}
	private boolean validateSignIn() {
		// TODO Auto-generated method stub
		return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'SIGN-OFF')]"))) != null;
		
	}
}

package com.newtours.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.training.utilities.TakeScreenshot;

public class HomePage {
	WebDriver driver;
	WebDriverWait wait;
	public HomePage(WebDriver driver, WebDriverWait wait)
	{
		this.driver=driver;
		this.wait=wait;
	}
	private boolean validateSignOn()
	{
		if(driver.findElement(By.xpath("//a[contains(text(),'SIGN-ON')]")).isEnabled())
			return true;
		return false;
	}
	public boolean launchPage() throws IOException
	{
		driver.get("http://newtours.demoaut.com/");
		TakeScreenshot.captureScreen(driver);
		return validateSignOn();
	}

}

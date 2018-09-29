package com.testpages.differentfunctions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.utilities.LaunchBrowser;
import com.utilities.ReadElementsProperties;

public class SeleniumGetElementsFromProperties {
	static WebDriver driver = null;
	static WebDriverWait wait = null;

	public static void main(String[] args) {
		
		LaunchBrowser lb = new LaunchBrowser("chrome");
		
		try {
		if(!(lb.getDriver() == null))
			driver = lb.getDriver();
		if(!(lb.getWait() == null))
			wait = lb.getWait();
		
		System.out.println(System.getProperty("user.dir"));
		driver.get("https://www.facebook.com");
		
		ReadElementsProperties rp = new ReadElementsProperties("PropertiesFiles/elements.properties");		
		rp.getWebElement(driver, "usernameInput").sendKeys("abc");
		rp.getWebElement(driver, "passwordInput").sendKeys("abc");
		rp.getWebElement(driver, "LogInButton").click();
		
		System.out.println("Test Passed");
		
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		finally{
			if(driver != null)
				driver.quit();
		}

	}

}

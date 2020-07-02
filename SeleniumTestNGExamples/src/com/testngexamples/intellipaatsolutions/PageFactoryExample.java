package com.testngexamples.intellipaatsolutions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pagefactory.FacebookHomePageFactory;
import com.utilities.LaunchBrowser;

public class PageFactoryExample {

	WebDriver driver = null;
	WebDriverWait wait = null;

	@Test
	public void loginFacebook() throws InterruptedException {
		FacebookHomePageFactory fp = PageFactory.initElements(driver, FacebookHomePageFactory.class);
		fp.loginUser("abc", "abc");
		Thread.sleep(3000);
	}

	@BeforeMethod
	public void setup() {

		LaunchBrowser lb = new LaunchBrowser("chrome");

		try {
			if (!(lb.getDriver() == null))
				driver = lb.getDriver();
			if (!(lb.getWait() == null))
				wait = lb.getWait();
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
		
		driver.get("https://www.facebook.com");

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}

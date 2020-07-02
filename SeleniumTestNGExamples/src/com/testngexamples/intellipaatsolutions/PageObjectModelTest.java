package com.testngexamples.intellipaatsolutions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pageobjectmodel.FacebookPOM;

public class PageObjectModelTest {

	WebDriver driver = null;

	@Test
	public void loginFacebook() throws InterruptedException {
		FacebookPOM fp = new FacebookPOM(driver);
		fp.loginUser("abc", "abc");
		Thread.sleep(3000);
	}

	@BeforeMethod
	public void setup() {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\KillZone\\Downloads\\Softwares\\chromedriver.exe");
		System.setProperty("webdriver.ie.driver", "C:\\Users\\KillZone\\Downloads\\Softwares\\IEDriverServer.exe");
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\KillZone\\Downloads\\Softwares\\geckodriver.exe");
		
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com");
		driver.manage().window().maximize();

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}

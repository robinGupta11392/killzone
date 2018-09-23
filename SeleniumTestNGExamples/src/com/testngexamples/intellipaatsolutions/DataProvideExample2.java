package com.testngexamples.intellipaatsolutions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvideExample2 {

	WebDriver driver = null;

	@BeforeMethod
	public void initialize() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\KillZone\\Downloads\\Softwares\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
	}

	@Test(dataProvider = "facebookDataName")
	public void launchFacebook(String email, String password) {
		driver.findElement(By.id("email")).sendKeys(email);
		driver.findElement(By.id("pass")).sendKeys(password);
		// driver.findElement(By.id("loginbutton")).click();
		System.out.println("Performing for : " + email + ", " + password);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@DataProvider(name = "facebookDataName")
	public Object[][] facbookData() {
		return new Object[][] { { "abc", "a" }, { "abc2", "b" }, { "abc3", "b" } };
	}
}

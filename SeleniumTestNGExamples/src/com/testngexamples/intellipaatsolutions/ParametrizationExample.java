package com.testngexamples.intellipaatsolutions;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterTest;

public class ParametrizationExample {

	WebDriver d = null;

	@Parameters({"browserType"})
	@Test
	public void launchBrowser(String browserType) {

		switch (browserType) {
		case "firefox":
			d = new FirefoxDriver();
			break;
		case "ie":
			d = new InternetExplorerDriver();
			break;
		default:
			d = new ChromeDriver();
			break;
		}

		d.get("https://www.google.com/");
	}

	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\KillZone\\Downloads\\Softwares\\chromedriver.exe");
		System.setProperty("webdriver.ie.driver", "C:\\Users\\KillZone\\Downloads\\Softwares\\IEDriverServer.exe");
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\KillZone\\Downloads\\Softwares\\geckodriver.exe");
	}

	@AfterTest
	public void afterTest() {
		try {
		d.switchTo().alert().dismiss();
		}
		catch(Exception e)
		{}
		System.out.println("Inside after Test");
		d.close();
		d.quit();
	}

}

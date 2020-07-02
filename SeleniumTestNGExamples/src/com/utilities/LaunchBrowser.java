package com.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LaunchBrowser {

	WebDriver driver = null;
	WebDriverWait wait = null;

	public WebDriver getDriver() {
		return driver;
	}

	private void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public WebDriverWait getWait() {
		return wait;
	}

	private void setWait(WebDriverWait wait) {
		this.wait = wait;
	}

	public LaunchBrowser(String driverType) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\KillZone\\Downloads\\Softwares\\chromedriver.exe");
		System.setProperty("webdriver.ie.driver", "C:\\Users\\KillZone\\Downloads\\Softwares\\IEDriverServer.exe");
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\KillZone\\Downloads\\Softwares\\geckodriver.exe");

		try {

			switch (driverType.toUpperCase()) {
			case "CHROME":
				setDriver(new ChromeDriver());
				break;
			case "FIREFOX":
				setDriver(new FirefoxDriver());
				break;
			case "IE":
				setDriver(new InternetExplorerDriver());
				break;
			}

			setWait(new WebDriverWait(driver, 10));
			driver.manage().window().maximize();

		} catch (Exception e) {
			driver = null;
			wait = null;
		}
	}

}

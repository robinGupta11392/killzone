package com.mycompany.web.utilities;

import java.util.Set;

import org.openqa.selenium.WebDriver;

public class BrowserWindowUtilities {
	private WebDriver driver;

	public void switchToTitle(String expectedTitle) {
		Set<String> windowHandles = driver.getWindowHandles();
		for (String windowHandle : windowHandles) {
			if (driver.switchTo().window(windowHandle).getTitle().equalsIgnoreCase(expectedTitle))
				break;
		}
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
}

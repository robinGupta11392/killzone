package com.mycompany.web.utilities;

import org.openqa.selenium.WebDriver;

public class ValidationUtils {
	private WebDriver driver;

	public void validateWindowTitle(String expectedTitle) {
		if (!(driver.getTitle().equalsIgnoreCase(expectedTitle)))
			throw new RuntimeException("Title Validation Failed");
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

}

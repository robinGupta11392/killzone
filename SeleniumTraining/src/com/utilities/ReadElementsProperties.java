package com.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ReadElementsProperties {

	private Properties elementProperties = new Properties();

	public ReadElementsProperties(String locationFile) throws FileNotFoundException, IOException {
		elementProperties.load(new FileInputStream(locationFile));
	}

	private String getPropertyFromFile(String elementName) {
		return elementProperties.getProperty(elementName);
	}

	public WebElement getWebElement(WebDriver driver, String elementName) {
		// WebElement element = null;

		String valueFromPropertiesFile = getPropertyFromFile(elementName);

		String[] splitValue = valueFromPropertiesFile.split(":");

		switch (splitValue[0]) {
		case "id":
			return driver.findElement(By.id(splitValue[1]));
		case "name":
			return driver.findElement(By.name(splitValue[1]));
		case "xpath":
			return driver.findElement(By.xpath(splitValue[1]));
		case "className":
			return driver.findElement(By.className(splitValue[1]));
		default:
			return null;
		}

		// return element;
	}
}

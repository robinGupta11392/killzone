package com.mycompany.web.tests.utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.mycompany.web.tests.SecondAssign;
import com.mycompany.web.utilities.LogUtils;

public class TestRunner {
	private static Properties environmentProperties;
	private static final String environmentName = "local";
	private static LogUtils log = new LogUtils();
	private static WebDriver driver;

	public static void main(String[] args) {
		try {
			injectProperties();
			loadDriverProperties();
			launchBrowser();
			setTimeouts();
			readTestData();
			executeTests();

		} catch (Exception e) {
			throw new RuntimeException("Test Runner failed to execute test cases ", e);
		} finally {
			destroyEnvironment();
		}
	}

	private static void setTimeouts() {
		log.print("Setting Implicit Wait for " + environmentProperties.getProperty("implicit.wait") + " SECONDS");
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(environmentProperties.getProperty("implicit.wait")),
				TimeUnit.SECONDS);
		log.print("Setting Page TimeOut for " + environmentProperties.getProperty("page.load.timeout") + " SECONDS");
		driver.manage().timeouts().pageLoadTimeout(
				Integer.parseInt(environmentProperties.getProperty("page.load.timeout")), TimeUnit.SECONDS);
	}

	private static void destroyEnvironment() {
		log.print("Destroying environment!!");
		if (null != driver)
			driver.quit();
	}

	private static void executeTests() {
		new SecondAssign(driver);
	}

	private static void readTestData() {
		// TODO Auto-generated method stub

	}

	private static void loadDriverProperties() {
//		System.setProperties(environmentProperties);

		Set<Entry<Object, Object>> propertyEntries = environmentProperties.entrySet();
		for (Entry<Object, Object> propertyEntry : propertyEntries) {
			if (((String) propertyEntry.getKey()).contains("webdriver")) {
				System.setProperty((String) propertyEntry.getKey(), (String) propertyEntry.getValue());
			}
		}

		log.print("System Properties loaded");
	}

	private static void launchBrowser() {
		switch (environmentProperties.getProperty("browser.type").toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		case "ie":
			driver = new InternetExplorerDriver();
			break;
		case "safari":
			driver = new SafariDriver();
			break;
		default:
			throw new RuntimeException("Browser Type is not supported");
		}
		if (null == driver)
			throw new RuntimeException("Driver object was not instantiated");
		log.print(
				"Driver Instantiated for browser : " + environmentProperties.getProperty("browser.type").toUpperCase());
	}

	private static void injectProperties() {
		FileReader reader;
		try {
			String environmentFilePath = "environment/REPLACEMEWITHENV-env.properties";
			switch (environmentName.toLowerCase()) {
			case "local":
				log.print("Selected Environment is LOCAL");
				environmentFilePath = environmentFilePath.replaceAll("REPLACEMEWITHENV", "local");
				break;
			default:
				throw new IllegalArgumentException();
			}
			log.print("Reading proerties file at : " + environmentFilePath);
			reader = new FileReader(environmentFilePath);
			environmentProperties = new Properties();
			environmentProperties.load(reader);
			printProperties();
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("Environment Name is not valid as per current configuration", e);
		} catch (FileNotFoundException e) {
			throw new RuntimeException("File Not Found while loading properties", e);
		} catch (IOException e) {
			throw new RuntimeException("File cannot be opened while loading properties", e);
		}
	}

	private static void printProperties() {
		log.print("Printing Environment Properties");
		if (null != environmentProperties)
			environmentProperties.list(System.out);
		else
			throw new RuntimeException("Environment Properties are not loaded properly");
	}

}

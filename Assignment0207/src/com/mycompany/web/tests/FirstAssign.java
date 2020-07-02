package com.mycompany.web.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.mycompany.web.utilities.BrowserWindowUtilities;
import com.mycompany.web.utilities.LogUtils;
import com.mycompany.web.utilities.ValidationUtils;

public class FirstAssign {

	private static final String XPATH_TO_URL_BUTTON = "//small[text()='http://www.phptravels.net']";
	private static final String XPATH_TO_FROM_BUTTON = "//a[contains(@href,'flights')]";
	private static final String PAGE_1_TITLE = "Demo Script Test drive - PHPTRAVELS";
	private static final String PAGE_2_TITLE = "PHPTRAVELS | Travel Technology Partner";

	private static ValidationUtils validationInstance = new ValidationUtils();
	private static BrowserWindowUtilities browserWindowUtils = new BrowserWindowUtilities();
	private static LogUtils logUtils = new LogUtils();

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"/Users/deepikaagarwal/Desktop/Programs/Selenium/BrowserDrivers/chromedriver");

		WebDriver driver = new ChromeDriver();
		validationInstance.setDriver(driver);
		browserWindowUtils.setDriver(driver);
		try {
			driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
			driver.manage().timeouts().pageLoadTimeout(5000, TimeUnit.MILLISECONDS);
			logUtils.print("Navigating to URL");
			driver.get("https://phptravels.com/demo");
			validationInstance.validateWindowTitle(PAGE_1_TITLE);
			logUtils.print("Clicking on Page Link");
			driver.findElement(By.xpath(XPATH_TO_URL_BUTTON)).click();
			Thread.sleep(10000);
			logUtils.print("Switching to window");
			browserWindowUtils.switchToTitle(PAGE_2_TITLE);
			validationInstance.validateWindowTitle(PAGE_2_TITLE);
			logUtils.print("Clicking on Flights");
			driver.findElement(By.xpath(XPATH_TO_FROM_BUTTON)).click();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver.quit();
		}
	}

}

package com.mycompany.web.tests;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.mycompany.web.pages.herokuwebsite.HomePageTheInternet;
import com.mycompany.web.pages.herokuwebsite.MultipleWindowsTheInternet;
import com.mycompany.web.pages.herokuwebsite.NewWindow;
import com.mycompany.web.utilities.BrowserWindowUtilities;
import com.mycompany.web.utilities.LogUtils;
import com.mycompany.web.utilities.TakeScreenshot;
import com.mycompany.web.utilities.ValidationUtils;

public class ThirdAssign {

	private static ValidationUtils validationUtility = new ValidationUtils();
	private static BrowserWindowUtilities windowValidation = new BrowserWindowUtilities();
	private static TakeScreenshot screenshot;
	private static LogUtils log = new LogUtils();
	private static HomePageTheInternet homePageTheInternet;
	private static MultipleWindowsTheInternet multipleWindowsTheInternet;
	private static NewWindow newWindow;

	private static final String SCREENSHOT_PATH = "screens/Assignment3";
	private static WebDriver driver;

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				"/Users/deepikaagarwal/Desktop/Programs/Selenium/BrowserDrivers/chromedriver");

		driver = new ChromeDriver();
		validationUtility.setDriver(driver);
		windowValidation.setDriver(driver);
		screenshot = new TakeScreenshot(driver, SCREENSHOT_PATH);
		homePageTheInternet = new HomePageTheInternet(driver);
		multipleWindowsTheInternet = new MultipleWindowsTheInternet(driver);
		newWindow = new NewWindow();

		try {
			driver.manage().timeouts().implicitlyWait(30000, TimeUnit.MILLISECONDS);
			driver.manage().timeouts().pageLoadTimeout(30000, TimeUnit.MILLISECONDS);

			performStep1();
			screenshot.captureScreen();
			performStep2();
			screenshot.captureScreen();
			performStep3();
			screenshot.captureScreen();
			performStep4();
			screenshot.captureScreen();
			performStep5();
			screenshot.captureScreen();
			performStep6();
			screenshot.captureScreen();
			performStep7();
			// screenshot.captureScreen(); // closing one tab
			performStep8();
			screenshot.captureScreen();
			performStep9();
			// screenshot.captureScreen(); //closing all tabs

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver.quit();
		}
	}

	private static void performStep1() {
		// Open "http://the-internet.herokuapp.com/", validate title
		driver.get("http://the-internet.herokuapp.com/");
		homePageTheInternet.validatePageTitle(validationUtility);
	}

	private static void performStep2() {
		// Click on "Multiple Windows", validate title of new window
		homePageTheInternet.clickOnMultipleWindowLink();
		homePageTheInternet.validatePageTitle(validationUtility);
	}

	private static void performStep3() {
		// Click on "Click Here", validate title of new window
		multipleWindowsTheInternet.clickOnClickHereLink();
		newWindow.switchToThisPage(windowValidation);
		newWindow.validatePageTitle(validationUtility);
	}

	private static void performStep4() {
		// Switch to other window and take screenshot
		homePageTheInternet.switchToThisPage(windowValidation);
	}

	private static void performStep5() {
		// Open a new window again by clicking "Click Here"
		multipleWindowsTheInternet.clickOnClickHereLink();
		newWindow.switchToThisPage(windowValidation);
	}

	private static void performStep6() {
		// Print all Cookies, title and window Handles of all 3 opened window
		Set<String> windowHandles = driver.getWindowHandles();

		for (String windowHandle : windowHandles) {
			driver.switchTo().window(windowHandle);
			printPageInfo(true, true, true);
		}
	}

	private static void performStep7() {
		// Close 3rd (newly opened window)
		newWindow.switchToThisPage(windowValidation);
		driver.close();
	}

	private static void performStep8() {
		// Open a new window again using "Click Here" and print all window handles
		multipleWindowsTheInternet.switchToThisPage(windowValidation);
		multipleWindowsTheInternet.clickOnClickHereLink();
		Set<String> windowHandles = driver.getWindowHandles();

		for (String windowHandle : windowHandles) {
			driver.switchTo().window(windowHandle);
			printPageInfo(false, true, false);
		}

	}

	private static void performStep9() {
		// Finally close all the windows
		driver.close();
		log.print("All tabs have been closed");
	}

	private static void printPageInfo(boolean titleflag, boolean windowIdFlag, boolean allCookiesFlag) {
		if (titleflag)
			log.print("Title is " + driver.getTitle());
		if (windowIdFlag)
			log.print("WindowHandle id is " + driver.getWindowHandle());
		if (allCookiesFlag) {
			Set<Cookie> allCookies = driver.manage().getCookies();
			for (Cookie individualCookie : allCookies) {
				log.print("Cookie name: " + individualCookie.getName() + ", Cookie value : "
						+ individualCookie.getValue());
			}
		}
	}

}

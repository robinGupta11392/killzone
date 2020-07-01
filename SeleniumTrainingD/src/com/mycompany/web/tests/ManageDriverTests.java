package com.mycompany.web.tests;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.Logs;

public class ManageDriverTests {
	public static int countOfScreenshot = 1;
	public static long pathDir = System.currentTimeMillis();

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\apps\\Selenium\\BrowserDrivers\\chromedriver.exe");
//		ChromeOptions options = new ChromeOptions();
//		options.setExperimentalOption("w3c", false);
//		WebDriver driver = new ChromeDriver(options);
		WebDriver driver = new ChromeDriver();
		try {
			driver.get("https://phptravels.com/demo/");

			demonstrateTimeOuts(driver);
			driver.get("https://www.phptravels.net/");
			System.out.println("Now finding element" + System.currentTimeMillis());
//			This results in error but after implicit wait is over i.e. 5 seconds
			driver.findElement(By.xpath("//button[@text()='Search']")).click();

			demonstrateWindowFunctions(driver);
			demonstrateCookieOperations(driver);
			demonstrateLogsOperations(driver);

			demonstrateIMEOperations(driver);

		} catch (Exception e) {
			System.out.println("Now Error" + System.currentTimeMillis());
			e.printStackTrace();
		} finally {
			System.out.println("Now Closing" + System.currentTimeMillis());
			driver.quit();
		}
	}

	private static void demonstrateIMEOperations(WebDriver driver) {
		System.out.println("Demo IME Functions");
		System.out.println(driver.manage().ime().getActiveEngine());
	}

	private static void demonstrateLogsOperations(WebDriver driver) {
		System.out.println("Demo LOGs Functions");
		Logs logs = driver.manage().logs();
		Set<String> availableLogTypes = logs.getAvailableLogTypes();
		for (String logType : availableLogTypes) {
			System.out.println(logType);
			if (logs.get(logType).getAll().size() > 0) {
				System.out.println(logs.get(logType).getAll().get(0).getTimestamp());
				System.out.println(logs.get(logType).getAll().get(0).getMessage());
			}
		}

	}

	private static void demonstrateTimeOuts(WebDriver driver) {
		System.out.println("Demo Timeouts Functions");
//		For Asynchronous Scripts, so that any script which takes more than this time will throw error
		driver.manage().timeouts().setScriptTimeout(5000, TimeUnit.MILLISECONDS);
//		For every page, any page with takes more than this time to load will result in error
		driver.manage().timeouts().pageLoadTimeout(5000, TimeUnit.MILLISECONDS);
//		For WebElements, any element action will wait for this time before throwing any error
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);

	}

	static void captureScreenNew(WebDriver driver) throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File targetFile = new File("target/ManageDriverTest_" + pathDir + "/" + (countOfScreenshot++) + ".png");
		targetFile.getParentFile().mkdirs();
		Files.copy(scrFile.toPath(), targetFile.toPath());
	}

	static void switchToParticularWindow(String titleOfWindow, WebDriver driver) {
		Set<String> windowIds = driver.getWindowHandles();
		for (String windowId : windowIds) {
			if (driver.switchTo().window(windowId).getTitle().equalsIgnoreCase(titleOfWindow))
				break;
		}
	}

	static void printAllCookies(WebDriver driver) {
		Set<Cookie> allCookies = driver.manage().getCookies();
		System.out.println("We found " + allCookies.size() + " Cookies in browser");
		for (Cookie cookie : allCookies)
			System.out.println("Cookie Name : " + cookie.getName() + " | Cookie Value : " + cookie.getValue());
	}

	static void demonstrateCookieOperations(WebDriver driver) {
		System.out.println("Printing Initial Cookies");
		printAllCookies(driver);
		Cookie sampleCookie = new Cookie("Sample", "Sample");
		driver.manage().addCookie(sampleCookie);
		System.out.println("After Adding Sample Cookie");
		printAllCookies(driver);
		driver.manage().deleteCookie(sampleCookie);
		System.out.println("After Deleting Sample Cookie by Cookie object");
		printAllCookies(driver);
		System.out.println("Printing After Fetching existing cookie by name");
		System.out.println("Cookie Found : " + driver.manage().getCookieNamed("__cfduid").getValue());
		driver.manage().deleteCookieNamed("__cfduid");
		System.out.println("Printing After deleting Cookie by Name '__cfduid'");
		printAllCookies(driver);
		System.out.println("Printing After deleting all Cookies");
		driver.manage().deleteAllCookies();
		printAllCookies(driver);
	}

	static void demonstrateWindowFunctions(WebDriver driver) throws InterruptedException {
		Point currentPosition = driver.manage().window().getPosition();
		Dimension currentDimension = driver.manage().window().getSize();
		driver.manage().window().fullscreen();
		Thread.sleep(5000);
		driver.manage().window().setPosition(currentPosition);
		Thread.sleep(1000);
		driver.manage().window().setSize(currentDimension);
		Thread.sleep(1000);
		driver.manage().window().maximize();
		Thread.sleep(5000);
	}
}

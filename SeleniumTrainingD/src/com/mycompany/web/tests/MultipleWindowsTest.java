package com.mycompany.web.tests;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.mycompany.web.utilities.StringUtils;

public class MultipleWindowsTest {
	public static int countOfScreenshot = 1;
	public static long pathDir = System.currentTimeMillis();

	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver", "C:\\apps\\Selenium\\BrowserDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		try {
			driver.get("https://phptravels.com/demo/");
			Thread.sleep(5000);
			captureScreenNew(driver);
			System.out.println("Current URL is : " + driver.getCurrentUrl());
			System.out.println("Current Title is : " + driver.getTitle());
			System.out.println("Current PageSource is : " + StringUtils.getSingleLineString(driver.getPageSource()));
			WebElement ourButton = driver.findElement(By.xpath("//small[text()='http://www.phptravels.net']"));
			System.out.println("Current Window Handle is : " + driver.getWindowHandle());
			ourButton.click();
			Thread.sleep(5000);
			captureScreenNew(driver);
			switchToParticularWindow("PHPTRAVELS | Travel Technology Partner", driver);
			System.out.println("2 Current URL is : " + driver.getCurrentUrl());
			System.out.println("2 Current Title is : " + driver.getTitle());
			System.out.println("2 Current PageSource is : " + StringUtils.getSingleLineString(driver.getPageSource()));
			System.out.println("Current Window Handle is : " + driver.getWindowHandle());
			driver.close();
			Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver.quit();
		}
	}

	static void captureScreenNew(WebDriver driver) throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File targetFile = new File("target/MultipleWindow_" + pathDir + "/" + (countOfScreenshot++) + ".png");
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

}

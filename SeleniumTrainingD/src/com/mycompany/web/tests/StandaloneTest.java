package com.mycompany.web.tests;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class StandaloneTest {
	public static int countOfScreenshot = 1;
	public static long pathDir = System.currentTimeMillis();

	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver", "C:\\apps\\Selenium\\BrowserDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://phptravels.com/demo/");
		Thread.sleep(2000);
		captureScreenNew(driver);
		driver.get("http://newtours.demoaut.com/");
		Thread.sleep(2000);
		captureScreenNew(driver);
		driver.navigate().back();
		captureScreenNew(driver);
		Thread.sleep(2000);
		driver.navigate().forward();
		Thread.sleep(2000);
		captureScreenNew(driver);
		driver.navigate().refresh();
		Thread.sleep(2000);
		captureScreenNew(driver);
		driver.navigate().to("https://www.google.com");
		Thread.sleep(2000);
		captureScreenNew(driver);
		driver.navigate().to(new URL("https://www.gmail.com"));
		Thread.sleep(2000);
		captureScreenNew(driver);
		driver.close();
	}

	static void captureScreenNew(WebDriver driver) throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File targetFile = new File("target/" + pathDir + "/" + (countOfScreenshot++) + ".png");
		targetFile.getParentFile().mkdirs();
		Files.copy(scrFile.toPath(), targetFile.toPath());
	}

}

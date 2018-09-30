package com.testpages.differentfunctions;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.utilities.LaunchBrowser;

public class ScrollingJavaScriptExample {

	static WebDriver driver;
	static WebDriverWait wait;

	public static void main(String[] args) throws AWTException, InterruptedException {
		LaunchBrowser lb = new LaunchBrowser("chrome");
		driver = lb.getDriver();
		wait = lb.getWait();

		try {

			JavascriptExecutor js = (JavascriptExecutor) driver;

			// Set Dimension for both Scrolling
			Dimension d = new Dimension(500, 500);
			driver.manage().window().setSize(d);

			driver.get("http://demo.guru99.com/test/guru99home/");
			js.executeScript("window.scrollBy(0,1000)");
			Thread.sleep(2000);
			

			// Find element by link text and store in variable "Element"
			WebElement Element = driver.findElement(By.linkText("Linux"));

			// This will scroll the page till the element is found
			js.executeScript("arguments[0].scrollIntoView();", Element);

			Thread.sleep(2000);

			// This will scroll the web page till end.
			driver.manage().window().maximize();
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			Thread.sleep(1000);

//			For Horizontal Scrolling
			// Launch the application
			driver.get("http://demo.guru99.com/test/guru99home/scrolling.html");
			Element = driver.findElement(By.linkText("VBScript"));

			// This will scroll the page Horizontally till the element is found
			js.executeScript("arguments[0].scrollIntoView();", Element);
			Thread.sleep(1000);
			
			js.executeScript("window.scrollBy(1000,0)");
			Thread.sleep(2000);

			System.out.println("Test Passed");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Test Failed");
		} finally {
			driver.quit();
		}

	}

}

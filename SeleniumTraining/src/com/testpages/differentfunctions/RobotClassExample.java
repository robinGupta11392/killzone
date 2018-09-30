package com.testpages.differentfunctions;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.utilities.LaunchBrowser;

public class RobotClassExample {
	
	static WebDriver driver;
	static WebDriverWait wait;

	public static void main(String[] args) throws AWTException {
		LaunchBrowser lb = new LaunchBrowser("chrome");
		driver = lb.getDriver();
		wait  = lb.getWait();
		
		try {
		
		driver.get("https://the-internet.herokuapp.com/download");
		
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.linkText("test.txt"))).contextClick().build().perform();
		
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_DOWN);r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_DOWN);r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_DOWN);r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_DOWN);r.keyRelease(KeyEvent.VK_DOWN);
		r.delay(2000);
		r.keyPress(KeyEvent.VK_ENTER);r.keyRelease(KeyEvent.VK_ENTER);
		
		r.keyPress(KeyEvent.VK_A);r.keyRelease(KeyEvent.VK_A);
		r.keyPress(KeyEvent.VK_A);r.keyRelease(KeyEvent.VK_A);
		r.keyPress(KeyEvent.VK_PERIOD);r.keyRelease(KeyEvent.VK_PERIOD);
		r.keyPress(KeyEvent.VK_T);r.keyRelease(KeyEvent.VK_T);
		r.keyPress(KeyEvent.VK_X);r.keyRelease(KeyEvent.VK_X);
		r.keyPress(KeyEvent.VK_T);r.keyRelease(KeyEvent.VK_T);
		r.delay(2000);
		
		r.keyPress(KeyEvent.VK_TAB);r.keyRelease(KeyEvent.VK_TAB);
		r.keyPress(KeyEvent.VK_TAB);r.keyRelease(KeyEvent.VK_TAB);
		r.keyPress(KeyEvent.VK_TAB);r.keyRelease(KeyEvent.VK_TAB);
		r.keyPress(KeyEvent.VK_ENTER);r.keyRelease(KeyEvent.VK_ENTER);
		
		System.out.println("Test Passed");
		}
		catch(Exception e) {
			e.printStackTrace();
			driver.quit();
		}
		
		

	}

}

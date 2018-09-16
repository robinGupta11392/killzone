package com.testpages.differentfunctions;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleWindowHandlerDemo {

	static WebDriver d = null;

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\KillZone\\Downloads\\Softwares\\chromedriver.exe");
		d = new ChromeDriver();
		d.get("https://www.facebook.com/");
		
		String mainWin = d.getWindowHandle();
		
		System.out.println(mainWin);
		
		d.findElement(By.linkText("Data Policy")).click();
		
		Thread.sleep(2000);
		
		d.switchTo().window(mainWin);
		
		d.findElement(By.linkText("Cookie Policy")).click();
		Thread.sleep(1000);
		
		String childWindow = d.getWindowHandle();
		System.out.println(childWindow);
		
		Set <String> allWindows = d.getWindowHandles();
		
		System.out.println(allWindows.size());
		for(String x : allWindows)
		{
			if(!(x.equals(mainWin)))
			{
				d.switchTo().window(x);
				System.out.println("In " + d.getTitle() + " window");
				d.findElement(By.linkText("Facebook Products")).click();
			}
			else
			{
				System.out.println("In Parent : " + d.getTitle() + " window");
			}
				
		}
		
		System.out.println("PASS");
		
		
		d.close();
		d.quit();
		
		

	}

}

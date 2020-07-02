package com.testpages.differentfunctions;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertHandling {

	static WebDriver d = null;
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\KillZone\\Downloads\\Softwares\\chromedriver.exe");
		d = new ChromeDriver();
		d.get("http://ksrtc.in/oprs-web/");
		d.findElement(By.id("searchBtn")).click();
		Thread.sleep(1000);
		
		if(isAlertPresent())
		{
			d.switchTo().alert().accept();
			System.out.println("Alert Found!!");
		}else
			System.out.println("Alert not found!!");
		
		d.close();

	}
	
	public static boolean isAlertPresent() 
	{ 
	    try 
	    { 
	        d.switchTo().alert(); 
	        return true; 
	    }   // try 
	    catch (NoAlertPresentException Ex) 
	    { 
	        return false; 
	    }   // catch 
	}

}

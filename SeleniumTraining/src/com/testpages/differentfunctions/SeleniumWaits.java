package com.testpages.differentfunctions;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Stopwatch;

public class SeleniumWaits {
	
	static WebDriver d = null;
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\KillZone\\Downloads\\Softwares\\chromedriver.exe");
		d = new ChromeDriver();
//		d.get("http://ksrtc.in/oprs-web/");
		d.get("http://newtours.demoaut.com/");
		
		Stopwatch wt = null;
		
		try {
		
//		Implicit Wait
		d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		d.findElement(By.xpath("//input[@name='userName']")).sendKeys("swathi");
		d.findElement(By.xpath("//input[@name='password']")).sendKeys("swathi");
		
//		Explicit Wait
		WebDriverWait w = new WebDriverWait(d, 20);
		wt=Stopwatch.createStarted();
		WebElement wEle = w.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@value='Login']")));
		wEle.click();
		wt.stop();
		
//		Fluent Wait
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(d);
		wait.withTimeout(15, TimeUnit.SECONDS);
		wait.pollingEvery(2, TimeUnit.SECONDS);
		
		wt = Stopwatch.createStarted();
		WebElement element = wait.until(new Function<WebDriver, WebElement>(){
			public WebElement apply(WebDriver arg0) {
				WebElement e = arg0.findElement(By.xpath("//input[@value='Login']"));
				if(e.getAttribute("defaultValue").equalsIgnoreCase("Login"))
					{System.out.println("FOUND");return e;}
				else
					return null;
			}
		});
		
		wt.stop();
		System.out.println("FOUND");
		element.click();
		
		}
		catch(Exception e) {
			wt.stop();
			System.out.println(wt.elapsed(TimeUnit.SECONDS));
			
		}
		finally {
			System.out.println(wt.elapsed(TimeUnit.SECONDS));
			d.close();
		}
	}

}

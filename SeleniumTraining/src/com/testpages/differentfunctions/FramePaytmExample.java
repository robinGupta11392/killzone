package com.testpages.differentfunctions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FramePaytmExample {

	static WebDriver d = null;

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\KillZone\\Downloads\\Softwares\\chromedriver.exe");
		d = new ChromeDriver();
		d.get("https://paytm.com/");
		Thread.sleep(2000);
		d.findElement(By.xpath("//div[@class='_3ac-']")).click();
		System.out.println("Clicked");
		Thread.sleep(2000);

		if (isFramePresent("//input[@name='username']", "element")) {
			d.findElement(By.xpath("//input[@name='username']")).sendKeys("abc@abc.com");
			d.findElement(By.xpath("//input[@name='password']")).sendKeys("abc");
			d.findElement(By.xpath("//button[@type=\"submit\"]")).click();
			Thread.sleep(1000);
			d.switchTo().parentFrame();
			d.findElement(By.xpath("//a[@title='Close']")).click();
		} else
			System.out.println("Frame Not Available");
		
		d.close();

	}

	static boolean isFramePresent(String frameName, String locator) {
		try {
			switch (locator) {
			case "index":
				d.switchTo().frame(Integer.parseInt(frameName));
				return true;
			case "name":
				d.switchTo().frame(frameName);
				return true;
			case "element":
				int size = d.findElements(By.tagName("iframe")).size();

				for (int i = 0; i <= size; i++) {
					d.switchTo().frame(i);
					int total = d.findElements(By.xpath(frameName)).size();
					// System.out.println(total);
					if (total > 0) {
						return true;
					}
					d.switchTo().defaultContent();
				}
			default:
				return false;
			}
		} catch (

		Exception e) {
			return false;
		}
	}

}

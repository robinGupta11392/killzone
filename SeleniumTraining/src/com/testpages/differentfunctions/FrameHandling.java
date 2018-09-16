package com.testpages.differentfunctions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameHandling {

	static WebDriver d = null;

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\KillZone\\Downloads\\Softwares\\chromedriver.exe");
		d = new ChromeDriver();
		d.get("http://demo.guru99.com/test/guru99home/");
		Thread.sleep(1000);

		if (isFramePresent("0", "index")) {
			System.out.println("Frame Found!!");
		} else
			System.out.println("Frame not found!!");

		if (isFramePresent("a077aa5e", "name")) {
			System.out.println("Frame Found!!");
		} else
			System.out.println("Frame not found!!");

		if (isFramePresent("//img[@src='Jmeter720.png']", "element")) {
			System.out.println("Frame Found!!");
		} else
			System.out.println("Frame not found!!");

		d.close();

	}

	static boolean isFramePresent(String frameName, String locator) {
		try {
			switch (locator) {
			case "index":
				d.switchTo().frame(Integer.parseInt(frameName));
				d.switchTo().parentFrame();
				return true;
			case "name":
				d.switchTo().frame(frameName);
				d.switchTo().parentFrame();
				return true;
			case "element":
				int size = d.findElements(By.tagName("iframe")).size();

				for (int i = 0; i <= size; i++) {
					d.switchTo().frame(i);
					int total = d.findElements(By.xpath(frameName)).size();
//					System.out.println(total);
					if (total > 0) {
						d.switchTo().defaultContent();
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

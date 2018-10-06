package com.testpages.differentfunctions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.hotkey.Keys;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class SikuliExample {

	public static void main(String[] args) throws FindFailed, InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\KillZone\\Downloads\\Softwares\\chromedriver.exe");
		WebDriver d = new ChromeDriver();
		d.get("https://www.google.com/");
		
		Screen searchBox = new Screen();
		Pattern searchBoxInput = new Pattern("SikuliImages\\GoogleSearchBox.JPG");
		searchBox.type(searchBoxInput, "Hello" + Keys.ENTER);
		System.out.println("Test Passed");
		Thread.sleep(2000);
		d.quit();

	}

}

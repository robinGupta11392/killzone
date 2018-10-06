package com.testpages.differentfunctions;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class GridTesting {

	public static void main(String[] args) throws MalformedURLException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\KillZone\\Downloads\\Softwares\\chromedriver.exe");
		String hubURL = "http://192.168.0.125:4444/wd/hub";
		String launchURL = "https://www.google.com/";
		
		@SuppressWarnings("static-access")
		DesiredCapabilities cap = new DesiredCapabilities().chrome();
		
		WebDriver driver = new RemoteWebDriver(new URL(hubURL), cap);
		
		driver.get(launchURL);
		
		driver.quit();
		
		
				
		

	}

}

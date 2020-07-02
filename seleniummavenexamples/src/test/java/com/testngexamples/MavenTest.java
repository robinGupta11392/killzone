package com.testngexamples;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class MavenTest {
  @Test
  public void sampleLaunch() {
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\KillZone\\Downloads\\Softwares\\chromedriver.exe");
	  WebDriver driver = new ChromeDriver();
	  driver.get("https://www.google.com/");
	  driver.quit();
	  System.out.println("Test Passed");
  }
}

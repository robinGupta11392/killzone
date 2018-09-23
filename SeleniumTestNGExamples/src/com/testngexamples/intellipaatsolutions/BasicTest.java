package com.testngexamples.intellipaatsolutions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BasicTest {
  @Test
  public void printHello() {
	  
//	  Basic printing
//	  System.out.println("Testing... Hello World!!");
	  
//	  Strings for Assert Example
//	  String s1 = "Hello";
//	  String s2 = "hello";
	  
//	  Below will fail	  
//	  Assert.assertEquals(s1, s2);
	  
//	  Below will pass	  
//	  Assert.assertEquals(s1.toLowerCase(),s2.toLowerCase());
	  
//	  Below will fail
//	  Assert.assertTrue(s1==s2, "String \""+ s1 +"\" is not equal to \"" + s2 + "\", Hence failing the test");
	  
//	  Below example to assert title
	  WebDriver d = null;
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\KillZone\\Downloads\\Softwares\\chromedriver.exe");
		d = new ChromeDriver();
		d.get("http://www.gmail.com/");
		String actualTitle = d.getTitle();
		Assert.assertEquals(actualTitle, "Gmail");
		d.close();
	  
	  
	  
	 
  }
}

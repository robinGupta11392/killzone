/*
BeforeClass - will run before loading class
AfterClass - will run after loading class

without priority Tests run in alphabetical order
*/

package com.testngexamples.intellipaatsolutions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BeforeAndAfterExample {
	
//	Below example for sample WebDriver
	/*WebDriver d = null;

	@BeforeClass
	public void launch() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\KillZone\\Downloads\\Softwares\\chromedriver.exe");
		d = new ChromeDriver();
		System.out.println("Launch Done");
	}
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("before Test Done");
	}

	@Test
	public void google() {
		d.get("https://www.google.com/");
		System.out.println("Google Done");
	}

	@Test
	public void facebook() {
		d.get("https://www.facebook.com/");
		System.out.println("Facebook Done");
	}
	
	@AfterTest
	public void afterTest() {
		System.out.println("after Test Done");
	}

	@AfterClass
	public void logout() {
		d.close();
		System.out.println("Logout Done");
	}*/
	
//	Below example for Before and After
	
	/*Output Console
	[RemoteTestNG] detected TestNG version 6.14.2
	BeforeSuite done
	BeforeTest Done
	BeforeClass Done
	BeforeMethod done
	TestFacebook Done
	AfterMethods Done
	BeforeMethod done
	TestGoogle Done
	AfterMethods Done
	AfterClass Done
	AfterTest Done
	PASSED: facebook
	PASSED: google

	===============================================
	    Default test
	    Tests run: 2, Failures: 0, Skips: 0
	===============================================

	AfterSuite Done

	===============================================
	Default suite
	Total tests run: 2, Failures: 0, Skips: 0
	===============================================
*/

	@BeforeClass
	public void launch() {
		System.out.println("BeforeClass Done");
	}
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("BeforeTest Done");
	}
	
	@BeforeGroups
	public void beforeGroups() {
		System.out.println("BeforeGroups done");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("BeforeMethod done");
	}
	
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("BeforeSuite done");
	}

	@Test
	public void google() {
		System.out.println("TestGoogle Done");
	}

	@Test
	public void facebook() {
		System.out.println("TestFacebook Done");
	}
	
	@AfterGroups
	public void afterGroups() {
		System.out.println("AfterGroups Done");
	}
	
	@AfterMethod
	public void afterMethods() {
		System.out.println("AfterMethods Done");
	}
	
	@AfterSuite
	public void afterSuite() {
		System.out.println("AfterSuite Done");
	}
	
	@AfterTest
	public void afterTest() {
		System.out.println("AfterTest Done");
	}

	@AfterClass
	public void logout() {
		System.out.println("AfterClass Done");
	}
}

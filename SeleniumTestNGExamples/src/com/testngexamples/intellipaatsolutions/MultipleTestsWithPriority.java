/*// Dependency - Depends on
It will run test only when the depends on methods for the same test will pass otherwise it'll skip
In the below example it will run Launch then Login and login will fail due to which compose and logout will be skipped*/

package com.testngexamples.intellipaatsolutions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class MultipleTestsWithPriority {
	
//	Below Code is for priority
	/*@Test(priority = 1)
	public void launch() {
		System.out.println("Launch Done");
		Assert.assertEquals('A', 'A');
	}

	@Test(priority = 1, dependsOnMethods = { "launch" })
	public void login() {
		System.out.println("Login Done");
		Assert.assertEquals('A', 'a');
	}

	@Test(priority = 1, dependsOnMethods = { "login" })
	public void compose() {
		System.out.println("Composing Done");
		Assert.assertEquals('A', 'A');
	}

	@Test(priority = 1, dependsOnMethods = { "compose" })
	public void logout() {
		System.out.println("Logout Done");
		Assert.assertEquals('A', 'A');
	}*/
	
//	Below code is without priority - all dependency should not have priority
	/*@Test
	public void launch() {
		System.out.println("Launch Done");
		Assert.assertEquals('A', 'A');
	}

	@Test(dependsOnMethods = { "launch" })
	public void login() {
		System.out.println("Login Done");
		Assert.assertEquals('A', 'a');
	}

	@Test(dependsOnMethods = { "login" })
	public void compose() {
		System.out.println("Composing Done");
		Assert.assertEquals('A', 'A');
	}

	@Test(dependsOnMethods = { "compose" })
	public void logout() {
		System.out.println("Logout Done");
		Assert.assertEquals('A', 'A');
	}*/
	
	WebDriver d = null;
//	Below code for multiple dependency
	@Test(priority = 1)
	public void launch() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\KillZone\\Downloads\\Softwares\\chromedriver.exe");
		d = new ChromeDriver();
		System.out.println("Launch Done");
	}

	@Test(priority = 2)
	public void google() {
		d.get("https://www.google.com/");
		System.out.println("Google Done");
	}

	@Test(priority = 3)
	public void facebook() {
		d.get("https://www.facebook.com/");
		System.out.println("Facebook Done");
	}

	@Test(priority = 4)
	public void logout() {
		d.close();
		System.out.println("Logout Done");
	}
}

/*
Group test cases
*/

package com.testngexamples.intellipaatsolutions;

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

public class GroupingExample {
	
//	Below example for Before and After
	
	/*Output Console
	
*/

	@BeforeClass(groups = {"SmokeTest", "functional", "RegressionTest"})
	public void launch() {
		System.out.println("BeforeClass2 Done");
	}
	
	@BeforeTest(groups = {"SmokeTest", "functional", "RegressionTest"})
	public void beforeTest() {
		System.out.println("BeforeTest2 Done");
	}
	
	@BeforeGroups(groups = {"SmokeTest", "functional", "RegressionTest"})
	public void beforeGroups() {
		System.out.println("BeforeGroups2 Done");
	}
	
	@BeforeMethod(groups = {"SmokeTest", "functional", "RegressionTest"})
	public void beforeMethod() {
		System.out.println("BeforeMethod2 Done");
	}
	
	@BeforeSuite(groups = {"SmokeTest", "functional", "RegressionTest"})
	public void beforeSuite() {
		System.out.println("BeforeSuite2 Done");
	}

	@Test(groups = {"SmokeTest", "functional"})
	public void google() {
		System.out.println("TestGoogle2 Done");
	}

	@Test(groups = {"SmokeTest"})
	public void facebook() {
		System.out.println("TestFacebook2 Done");
	}
	
	@Test(groups = {"RegressionTest", "functional"})
	public void newtours() {
		System.out.println("TestNewTours2 Done");
	}
	
	@Test(groups = {"RegressionTest"})
	public void aix() {
		System.out.println("TestAIX2 Done");
	}
	
	@AfterGroups(groups = {"SmokeTest", "functional", "RegressionTest"})
	public void afterGroups() {
		System.out.println("AfterGroups2 Done");
	}
	
	@AfterMethod(groups = {"SmokeTest", "functional", "RegressionTest"})
	public void afterMethods() {
		System.out.println("AfterMethods2 Done");
	}
	
	@AfterSuite(groups = {"SmokeTest", "functional", "RegressionTest"})
	public void afterSuite() {
		System.out.println("AfterSuite2 Done");
	}
	
	@AfterTest(groups = {"SmokeTest", "functional", "RegressionTest"})
	public void afterTest() {
		System.out.println("AfterTest2 Done");
	}

	@AfterClass(groups = {"SmokeTest", "functional", "RegressionTest"})
	public void logout() {
		System.out.println("AfterClass2 Done");
	}
}

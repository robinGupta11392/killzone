package com.testngexamples.intellipaatsolutions;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

public class DataProviderExample {

	@Test(dataProvider = "sampleData")
	public void launchBrowser(Integer n, String s) {
		System.out.println(n + " " + s);
	}

	@DataProvider(name = "sampleData")
	public Object[][] mydata() {
		return new Object[][] { { 1, "a" }, { 2, "b" }, { 3, "b" } };
	}

}

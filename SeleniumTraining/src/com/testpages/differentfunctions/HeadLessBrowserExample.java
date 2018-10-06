package com.testpages.differentfunctions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class HeadLessBrowserExample {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		WebDriver d = new HtmlUnitDriver();
		d.get("https://www.google.com/");
//		TakeScreenshot.captureScreenNew(d);
		System.out.println("TestPassed");
		d.quit();
		

	}

}

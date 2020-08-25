package com.mycompany.web.utilities;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.google.common.io.Files;

public class TakeScreenshot {
	private WebDriver driver;
	private String basePath;
	private int counter = 1;
	private long currentTime = System.currentTimeMillis();

	public TakeScreenshot(WebDriver driver, String basePath) {
		this.driver = driver;
		this.basePath = basePath;
	}

	public void captureScreen() {
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String filePath = basePath + "/" + currentTime + "/" + (counter++) + ".png";
		File target = new File(filePath);

		target.getParentFile().mkdirs();
		try {
			Files.copy(srcFile, target);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

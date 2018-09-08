package com.training.utilities;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Random;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TakeScreenshot {
	static int countOfScreenshot=1;
	public static void captureScreen(WebDriver driver) throws IOException
	{
//		String timestamp=String.valueOf(countOfScreenshot++);
		
//		Testing random Code
		Random r = new Random();
		String timestamp=String.valueOf(r.nextLong());
		
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        Files.copy(scrFile.toPath(),(new File("Screenshots/"+timestamp+".png")).toPath());
	}

}

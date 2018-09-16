package com.utilities;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Random;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TakeScreenshot {
	public static int countOfScreenshot=1;
	
	public static long pathDir = System.currentTimeMillis();
	
//	public static String timestamp = null;
	
	public static void captureScreen(WebDriver driver) throws IOException
	{
		
//		Testing random Code
		Random r = new Random();
		String timestamp=String.valueOf(r.nextLong());
		
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        Files.copy(scrFile.toPath(),(new File("Screenshots/"+timestamp+".png")).toPath());
	}
	
	public static void captureScreenNew(WebDriver driver) throws IOException
	{
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);        
        File targetFile = new File("Screenshots/"+pathDir+"/"+ (countOfScreenshot++) +".png");
        targetFile.getParentFile().mkdirs();
        Files.copy(scrFile.toPath(),targetFile.toPath());
	}

}

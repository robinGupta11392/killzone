package com.training;

import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.facebook.pages.LoginPage;
import com.training.utilities.CreateHTMLReport;
import com.training.utilities.TakeScreenshot;

public class FacebookTestCase1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\KillZone\\Downloads\\Softwares\\chromedriver.exe");
		System.setProperty("webdriver.ie.driver", "C:\\Users\\KillZone\\Downloads\\Softwares\\IEDriverServer.exe");
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\KillZone\\Downloads\\Softwares\\geckodriver.exe");
		WebDriver d = null;
		WebDriverWait wait = null;

		String driverType = "ch";
		String status = "PASSED";
		String log="";
		
		String timestamp = String.valueOf(new Date());

		try {

			switch (driverType.toUpperCase()) {
			case "CH":
				d = new ChromeDriver();
				break;
			case "FF":
				d = new FirefoxDriver();
				break;
			default:
				d = new InternetExplorerDriver();
				break;
			}

			wait = new WebDriverWait(d, 10);

			d.manage().window().maximize();

			LoginPage lp = new LoginPage(d, wait);
			lp.doLogin("abc123123", "abc");
			
		} catch (Exception e) {
			status="FAILED";
			 log = e.getMessage();
		} finally {
			d.close();			
		}
		
		CreateHTMLReport report = new CreateHTMLReport();
		report.setTemplate("SampleReport1");
		report.prepareReport("Facebook Report", status, timestamp , TakeScreenshot.pathDir, (TakeScreenshot.countOfScreenshot-1),log);
	}

}

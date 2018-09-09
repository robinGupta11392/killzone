package com.training;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.facebook.pages.LoginPage;

public class FacebookTestCase1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\KillZone\\Downloads\\Softwares\\chromedriver.exe");
		System.setProperty("webdriver.ie.driver", "C:\\Users\\KillZone\\Downloads\\Softwares\\IEDriverServer.exe");
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\KillZone\\Downloads\\Softwares\\geckodriver.exe");
		WebDriver d = null;
		WebDriverWait wait = null;

		String driverType = "ie";

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
			lp.doLogin("abc", "abc");

			System.out.println("TEST Success!!");
		} catch (Exception e) {
			System.out.println("TEST Failed!!");
			e.printStackTrace();
		} finally {
			d.close();
		}
	}

}

package com.training;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.newtours.pages.HomePage;
import com.newtours.pages.LoginPage;
import com.newtours.pages.SearchPage;

public class TestCase1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Users\\KillZone\\Downloads\\Softwares\\chromedriver.exe");
		WebDriver d = null;
		WebDriverWait wait=null;
		try {
		d = new ChromeDriver();
		wait=new WebDriverWait(d, 10);
		
		d.manage().window().maximize();
		
		HomePage hp = new HomePage(d,wait);
		if(!(hp.launchPage()))
				System.out.println("LAUNCH FAILURE");
		
		LoginPage lp = new LoginPage(d,wait);
		lp.enterCredentials("swathi", "swathi");
		
		SearchPage sp = new SearchPage(d,wait);
		sp.searchBooking("OneWay", "2", "Frankfurt", "Business");
		
		System.out.println("TEST Success!!");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally {
			d.close();	
		}		
	}

}

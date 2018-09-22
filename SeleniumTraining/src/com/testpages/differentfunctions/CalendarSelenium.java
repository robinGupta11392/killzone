package com.testpages.differentfunctions;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalendarSelenium {
	static WebDriver d = null;
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\KillZone\\Downloads\\Softwares\\chromedriver.exe");
		d = new ChromeDriver();
		d.get("http://ksrtc.in/oprs-web/");
		
		Date date=new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MMMMM");
		date.setMonth(date.getMonth() + 1);
		String outmonth = sdf.format(date);
		System.out.println(outmonth);
		
		d.findElement(By.id("txtJourneyDate")).click();
		Thread.sleep(1000);
		
		d.findElement(By.xpath("//a[text()=\"29\"]")).click();
		
		d.findElement(By.id("txtJourneyDate")).click();
		Thread.sleep(1000);
		
		d.findElement(By.xpath("//a[text()=\"30\"]")).click();
		
		Thread.sleep(5000);
		
		d.findElement(By.id("txtJourneyDate")).click();
		Thread.sleep(1000);	
		
		
		
//		Select October 20
		for(int i=0;i<10;i++)
		{
			if(d.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText().contains(outmonth))
				break;
			else
				d.findElement(By.xpath("//a[@title=\"Next\"]")).click();
			Thread.sleep(1000);
		}
		
		d.findElement(By.xpath("//a[text()=\"20\"]")).click();
		Thread.sleep(10000);		
		d.close();

	}

}

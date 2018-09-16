package com.newtours.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.utilities.TakeScreenshot;

public class SearchPage {
	WebDriver driver;
	WebDriverWait wait;

	String bookingType;
	String numberOfPassengers;
	String departingFrom;
	String serviceClass;

	public SearchPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}

	public void searchBooking(String bookingType,String numberOfPassengers, String departingFrom, String serviceClass) throws IOException {
		
		this.bookingType=bookingType;
		this.numberOfPassengers=numberOfPassengers;
		this.departingFrom= departingFrom;
		this.serviceClass= serviceClass;
		
		selectBookingType();
		selectnumberOfPassengers();
		selectDepartingFrom();
		selectServiceClass();
		TakeScreenshot.captureScreen(driver);
		submit();
		if(!validateSearch())
			System.out.println("SEARCH FAILED");
		TakeScreenshot.captureScreen(driver);
	}

	private void submit() {
		// TODO Auto-generated method stub
		driver.findElement(By.xpath("//input[@name='findFlights']")).click();
	}

	private void selectServiceClass() {
		// TODO Auto-generated method stub
		switch (serviceClass) {
		case "Economy":
			driver.findElement(By.xpath("//input[@value='Coach']")).click();
			break;
		case "Business":
			driver.findElement(By.xpath("//input[@value='Business']")).click();
			break;
		default:
			driver.findElement(By.xpath("//input[@value='First']")).click();
			break;
		}
	}

	private void selectDepartingFrom() {
		// TODO Auto-generated method stub
		
		Select departFrom =  new Select(driver.findElement(By.xpath("//select[@name='fromPort']")));
		departFrom.selectByVisibleText(departingFrom);
	}

	private void selectnumberOfPassengers() {
		// TODO Auto-generated method stub
			Select numOfPass =  new Select(driver.findElement(By.xpath("//select[@name='passCount']")));
			numOfPass.selectByVisibleText(numberOfPassengers);
	}

	private void selectBookingType() {
		// TODO Auto-generated method stub
		switch (bookingType) {
		case "OneWay":
			driver.findElement(By.xpath("//input[@value='oneway']")).click();
			break;
		default:
			driver.findElement(By.xpath("//input[@value='roundtrip']")).click();
			break;
		}
	}
	private boolean validateSearch() {
		// TODO Auto-generated method stub
		return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@src='/images/masts/mast_selectflight.gif']"))) != null;
	}

}

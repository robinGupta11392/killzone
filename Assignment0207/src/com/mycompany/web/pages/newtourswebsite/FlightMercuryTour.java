package com.mycompany.web.pages.newtourswebsite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FlightMercuryTour {
	private final String XPATH_TO_CLICK_ON_FLIGHT = "//a[contains(text(),'Flights')]";
	private WebDriver driver;
	private WebElement flightLink;
	
	public FlightMercuryTour(WebDriver driver) {
		this.driver = driver;
	}
	
	private void setElementFlightLink() {
		flightLink = driver.findElement(By.xpath(XPATH_TO_CLICK_ON_FLIGHT));
	}
	
	public void clickOnFlightLink() {
		setElementFlightLink();
		flightLink.click();
	}
}

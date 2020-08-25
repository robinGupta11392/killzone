package com.mycompany.web.pages.newtourswebsite;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FlightFinderMercuryTour {

	private final String XPATH_TO_FLIGHT_FINDER = "//img[contains(@src,'flightfinder')]";
	private final String XPATH_TO_SELECT_ONEWAY_OPTION = "//input[@value='oneway']";
	private WebDriver driver;
	private WebElement oneWayButton;
	private WebElement continueButton;

	public FlightFinderMercuryTour(WebDriver driver) {
		this.driver = driver;
	}

	public void checkElementFlightFinder() {
		try {
			driver.findElement(By.xpath(XPATH_TO_FLIGHT_FINDER));
		} catch (NoSuchElementException nsee) {
			throw new RuntimeException("Error message: Flight Finder not found");
		}
	}

	private void setElementSelectOneWayButton() {
		oneWayButton = driver.findElement(By.xpath(XPATH_TO_SELECT_ONEWAY_OPTION));
	}

	public void clickOnSelectOneWayButton() {
		setElementSelectOneWayButton();
		oneWayButton.click();
	}

	private void setElementContinueButton() {
		continueButton = driver.findElement(By.name("findFlights"));
	}

	public void clickOnContinueButton() {
		setElementContinueButton();
		continueButton.click();
	}
}

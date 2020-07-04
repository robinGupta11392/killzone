package com.mycompany.web.pages.newtourswebsite;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SelectFlightMercuryTour {

	private final String XPATH_TO_SELECTFLIGHT_TEXT = "//img[contains(@src,'selectflight')]";
	private final String XPATH_TO_CONTINUE_BUTTON = "reserveFlights";
	private WebDriver driver;
	private WebElement continueClick;

	public SelectFlightMercuryTour(WebDriver driver) {
		this.driver = driver;
	}

	public void checkElementSelectFlightText() {
		try {
			driver.findElement(By.xpath(XPATH_TO_SELECTFLIGHT_TEXT));
		} catch (NoSuchElementException nsee) {
			throw new RuntimeException("Error message: Select Flight not found");
		}
	}

	private void setElementContinueButton() {
		continueClick = driver.findElement(By.name(XPATH_TO_CONTINUE_BUTTON));
	}

	public void clickOnContinueButton() {
		setElementContinueButton();
		continueClick.click();
	}

}

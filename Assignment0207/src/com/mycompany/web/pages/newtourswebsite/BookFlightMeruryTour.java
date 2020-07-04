package com.mycompany.web.pages.newtourswebsite;

import org.openqa.selenium.WebDriver;

public class BookFlightMeruryTour {

	private final String TITLE = "Book a Flight";
	private WebDriver driver;
	

	public BookFlightMeruryTour(WebDriver driver) {
		this.driver = driver;
	}
	
	public void checkBookAFlightText() {
		if(driver.getTitle().contains(TITLE))
			return;
		else
			throw new RuntimeException("Error message: Book A Flight text not found");
	}
	
	
}

package com.mycompany.web.pages.newtourswebsite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.mycompany.web.utilities.BrowserWindowUtilities;
import com.mycompany.web.utilities.ValidationUtils;

public class HomePageMercuryTour {

	
	private final String TITLE = "Welcome: Mercury Tours";
	private final String XPATH_TO_REGISTER_LINK = "//a[contains(text(),'REGISTER')]";
	private WebDriver driver;
	private WebElement registerLink;
	
	public HomePageMercuryTour(WebDriver driver) {
		this.driver = driver;
	}

	private void setElementRegisterLink() {
		registerLink = driver.findElement(By.xpath(XPATH_TO_REGISTER_LINK));
	}

	public void clickOnRegisterLink() {
		setElementRegisterLink();
		registerLink.click();
	}

	public void validatePageTitle(ValidationUtils utility) {
		utility.validateWindowTitle(TITLE);
	}

	public void switchToThisPage(BrowserWindowUtilities browserUtils) {
		browserUtils.switchToTitle(TITLE);
	}

}

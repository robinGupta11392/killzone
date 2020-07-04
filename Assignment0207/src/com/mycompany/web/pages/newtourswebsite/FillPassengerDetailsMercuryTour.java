package com.mycompany.web.pages.newtourswebsite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FillPassengerDetailsMercuryTour {

	private final String firstName = "passFirst0";
	private final String lastName = "passLast0";
	private final String cardNumber = "creditnumber";
	private final String XPATH_TO_HOME_LINK = "//a[@href='mercurywelcome.php']";
	private WebElement homeLink;
	private WebDriver driver;

	public FillPassengerDetailsMercuryTour(WebDriver driver) {
		this.driver = driver;
	}

	public void fillPassengerDetails(String dataRead) {
		String[] value = dataRead.split(",");
		driver.findElement(By.name(firstName)).sendKeys(value[0]);
		driver.findElement(By.name(lastName)).sendKeys(value[1]);
		driver.findElement(By.name(cardNumber)).sendKeys(value[2]);
	}

	private void setElementHomeLink() {
		homeLink = driver.findElement(By.xpath(XPATH_TO_HOME_LINK));
	}

	public void clickOnHomeLink() {
		setElementHomeLink();
		homeLink.click();
	}
}

package com.mycompany.web.pages.herokuwebsite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.mycompany.web.utilities.BrowserWindowUtilities;
import com.mycompany.web.utilities.ValidationUtils;

public class MultipleWindowsTheInternet {

	private final String TITLE = "The Internet";
	private final String XPATH_CLICK_HERE_LINK = "//a[contains(@href,'windows/new')]";
	private WebElement clickHereLink;
	private WebDriver driver;

	public MultipleWindowsTheInternet(WebDriver driver) {
		this.driver = driver;
	}

	private void setElementClickHereLink() {
		clickHereLink = driver.findElement(By.xpath(XPATH_CLICK_HERE_LINK));
	}

	public void clickOnClickHereLink() {
		setElementClickHereLink();
		clickHereLink.click();
	}

	public void validatePageTitle(ValidationUtils utility) {
		utility.validateWindowTitle(TITLE);
	}

	public void switchToThisPage(BrowserWindowUtilities browserUtils) {
		browserUtils.switchToTitle(TITLE);
	}
}

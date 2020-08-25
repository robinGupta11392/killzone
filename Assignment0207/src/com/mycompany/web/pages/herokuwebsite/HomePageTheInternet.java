package com.mycompany.web.pages.herokuwebsite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.mycompany.web.utilities.BrowserWindowUtilities;
import com.mycompany.web.utilities.ValidationUtils;

public class HomePageTheInternet {

	private final String TITLE = "The Internet";
	private final String XPATH_MULTIPLE_WINDOW_LINK = "//a[contains(text(),'Multiple Windows')]";
	private WebElement multipleWIndowLink;
	private WebDriver driver;

	public HomePageTheInternet(WebDriver driver) {
		this.driver = driver;
	}

	private void setElementMultipleWindowLink() {
		multipleWIndowLink = driver.findElement(By.xpath(XPATH_MULTIPLE_WINDOW_LINK));
	}

	public void clickOnMultipleWindowLink() {
		setElementMultipleWindowLink();
		multipleWIndowLink.click();
	}

	public void validatePageTitle(ValidationUtils utility) {
		utility.validateWindowTitle(TITLE);
	}

	public void switchToThisPage(BrowserWindowUtilities browserUtils) {
		browserUtils.switchToTitle(TITLE);
	}

}

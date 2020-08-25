package com.mycompany.web.pages.newtourswebsite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterMercuryTour {

	private final String XPATH_TO_USERNAME = "//input[@id='email']";
	private final String XPATH_TO_PASSWORD = "//input[@name='password']";
	private final String XPATH_TO_CONFIRMPASSWORD = "confirmPassword";
	private final String XPATH_TO_CLICKONSUBMIT = "//input[@name='register']";

	private WebDriver driver;
	private WebElement signInUsername;
	private WebElement signInPassword;
	private WebElement signInConfirmPassword;
	private WebElement signInButton;

	public RegisterMercuryTour(WebDriver driver) {
		this.driver = driver;
	}

	private void setElementRegisterLink() {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		signInUsername = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XPATH_TO_USERNAME)));
		// driver.findElement(By.xpath(XPATH_TO_USERNAME));
		signInPassword = driver.findElement(By.xpath(XPATH_TO_PASSWORD));
		signInConfirmPassword = driver.findElement(By.name(XPATH_TO_CONFIRMPASSWORD));
		signInButton = driver.findElement(By.xpath(XPATH_TO_CLICKONSUBMIT));
	}

	public void registerUser() {
		setElementRegisterLink();
		signInUsername.sendKeys("testing123");
		signInPassword.sendKeys("testing123");
		signInConfirmPassword.sendKeys("testing123");
		signInButton.click();
	}

}

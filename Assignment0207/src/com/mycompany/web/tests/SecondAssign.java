package com.mycompany.web.tests;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.openqa.selenium.WebDriver;

import com.mycompany.web.pages.newtourswebsite.BookFlightMeruryTour;
import com.mycompany.web.pages.newtourswebsite.FillPassengerDetailsMercuryTour;
import com.mycompany.web.pages.newtourswebsite.FlightFinderMercuryTour;
import com.mycompany.web.pages.newtourswebsite.FlightMercuryTour;
import com.mycompany.web.pages.newtourswebsite.HomePageMercuryTour;
import com.mycompany.web.pages.newtourswebsite.RegisterMercuryTour;
import com.mycompany.web.pages.newtourswebsite.SelectFlightMercuryTour;
import com.mycompany.web.utilities.BrowserWindowUtilities;
import com.mycompany.web.utilities.LogUtils;
import com.mycompany.web.utilities.TakeScreenshot;
import com.mycompany.web.utilities.ValidationUtils;
import com.mycompany.web.utilities.WebConstants;

public class SecondAssign {

	static String dataRead;
	private WebDriver driver;
	private static LogUtils log = new LogUtils();
	private static ValidationUtils validationUtility = new ValidationUtils();
	private static BrowserWindowUtilities windowValidation = new BrowserWindowUtilities();
	private static TakeScreenshot screenshot;
	private static WebConstants web = new WebConstants();
	private static int noOfRow = 1;

	public SecondAssign(WebDriver driver) {
		this.driver = driver;
		executeTests();
	}

	private HomePageMercuryTour homePageMercuryTour;
	private RegisterMercuryTour registerMercuryTour;
	private FlightMercuryTour flightMercuryTour;
	private FlightFinderMercuryTour flightFinderMercuryTour;
	private SelectFlightMercuryTour selectFlightMercuryTour;
	private BookFlightMeruryTour bookFlightMeruryTour;
	private FillPassengerDetailsMercuryTour fillPassengerDetailsMercuryTour;

	public void executeTests() {
		driver.manage().window().maximize();
		try (BufferedReader fileReader = new BufferedReader(new FileReader(web.MERCURY_TOUR_TEST_DATA_FILE));) {

			while ((dataRead = fileReader.readLine()) != null) {
				log.print("Row is " + dataRead);

				String SCREENSHOT_PATH = "screens/Assignment2/TestCase" + (noOfRow++);
				screenshot = new TakeScreenshot(driver, SCREENSHOT_PATH);
				validationUtility.setDriver(driver);
				windowValidation.setDriver(driver);
				homePageMercuryTour = new HomePageMercuryTour(driver);
				registerMercuryTour = new RegisterMercuryTour(driver);
				flightMercuryTour = new FlightMercuryTour(driver);
				flightFinderMercuryTour = new FlightFinderMercuryTour(driver);
				selectFlightMercuryTour = new SelectFlightMercuryTour(driver);
				bookFlightMeruryTour = new BookFlightMeruryTour(driver);
				fillPassengerDetailsMercuryTour = new FillPassengerDetailsMercuryTour(driver);

				performAssign2Step1();

				performAssign2Step2();

				performAssign2Step3();

				performAssign2Step4();

				performAssign2Step5();

				performAssign2Step6();

				performAssign2Step7();

				performAssign2Step8();

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void performAssign2Step8() {
		// Click on Home on left ribbon
		fillPassengerDetailsMercuryTour.clickOnHomeLink();
		screenshot.captureScreen();
	}

	private void performAssign2Step7() {
		// Fill FirstName, LastName, NUmber on page, take screenshot
		fillPassengerDetailsMercuryTour.fillPassengerDetails(dataRead);
		screenshot.captureScreen();
	}

	private void performAssign2Step6() {
		// Click "Continue", verify "Book a flight" text, , take screenshot
		selectFlightMercuryTour.clickOnContinueButton();
		bookFlightMeruryTour.checkBookAFlightText();
		screenshot.captureScreen();
	}

	private void performAssign2Step5() {
		// Click "Continue", verify "Select Flight" text, , take screenshot
		flightFinderMercuryTour.clickOnContinueButton();
		selectFlightMercuryTour.checkElementSelectFlightText();
		screenshot.captureScreen();
	}

	private void performAssign2Step4() {
		// Select "One Way", take screenshot
		flightFinderMercuryTour.clickOnSelectOneWayButton();
		screenshot.captureScreen();
	}

	private void performAssign2Step3() {
		// Click on "Flights" from left Ribbon, verify "Flight Finder" text, take
		// screenshot
		flightMercuryTour.clickOnFlightLink();
		flightFinderMercuryTour.checkElementFlightFinder();
		screenshot.captureScreen();
	}

	private void performAssign2Step2() {
		// Register using "testing123" "testing123"
		homePageMercuryTour.clickOnRegisterLink();
		screenshot.captureScreen();
		registerMercuryTour.registerUser();
		screenshot.captureScreen();
	}

	private void performAssign2Step1() {
		// Open "http://newtours.demoaut.com/", verify Title "Welcome: Mercury Tours"
		// take screenshot
		driver.get(web.NEW_TOURS_WEBSITE_URL);
		homePageMercuryTour.validatePageTitle(validationUtility);
		screenshot.captureScreen();
	}

}

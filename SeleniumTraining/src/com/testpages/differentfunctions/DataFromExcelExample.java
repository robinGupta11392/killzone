package com.testpages.differentfunctions;

import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.utilities.LaunchBrowser;
import com.utilities.ReadElementsProperties;
import com.utilities.ReadExcelData;

public class DataFromExcelExample {

	static WebDriver driver = null;
	static WebDriverWait wait = null;

	public static void main(String[] args) {
		LaunchBrowser lb = new LaunchBrowser("chrome");

		try {
			if (!(lb.getDriver() == null))
				driver = lb.getDriver();
			if (!(lb.getWait() == null))
				wait = lb.getWait();

			System.out.println(System.getProperty("user.dir"));

			ReadExcelData testdata = new ReadExcelData();
			testdata.readExcel(System.getProperty("user.dir"), "WorkBooks/SampleUsernameData.xlsx", "UserData");
			Sheet testSheet = testdata.getTestdata();

			int rowCount = testSheet.getLastRowNum() - testSheet.getFirstRowNum();
			
			ReadElementsProperties rp = new ReadElementsProperties("PropertiesFiles/elements.properties");

			for (int i = 1; i < rowCount + 1; i++) {
				driver.get("https://www.facebook.com");
				rp.getWebElement(driver, "usernameInput").sendKeys(testSheet.getRow(i).getCell(0).getStringCellValue());
				rp.getWebElement(driver, "passwordInput").sendKeys(testSheet.getRow(i).getCell(1).getStringCellValue());
				rp.getWebElement(driver, "LogInButton").click();
			}

			System.out.println("Test Passed");

		}

		catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			if (driver != null)
				driver.quit();
		}

	}

}

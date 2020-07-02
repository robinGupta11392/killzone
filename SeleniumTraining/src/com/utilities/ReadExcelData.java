package com.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelData {

	private Sheet testsheet = null;

	public void readExcel(String filePath, String fileName, String sheetName) throws IOException {

		File file = new File(filePath + "\\" + fileName);
		FileInputStream inputStream = new FileInputStream(file);
		Workbook tempBook = null;

		String fileExtensionName = fileName.substring(fileName.indexOf("."));

		if (fileExtensionName.equals(".xlsx")) {
			tempBook = new XSSFWorkbook(inputStream);
		} else if (fileExtensionName.equals(".xls")) {
			tempBook = new HSSFWorkbook(inputStream);
		}

		setTestdata(tempBook.getSheet(sheetName));

	}

	public Sheet getTestdata() {
		return testsheet;
	}

	private void setTestdata(Sheet testsheet) {
		this.testsheet = testsheet;
	}

}

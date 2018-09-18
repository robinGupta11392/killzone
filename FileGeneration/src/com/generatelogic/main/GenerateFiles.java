package com.generatelogic.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import org.apache.commons.io.FileUtils;

public class GenerateFiles {

	static Properties p;
	static final int MAX_TRANS_PER_FILE = 7000;
	static String sampleHeader = null;
	static String sampleBody = null;
	static String sampleFooter = null;
	static String directoryPath = null;
	static String outputFolderName = null;

	public static void main(String[] args) throws IOException {
		sampleHeader = Files.readAllLines(Paths.get("InputFile.txt")).get(0);
		sampleBody = Files.readAllLines(Paths.get("InputFile.txt")).get(1);
		sampleFooter = Files.readAllLines(Paths.get("InputFile.txt")).get(2);

		p = new Properties();
		p.load(new FileInputStream("application.properties"));

		int totalFiles = Integer.parseInt(p.getProperty("totalFiles"));
		setOutputFolderName();
		if (totalFiles == 0)
			generateFilesAutomatically();
		else
			generateFilesGivenFileNumbers();
	}

	private static void generateFilesGivenFileNumbers() throws IOException {

		long totalFiles = Long.valueOf(p.getProperty("totalFiles"));
		int totalTransactionsPerFile = (int) ((Long.valueOf(p.getProperty("totalTransaction"))) / totalFiles);

		int startingRefNo = 1;
		int startingFileName = 1;
		String fileNameTemplate = getFileNamePrefix();

		for (long i = 1; i <= totalFiles; i++) {
			startingRefNo = generateFile(totalTransactionsPerFile, startingRefNo,
					(fileNameTemplate + (startingFileName++)));
		}
		System.out.println("DONE");

	}

	private static void generateFilesAutomatically() throws IOException {

		long totalTransactions = Long.valueOf(p.getProperty("totalTransaction"));
		int totalFiles = (int) ((totalTransactions / MAX_TRANS_PER_FILE) + 1);

		int startingRefNo = 1;
		int startingFileName = 1;
		String fileNameTemplate = getFileNamePrefix();

		for (int i = 1; i <= totalFiles; i++) {
			if (totalTransactions > MAX_TRANS_PER_FILE) {
				startingRefNo = generateFile(7000, startingRefNo, (fileNameTemplate + (startingFileName++)));
				totalTransactions -= MAX_TRANS_PER_FILE;
			} else
				startingRefNo = generateFile((int) totalTransactions, startingRefNo,
						(fileNameTemplate + (startingFileName++)));
		}
		System.out.println("DONE");
	}

	static String getDateInSpecificFormat() {
		// SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		return (new SimpleDateFormat("yyyyMMdd")).format(new Date());
	}

	static String getTxnPrefix() {
		return p.getProperty("body.txnRefPrefix").replace("DATE", getDateInSpecificFormat());
	}

	static void setOutputFolderName() {
		outputFolderName =  p.getProperty("outputFolderName").replace("DATE", getDateInSpecificFormat()).replace("TIME",
				(new SimpleDateFormat("HHmmss")).format(new Date()));
	}

	static String getFileNamePrefix() {
		return p.getProperty("fileNamePrefix").replace("DATE", getDateInSpecificFormat());
	}

	static int getStartIndex(String propertyName) {
		return Integer.parseInt(p.getProperty(propertyName).split(",")[0]);
	}

	static int getEndIndex(String propertyName) {
		return Integer.parseInt(p.getProperty(propertyName).split(",")[1]);
	}

	@SuppressWarnings("deprecation")
	static int generateFile(int numOftxn, int startingRefNumber, String fileName) throws IOException {
		if (createOutputFolder()) {

			// Set File Name
			String fileNamePath = directoryPath + "\\" + fileName + "." + p.getProperty("fileExtensions", "dde");

			File generatedFile = new File(fileNamePath);

			System.out.println(fileNamePath);

			String replacedNumberOfTxn = String.format(
					"%0" + (getEndIndex("header.NumOfTxnIndex") - getStartIndex("header.NumOfTxnIndex") + 1) + "d",
					numOftxn);

			long totalAmount = 0;
			String tempBody = sampleBody;
			String finalBody = "";

			for (int i = 1; i <= numOftxn; i++) {
				String replacedRefNumber = getTxnPrefix() + String.format(
						"%0" + ((getEndIndex("body.CustRefNumIndex") - getStartIndex("body.CustRefNumIndex") + 1)
								- getTxnPrefix().length()) + "d",
						startingRefNumber++);

				String replacedAmount = String.format(
						"%0" + ((getEndIndex("body.TxnAmountIndex") - getStartIndex("body.TxnAmountIndex") + 1)) + "d",
						i);

				String temp = tempBody.substring(0, getStartIndex("body.CustRefNumIndex") - 1) + replacedRefNumber
						+ tempBody.substring(getEndIndex("body.CustRefNumIndex"),
								getStartIndex("body.TxnAmountIndex") - 1)
						+ replacedAmount + tempBody.substring(getEndIndex("body.TxnAmountIndex"));
				finalBody += temp + "\n";
				totalAmount += i;

			}

			String replacedValueOfTxn = String.format(
					"%0" + (getEndIndex("header.ValueOfTxnIndex") - getStartIndex("header.ValueOfTxnIndex") + 1) + "d",
					totalAmount);

			// Write to File
			String tempHeader = sampleHeader;
			String generatedFileContent = tempHeader.substring(0, getStartIndex("header.InstDateIndex") - 1)
					+ getDateInSpecificFormat()
					+ tempHeader
							.substring(getEndIndex("header.InstDateIndex"), getStartIndex("header.NumOfTxnIndex") - 1)
					+ replacedNumberOfTxn
					+ tempHeader.substring(getEndIndex("header.NumOfTxnIndex"),
							getStartIndex("header.ValueOfTxnIndex") - 1)
					+ replacedValueOfTxn + tempHeader.substring(getEndIndex("header.ValueOfTxnIndex")) + "\n"
					+ finalBody + sampleFooter;
			FileUtils.writeStringToFile(generatedFile, generatedFileContent);
			return startingRefNumber;
		}
		return 0;
	}

	static boolean createOutputFolder() {
		directoryPath = p.getProperty("basepath") + "\\" + outputFolderName;
		File directory = new File(directoryPath);
		if (!directory.exists())
			directory.mkdir();
		return true;
	}

}

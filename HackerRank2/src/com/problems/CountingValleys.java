package com.problems;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

import com.utilities.ArrayUtilities;

public class CountingValleys {

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		String s = scanner.nextLine();

		int result = countingValleys(n, s);

		System.out.println(result);

		scanner.close();

	}

	static int countingValleys(int n, String s) {
		int count = 0;
		boolean valleyStarted = false;
		boolean mountainStarted = false;
		int stepsInValley = 0;
		int stepsInMountain = 0;
		char[] characters = s.toCharArray();
		for (char character : characters) {
			if (valleyStarted) {
				if (character == 'D')
					stepsInValley--;
				else
					stepsInValley++;
				if (stepsInValley == 0) {
					valleyStarted = false;
					count++;
				}
			} else if (mountainStarted) {
				if (character == 'D')
					stepsInMountain--;
				else
					stepsInMountain++;
				if (stepsInMountain == 0) {
					mountainStarted = false;
				}
			} else if (character == 'D') {
				valleyStarted = true;
				stepsInValley--;
			} else if (character == 'U') {
				mountainStarted = true;
				stepsInMountain++;
			}
		}

		return count;

	}

}
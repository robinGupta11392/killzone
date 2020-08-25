package com.problems;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

import com.utilities.ArrayUtilities;

public class StockMerchant {

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int[] ar = new int[n];

		String[] arItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			int arItem = Integer.parseInt(arItems[i]);
			ar[i] = arItem;
		}

		int result = sockMerchant(n, ar);

		System.out.println(result);
		
		scanner.close();

	}

	static int sockMerchant(int n, int[] ar) {
		int countOfPairs = 0;
		int counter = 0;
		Arrays.sort(ar);
		ArrayUtilities.printIntArray(ar);
		while (counter < n) {
			if(counter==n-1)
				break;
			if (ar[counter] == ar[counter + 1]) {
				countOfPairs++;
				counter++;
			}
			counter++;

		}
		return countOfPairs;
	}

}
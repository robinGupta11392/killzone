package com.problems.arrays;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ArrayManipulation {
	static int count = 0;

	private static long[] performAddition(int startIndex, int endIndex, int value, long[] resultArray) {
		for (int i = startIndex; i <= endIndex; i++)
			resultArray[i] += value;
		System.out.println("Processed : " + ++count);
		return resultArray;
	}

	private static long findMax(long[] resultArray) {
//		Arrays.parallelSort(resultArray);
//		return resultArray[resultArray.length - 1];
		return Arrays.stream(resultArray).max().getAsLong();
	}

	// Complete the arrayManipulation function below.
	static long arrayManipulation(int n, int[][] queries) {

		/*
		 * // System.out.println("Process start");
		 * 
		 * // Initialize Zero Array // ArrayList<Long> temp = new ArrayList<Long>(); //
		 * temp.clear(); long[] resultArray = new long[n]; Arrays.fill(resultArray, 0);
		 * 
		 * // System.out.println("Array initialized");
		 * 
		 * // Process Queries for (int row = 0; row < queries.length; row++) resultArray
		 * = performAddition((queries[row][0] - 1), (queries[row][1] - 1),
		 * queries[row][2], resultArray);
		 * 
		 * // Find Maximum and return return findMax(resultArray);
		 */
		if (n == 0 || queries == null || queries.length == 0) {
			return -1;
		}
		long[] computation = new long[n];

		for (int i = 0; i < queries.length; i++) {
			int a = queries[i][0] - 1;
			int b = queries[i][1] - 1;
			int k = queries[i][2];

			computation[a] += k;
			if (b + 1 < n) {
				computation[b + 1] -= k;
			}
			System.out.println(Arrays.toString(computation));
		}

		long max = 0;
		long sum = 0;
		for (int i = 0; i < n; i++) {
			sum += computation[i];
			max = Math.max(max, sum);
		}

		return max;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		String[] nm = scanner.nextLine().split(" ");

		int n = Integer.parseInt(nm[0]);

		int m = Integer.parseInt(nm[1]);

		int[][] queries = new int[m][3];

		for (int i = 0; i < m; i++) {
			String[] queriesRowItems = scanner.nextLine().split(" ");
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			for (int j = 0; j < 3; j++) {
				int queriesItem = Integer.parseInt(queriesRowItems[j]);
				queries[i][j] = queriesItem;
			}
		}

		long result = arrayManipulation(n, queries);

		scanner.close();
		System.out.println(result);
	}
}

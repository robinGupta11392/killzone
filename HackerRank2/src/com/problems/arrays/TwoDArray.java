package com.problems.arrays;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class TwoDArray {
	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr = new int[6][6];

		for (int i = 0; i < 6; i++) {
			String[] arrRowItems = scanner.nextLine().split(" ");
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			for (int j = 0; j < 6; j++) {
				int arrItem = Integer.parseInt(arrRowItems[j]);
				arr[i][j] = arrItem;
			}
		}

		int result = hourglassSum(arr);

		System.out.println(result);
	}

	private static int hourglassSum(int[][] arr) {
		int maxSum = 0;
		for (int hourGlass = 0; hourGlass < 16; hourGlass++) {
			int rowOffset = hourGlass / 4;
			int colOffset = hourGlass % 4;
			int tempSum = 0;
			for (int col = 0; col < 3; col++) {
				for (int row = 0; row < 3; row++) {
					if ((row == 1) && (col == 0))
						continue;
					if ((row == 1) && (col == 2))
						continue;
					tempSum += arr[row + rowOffset][col + colOffset];
				}
			}
			if (hourGlass == 0)
				maxSum = tempSum;
			else if (tempSum > maxSum)
				maxSum = tempSum;
		}
		return maxSum;
	}

}

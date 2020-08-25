package com.problems;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class JumpingOnTheClouds {

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int[] c = new int[n];

		String[] cItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			int cItem = Integer.parseInt(cItems[i]);
			c[i] = cItem;
		}

		int result = JumpingOnTheClouds.jumpingOnClouds(c);
		System.out.println(result);
	}

	private static int jumpingOnClouds(int[] c) {
		int stepsCount = 0;
		int index = 0;
		while (true) {
			if (index >= c.length-1)
				break;
			try {
				if ((c[index + 2] == 0))
					index+=2;
				else
					index++;
			} catch (ArrayIndexOutOfBoundsException ae) {
					index += 1;
			}
			stepsCount++;
		}
		return stepsCount;
	}

}

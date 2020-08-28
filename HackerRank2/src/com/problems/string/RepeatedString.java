package com.problems.string;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class RepeatedString {

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		String s = scanner.nextLine();
		long n = scanner.nextLong();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		long result = repeatedString(s, n);
		System.out.println(result);
	}

	private static long repeatedString(String s, long n) {
		long countOfA = s.chars().filter(ch -> ch == 'a').count();
		int lengthOfString = s.length();
		countOfA *= n / lengthOfString;
		if (n % lengthOfString != 0)
			countOfA += s.substring(0, (new Long(n % lengthOfString)).intValue()).chars().filter(ch -> ch == 'a')
					.count();
		return countOfA;
	}

}

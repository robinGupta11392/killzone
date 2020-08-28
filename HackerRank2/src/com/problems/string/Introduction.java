package com.problems.string;

import java.util.Scanner;

public class Introduction {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String A = sc.next();
		String B = sc.next();
		System.out.println(A.length() + B.length());
		System.out.println((B.compareTo(A) < 0) ? "YES" : "NO");
		System.out.println(A.substring(0, 1).toUpperCase().concat(A.substring(1)) + " "
				+ B.substring(0, 1).toUpperCase().concat(B.substring(1)));
		sc.close();
	}
}

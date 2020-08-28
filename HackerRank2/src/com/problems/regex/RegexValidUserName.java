package com.problems.regex;

import java.util.Scanner;

public class RegexValidUserName {
	private static final Scanner scan = new Scanner(System.in);
	private static String regularExpression = "([a-zA-Z])([a-zA-Z0-9_]){7,29}";

	public static void main(String[] args) {
		int n = Integer.parseInt(scan.nextLine());
		while (n-- != 0) {
			String userName = scan.nextLine();
			if (userName.matches(regularExpression)) {
				System.out.println("Valid");
			} else {
				System.out.println("Invalid");
			}
		}

	}

}
package com.problems.regex;

import java.util.Scanner;

public class MyRegex {

	static String pattern = "\\b((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)(\\.|$)){4}\\b";

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			String IP = in.next();
			System.out.println(IP.matches(pattern));
		}
		in.close();

	}

}
package com.utilities;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {

	public static void main(String[] args) {

		String regex = "\\b(\\w+)(?:\\W+\\1\\b)+";
		Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);

		String input = "Goodbye bye bye world world world";

		Matcher m = p.matcher(input);

		// Check for subsequences of input that match the compiled pattern
		while (m.find()) {
System.out.println(m.group());
System.out.println(m.group(0));
System.out.println(m.group(1));

			input = input.replaceAll(m.group(), m.group(1));
		}

		// Prints the modified sentence.
		System.out.println(input);

	}

}
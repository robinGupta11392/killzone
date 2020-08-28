package com.problems.java.advanced;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class SHA256 {
	public static void main(String[] args) {
		String patternToCheckPassword = "\\b[a-zA-Z0-9]{6,20}\\b";
		Scanner in = new Scanner(System.in);
		String s = in.nextLine();
		if (!s.matches(patternToCheckPassword))
			System.out.println("Error");
		else
			System.out.println(getSHA256HashValue(s));
		in.close();

	}

	private static String getSHA256HashValue(String s) {
		String digest = null;
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			byte[] hash = md.digest(s.getBytes(StandardCharsets.UTF_8));
			digest = byteArrayToString(hash);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return digest;
	}

	private static String byteArrayToString(byte[] hash) {
		StringBuilder builder = new StringBuilder(2 * hash.length);
		for (byte b : hash) {
			builder.append(String.format("%02x", b & 0xff));
		}
		return builder.toString();
	}

}
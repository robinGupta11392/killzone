package com.utilities;

public class StringUtilities {

	public static String byteArrayToString(byte[] hash) {
		StringBuilder builder = new StringBuilder(2 * hash.length);
		for (byte b : hash) {
			builder.append(String.format("%02x", b & 0xff));
		}
		return builder.toString();
	}
}

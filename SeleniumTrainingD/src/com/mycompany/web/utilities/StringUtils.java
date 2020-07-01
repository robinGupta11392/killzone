package com.mycompany.web.utilities;

public class StringUtils {
	
	public static String getSingleLineString(String input) {
		return input.replaceAll("\\n", "").replaceAll("\\r", "").replaceAll("\\t", "");
	}

}

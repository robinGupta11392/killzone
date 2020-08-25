package com.utilities;

public class ArrayUtilities {

	public static void printIntArray(int[] in) {
		StringBuilder result = new StringBuilder();
		for(int i = 0 ; i<in.length;i++)
			result.append(in[i] + " ");
		System.out.println(result);
	}
}

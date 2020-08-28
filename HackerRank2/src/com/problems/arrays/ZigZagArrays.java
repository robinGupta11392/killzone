package com.problems.arrays;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ZigZagArrays {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

		List<Integer> arr = IntStream.range(0, arrCount).mapToObj(i -> {
			try {
				return bufferedReader.readLine().replaceAll("\\s+$", "");
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		}).map(String::trim).map(Integer::parseInt).collect(toList());

		int result = ZigZagArrays.minOperations(arr);
		System.out.println(result);

	}

	private static int minOperations(List<Integer> arr) {
		int LHadjustments = 0;
		int HLadjustments = 0;

		for (int index = 0; index < arr.size() - 1; index++) {

			if (index == 0) {
				if (arr.get(index) < arr.get(index + 1))
					HLadjustments++;
				else
					LHadjustments++;
			} else {
				if (index % 2 != 0) {
					if (!(arr.get(index) > arr.get(index + 1)))
						LHadjustments++;
					else
						HLadjustments++;
				} else {
					if (!(arr.get(index) > arr.get(index + 1)))
						HLadjustments++;
					else							
						LHadjustments++;
				}
			}
		}

		if (LHadjustments > HLadjustments)
			return HLadjustments;
		return LHadjustments;
	}

}

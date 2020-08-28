package com.problems;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class MinimumSwaps2 {

	static int[] swapElements(int[] source, int sourceIndex, int targetIndex) {
		int temp = source[sourceIndex];
		source[sourceIndex] = source[targetIndex];
		source[targetIndex] = temp;
		return source;
	}

	static int searchIndex(int[] source, int value) {
		for (int i = 0; i < source.length; i++) {
			if (value == source[i])
				return i;
		}
		return -1;
	}

	// Complete the minimumSwaps function below.
	static int minimumSwaps(int[] arr) {
		int swaps = 0;
		for (int index = 0; index < arr.length; index++) {
			int elementFoundAt = searchIndex(arr, (index + 1));
//			System.out.println("Element " + (index + 1) + " found at  : " + elementFoundAt);
			if (elementFoundAt != -1) {
				if (index != elementFoundAt) {
//					System.out.println("switching element");
					arr = swapElements(arr, index, elementFoundAt);
//					System.out.println("After switching : " + Arrays.toString(arr));
					swaps++;
				} 
//				else
//					System.out.println("Switching Not Required");
			}
		}
		return swaps;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		// BufferedWriter bufferedWriter = new BufferedWriter(new
		// FileWriter(System.getenv("OUTPUT_PATH")));

		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int[] arr = new int[n];

		String[] arrItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			int arrItem = Integer.parseInt(arrItems[i]);
			arr[i] = arrItem;
		}

		int res = minimumSwaps(arr);
//
//        bufferedWriter.write(String.valueOf(res));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();

		scanner.close();
		System.out.println(res);
	}
}

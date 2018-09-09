package com.rhezo;

/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility classes
import java.util.*;
*/
import java.util.*;

// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

class SeatingArrangement {
	public static void main(String args[]) throws Exception {
		/*
		 * Sample code to perform I/O: Use either of these methods for input
		 * 
		 * //BufferedReader BufferedReader br = new BufferedReader(new
		 * InputStreamReader(System.in)); String name = br.readLine(); // Reading input
		 * from STDIN System.out.println("Hi, " + name + "."); // Writing output to
		 * STDOUT
		 * 
		 * //Scanner Scanner s = new Scanner(System.in); String name = s.nextLine(); //
		 * Reading input from STDIN System.out.println("Hi, " + name + "."); // Writing
		 * output to STDOUT
		 * 
		 */

		// Write your code here
		Scanner s = new Scanner(System.in);
		int numberOfTestCases = s.nextInt();
		int[] inputSeats = new int[numberOfTestCases];
		for (int i = 0; i < numberOfTestCases; i++) {
			inputSeats[i] = s.nextInt();
		}
		printResult(inputSeats, numberOfTestCases);
		s.close();
	}

	static void printResult(int[] in, int total) {
		for (int i = 0; i < total; i++) {
			int oppSeat = 0;
			int inputSeat = in[i];
			String seatType = "AS";
			boolean right = true;
			boolean below = false;

			int modBy12 = inputSeat % 12;
			int modBy6 = inputSeat % 6;
			int modBy3 = inputSeat % 3;

			if ((0 < modBy12) && (modBy12 <= 6))
				right = false;

			// if((0 < modBy6) && (modBy6 <= 3))
			// below = true;

			if ((right == false) && (0 < modBy6) && (modBy6 <= 3))
				below = true;

			if ((right == true) && ((modBy6 >= 4) || (modBy6 == 0)))
				below = true;

			if ((right == true) && (below == true)) {
				switch (modBy3) {
				case 1:
					oppSeat = inputSeat - 7;
					break;
				case 2:
					oppSeat = inputSeat - 9;
					break;
				default:
					oppSeat = inputSeat - 11;
					break;
				}
			} else if ((right == true) && (below == false)) {
				switch (modBy3) {
				case 1:
					oppSeat = inputSeat - 1;
					break;
				case 2:
					oppSeat = inputSeat - 3;
					break;
				default:
					oppSeat = inputSeat - 5;
					break;
				}
			} else if ((right == false) && (below == true)) {
				switch (modBy3) {
				case 1:
					oppSeat = inputSeat + 11;
					break;
				case 2:
					oppSeat = inputSeat + 9;
					break;
				default:
					oppSeat = inputSeat + 7;
					break;
				}
			} else {
				switch (modBy3) {
				case 1:
					oppSeat = inputSeat + 5;
					break;
				case 2:
					oppSeat = inputSeat + 3;
					break;
				default:
					oppSeat = inputSeat + 1;
					break;
				}
			}

			if ((modBy3 == 0) && (modBy6 == 0))
				seatType = "WS";
			else if (modBy3 == 2)
				seatType = "MS";
			else if ((modBy3 == 1) && (modBy6 == 1))
				seatType = "WS";

			System.out.println(oppSeat + " " + seatType);
		}
	}
}
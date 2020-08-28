package com.problems;

import java.util.Scanner;

public class StaticBlocInitialization {
	
	static int B;
	static int H;
	static boolean flag;

	static {
		flag = true;
		Scanner in = new Scanner(System.in);
		B = in.nextInt();
		H = in.nextInt();
		if (B <= 0 || H <= 0) {
			flag = false;
			System.out.println("java.lang.Exception: Breadth and height must be positive");
		}
		in.close();
	}


	public static void main(String[] args) {
		if (flag) {
			int area = B * H;
			System.out.print(area);
		}

	}// end of main
}

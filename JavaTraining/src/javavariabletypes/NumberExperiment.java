package javavariabletypes;

import java.util.Random;
import java.util.Scanner;

public class NumberExperiment {

	public static void main(String[] args) {
		Integer x = 10000000;
		System.out.println(x.byteValue());
		System.out.println(x.shortValue());
		System.out.println(x.longValue());
		System.out.println(x.doubleValue());
		System.out.println(x.floatValue());
		System.out.println(x.toString());
		
		/*
		 * Output of the above
		 * -128
		-27008
		10000000
		1.0E7
		1.0E7
		10000000*/
		
		String hasCodecheck = "HASH VALUE";
		System.out.println(hasCodecheck.hashCode());
		
		Scanner scan = new Scanner(System.in);
		byte num = scan.nextByte();
		scan.close();
		
		int[] arr = new int[num];
		Random r = new Random();
		for(byte x1=0;x1<num;x1++)
			arr[x1] = r.nextInt();
		for(byte x1 = 0;x1<num;x1++)
			System.out.println(arr[x1]);
	
		

	}

}

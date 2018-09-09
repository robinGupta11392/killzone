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

// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail
import java.util.*;

class RhezoDivisibilityByZero {
    public static void main(String args[] ) throws Exception {
        /* Sample code to perform I/O:
         * Use either of these methods for input

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();                // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

        //Scanner
        Scanner s = new Scanner(System.in);
        String name = s.nextLine();                 // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

        */

        // Write your code here
        Scanner s = new Scanner(System.in);
        String bigNumber = s.nextLine();
        int numberOfTestCases = s.nextInt();
        int[][] positionsArray = new int[numberOfTestCases][2];
        s.nextLine();
        for(int i=0;i<numberOfTestCases;i++)
        {
            String temp = s.nextLine();
            String[] tempTokens = temp.split(" ");
            positionsArray[i][0]=Integer.parseInt(tempTokens[0]);
            positionsArray[i][1]=Integer.parseInt(tempTokens[1]);
        }
        s.close();
        for(int j=0;j<numberOfTestCases;j++)
        {
        	int lp=positionsArray[j][0];
        	int rp=positionsArray[j][1];
        	String temp=bigNumber;
        	if(lp<rp)
        		temp = temp.substring(lp-1,rp);
            else
            	temp = String.valueOf(temp.charAt(lp-1));
            double bnint = Double.parseDouble(temp);
        	System.out.println(isDivisible(bnint));
        }
        
    }
    static String isDivisible(double num)
    {
//    	throw new Exception("sadf");
    	// If number is negative, make it positive 
        if( num < 0 ) 
            return isDivisible( -num ); 
   
        // Base cases 
        if( num == 0 || num == 7 ) 
            return "YES"; 
        if( num < 10 ) 
            return "NO"; 
   
        // Recur for ( num / 10 - 2 * num % 10 )  
        return isDivisible(( Math.floor(num / 10) - 2 * ( num - (Math.floor(num / 10)) * 10 ) )); 
    }
}

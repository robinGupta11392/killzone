package javavariabletypes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTutorial {
	
	
	 private static final String REGEX = "\\bcat\\b";
     private static final String INPUT = "cat cat cat cattie cat";

	public static void main(String[] args) {
//		// String to be scanned to find the pattern.
//	      String line = "This order was placed for QT3000! OK?";
//	      String pattern = "(.*)(\\D+)(.*)";
//
//	      // Create a Pattern object
//	      Pattern r = Pattern.compile(pattern);
//
//	      // Now create matcher object.
//	      Matcher m = r.matcher(line);
//	      if (m.find( )) {
//	         System.out.println("Found value: " + m.group(0) );
//	         System.out.println("Found value: " + m.group(1) );
//	         System.out.println("Found value: " + m.group(2) );
//	         System.out.println("Found value: " + r.matches(pattern, line) );
//	      }else {
//	         System.out.println("NO MATCH");
//	      }
	      
	     
	         Pattern p = Pattern.compile(REGEX);
	         Matcher m = p.matcher(INPUT);   // get a matcher object
	         int count = 0;

	         while(m.find()) {
	            count++;
	            System.out.println("Match number "+count);
	            System.out.println("start(): "+m.start());
	            System.out.println("end(): "+m.end());
	         }

	}

}

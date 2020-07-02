package vlocityhometest.vlocityhometest;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.ListIterator;

import org.testng.annotations.Test;

import vlocityhometest.vlocityhometest.StringSplitter.Separator;

public class StringSplitterTest {
	
	@Test
	public void testWithOneSeparator() {
		String testString  = "foo.bar#baz";
		
		ArrayList<String> result = new StringSplitter(Separator.PERIOD).split(testString);
		System.out.println("testWithOneSeparator Test Output for Test String : " + testString);
		int i = 0;
		for (ListIterator<String> iter = result.listIterator(); iter.hasNext(); ) {
			i++;
		    System.out.println("Value # " + i + " : " + iter.next());
		     
		}
		
		assertEquals(result.size(), 2);
	}
	
	@Test
	public void testWithTwoSeparator() {
		ArrayList<String> result = new StringSplitter(Separator.PERIOD, Separator.HASH).split("foo.bar#baz");
		
		System.out.println("testWithTwoSeparator Test Output : ");
		int i = 0;
		for (ListIterator<String> iter = result.listIterator(); iter.hasNext(); ) {
			i++;
		    System.out.println("Value # " + i + " : " + iter.next());
		     
		}
		
		assertEquals(result.size(), 3);
	}
	
	@Test
	public void testWithTwoSeparator2() {
		ArrayList<String> result = new StringSplitter(Separator.PERIOD, Separator.HASH).split("foo.bar#baz#baz1.baz2");
		
		System.out.println("testWithTwoSeparator2 Test Output : ");
		int i = 0;
		for (ListIterator<String> iter = result.listIterator(); iter.hasNext(); ) {
			i++;
		    System.out.println("Value # " + i + " : " + iter.next());
		     
		}
		
		assertEquals(result.size(), 5);
	}
	
	@Test
	public void testWithOneSeparator2() {
		ArrayList<String> result = new StringSplitter(Separator.PERIOD).split("foo.bar#baz#baz1.baz2");
		
		System.out.println("testWithOneSeparator2 Test Output : ");
		int i = 0;
		for (ListIterator<String> iter = result.listIterator(); iter.hasNext(); ) {
			i++;
		    System.out.println("Value # " + i + " : " + iter.next());
		     
		}
		
		assertEquals(result.size(), 3);
	}
	
	@Test
	public void testWithOneSeparatorButNoMatch() {
		ArrayList<String> result = new StringSplitter(Separator.PERIOD).split("foobaz2");
		
		System.out.println("testWithOneSeparatorButNoMatch Test Output : ");
		int i = 0;
		for (ListIterator<String> iter = result.listIterator(); iter.hasNext(); ) {
			i++;
		    System.out.println("Value # " + i + " : " + iter.next());
		     
		}
		
		assertEquals(result.size(), 1);
	}
	
	@Test
	public void testWithTwoSeparatorButNoMatch() {
		ArrayList<String> result = new StringSplitter(Separator.PERIOD,Separator.SPACE).split("foobaz2sdaf");
		
		System.out.println("testWithTwoSeparatorButNoMatch Test Output : ");
		int i = 0;
		for (ListIterator<String> iter = result.listIterator(); iter.hasNext(); ) {
			i++;
		    System.out.println("Value # " + i + " : " + iter.next());
		     
		}
		
		assertEquals(result.size(), 1);
	}
	
	@Test
	public void testWithTwoSeparatorButOnlyOneMatch() {
		ArrayList<String> result = new StringSplitter(Separator.PERIOD,Separator.SPACE).split("fooba z2sdaf");
		
		System.out.println("testWithTwoSeparatorButOnlyOneMatch Test Output : ");
		int i = 0;
		for (ListIterator<String> iter = result.listIterator(); iter.hasNext(); ) {
			i++;
		    System.out.println("Value # " + i + " : " + iter.next());
		     
		}
		
		assertEquals(result.size(), 2);
	}

}

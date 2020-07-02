package vlocityhometest.vlocityhometest;

import java.util.ArrayList;

/**
 * Class for splitting strings into lists of substrings. Constructor can have
 * one or more parameters specifying all separator characters as an enum.
 *
 * Example #1: new StringSplitter(Separator.PERIOD).split(“foo.bar#baz”);
 * returns: {“foo”, “bar#baz”}
 *
 * Example #2: new StringSplitter(Separator.PERIOD,
 * Separator.HASH).split(“foo.bar#baz”); returns: {“foo”, “bar”, “baz”}
 *
 * IMPLEMENT FOLLOWING:
 *
 * (1) StringSplitter class and Separator enum supporting at two or more
 * different separators.
 *
 * (2) Some tests for the StringSplitter. TestNG/JUnit approach is preferred
 *
 */
public class StringSplitter {

	enum Separator {
		PERIOD, SPACE, HASH
	}

	// TODO: Constructor

	char separatorSymbol;
	char separatorSymbol2;

	StringSplitter(Separator s) {
		switch (s) {
		case PERIOD:
			separatorSymbol = '.';
			break;
		case SPACE:
			separatorSymbol = ' ';
			break;
		case HASH:
			separatorSymbol = '#';
			break;
		default:
			break;
		}
	}

	StringSplitter(Separator s1, Separator s2) {
		switch (s1) {
		case PERIOD:
			separatorSymbol = '.';
			break;
		case SPACE:
			separatorSymbol = ' ';
			break;
		case HASH:
			separatorSymbol = '#';
			break;
		default:
			break;
		}
		switch (s2) {
		case PERIOD:
			separatorSymbol2 = '.';
			break;
		case SPACE:
			separatorSymbol2 = ' ';
			break;
		case HASH:
			separatorSymbol2 = '#';
			break;
		default:
			break;
		}
	}

	/**
	 * Splits the given string based on the separator(s) given at in the
	 * constructor.
	 * 
	 * @param string
	 *            String to be split
	 * @return Resulting list of substrings.
	 */
	public ArrayList<String> split(String string) {

		ArrayList<String> result = new ArrayList<String>();

		if (string.indexOf(separatorSymbol) >= 0) {
			if (!(separatorSymbol2 == '\u0000')) {
				result.addAll(splitWithSecondSeparator(string.substring(0, string.indexOf(separatorSymbol))));
				ArrayList<String> resultTemp = split(string.substring(string.indexOf(separatorSymbol) + 1));
				result.addAll(resultTemp);
				
			} else {
				result.add(string.substring(0, string.indexOf(separatorSymbol)));
				ArrayList<String> resultTemp = split(string.substring(string.indexOf(separatorSymbol) + 1));
				result.addAll(resultTemp);
			}
		} else {
			if (!(separatorSymbol2 == '\u0000'))
				result.addAll(splitWithSecondSeparator(string));
			else
				result.add(string);
		}

		return result;
	}

	private ArrayList<String> splitWithSecondSeparator(String string) {

		ArrayList<String> result = new ArrayList<String>();

		if (string.indexOf(separatorSymbol2) >= 0) {
			result.add(string.substring(0, string.indexOf(separatorSymbol2)));
			ArrayList<String> resultTemp = split(string.substring(string.indexOf(separatorSymbol2) + 1));
			result.addAll(resultTemp);
		} else
			result.add(string);
		return result;
	}
}

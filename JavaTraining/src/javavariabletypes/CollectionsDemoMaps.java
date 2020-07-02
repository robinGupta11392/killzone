package javavariabletypes;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class CollectionsDemoMaps {

	public static void main(String[] args) {
		Map<String, String> m1 = new HashMap<String, String>();
		m1.put("Zara", "8");
		m1.put("Mahnaz", "31");
		m1.put("Ayan", "12");
		m1.put("Daisy", "14");

		System.out.println();
		System.out.println(" Map Elements");
		System.out.println("\t" + m1);
		System.out.println(m1.get("Ayan"));

		System.out.println(m1.keySet());

		// HashTables

		Hashtable<String, Double> balance = new Hashtable<>();
		Enumeration<String> names;
		String str;

		balance.put("Zara", new Double(3434.34));
		balance.put("Mahnaz", new Double(123.22));
		balance.put("Ayan", new Double(1378.00));
		balance.put("Daisy", new Double(99.22));
		balance.put("Qadir", new Double(-19.08));

		names = balance.keys();

		while (names.hasMoreElements()) {
			str = (String) names.nextElement();
			System.out.println(str + "  -- " + balance.get(str));
		}

		balance.put("Zara", ((Double) balance.get("Zara") + 1000));

		System.out.println(balance.get("Zara"));

		SortedMap<String, Double> student = new TreeMap<>(balance);
		System.out.println(student);
		System.out.println(balance);

	}

}

package javavariabletypes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class CollectionsListsDemo {

	public static void main(String[] args) {
		List<String> namesList = new ArrayList<>();

		namesList.add("Robin");
		namesList.add("Deepika");
		namesList.add("KillZone");

		System.out.println(namesList);
		System.out.println(namesList.contains("Robin"));

		// Sorting
		Collections.sort(namesList);
		System.out.println(namesList);

		// Sorting in reverse order
		Collections.sort(namesList, Collections.reverseOrder());
		System.out.println(namesList);
		
		Collections.shuffle(namesList);
		System.out.println("After Shuffle " + namesList);
		
		System.out.println("Without sorting trying for binary search : " + Collections.binarySearch(namesList, "Robin"));
		
		Collections.sort(namesList);
		System.out.println("After sorting trying for binary search : " + Collections.binarySearch(namesList, "Robin"));
		
		
		System.out.println(namesList.lastIndexOf("KillZone"));
		for (String names : namesList) {
			System.out.println(names);
		}

		Set<String> namesSet = new HashSet<String>();
		namesSet.add("Robin");
		namesSet.add("robin");
		namesSet.add("Ankit");
		namesSet.add("ankit");
		namesSet.add("1");
		namesSet.add("0");

		System.out.println(namesSet);
		for (String names : namesSet) {
			System.out.println(names);
		}

		SortedSet<String> namesSetSort = new TreeSet<>(namesSet);
		System.out.println(namesSetSort);
		
		Set<String> toShareSet = Collections.unmodifiableSet(namesSet);
		System.out.println(toShareSet.contains("Robin"));
//		toShareSet.add("testing");
//		System.out.println(toShareSet);
		
		LinkedList<String> llnames = new LinkedList<String>();
		llnames.add("Robin_LL");
		llnames.add("Robin_LL");

		llnames.addAll(namesSet);
		System.out.println(llnames);
		System.out.println(llnames.get(1));

	}

}

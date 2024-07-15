package com.learnjava.corejava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class CollectionsExercise {
	
	public static void main(String[] args) {
		
		
		/**************** Linked List *********************/
		
		LinkedList<String> strList = new LinkedList<>();
		
		strList.add("Sonia");
		strList.add("Lalit");
		strList.add("Sarah");
		strList.add("Tanya");
		strList.add("Sarah");
		strList.add("Tanya");
		
		strList.set(strList.lastIndexOf("Sarah"), "Sarah Khatri");
		strList.set(strList.lastIndexOf("Tanya"), "Tanya Khatri");
		
		
		System.out.println("First Index of Sarah in the list : " + strList.indexOf("Sarah"));
		System.out.println("Last Index of Sarah in the list  : " + strList.lastIndexOf("Sarah"));
		
		Iterator<String> descIterator = strList.descendingIterator();
		
		System.out.println("Printing list elements in reverse order : ");
		while(descIterator.hasNext()) {
			System.out.println(descIterator.next());
		}
		
		System.out.println("Printing list elements in reverse order using List Iterator : ");
		ListIterator<String> listIterator = strList.listIterator(strList.size());
		
		while(listIterator.hasPrevious()) {
			System.out.println(listIterator.previous());
		}
		/**************** Linked List *********************/
		
		
		/**************** Set *********************/
		Set<String> strSet = new HashSet<>();

		strSet.add("Sonia");
		strSet.add("Lalit");
		strSet.add("Sarah");
		strSet.add("Tanya");
		strSet.add("Sarah");
		strSet.add("Tanya");
		
		Set<String> newStrSet = strSet.stream().map( (x) -> x.concat(" Khatri") )
				//.sorted()
				.collect( Collectors.toCollection(TreeSet::new) );
		
		System.out.println("Printing elements of the new Set : ");
		for(String s : newStrSet) {
			System.out.println(s);
		}
		/**************** Set *********************/
		
		
		/**************** Map *********************/
		
		Map<String, Boolean> map = new HashMap<>();
		
		map.put("Elephant", false);
		map.put("Eagle", false);
		map.put("Tiger", false);
		map.put("Cow", false);
		
		
		for(Map.Entry<String, Boolean> entry : map.entrySet()) {
			
			String str = entry.getKey();
			
			outerloop:
			for (int i=0; i<str.length(); i++) {
				for (int j=i+1; j<str.length(); j++) {
					if (str.toLowerCase().charAt(i) == str.toLowerCase().charAt(j)) {
						map.replace(str, false, true);
						break outerloop;
					}
				}
			}
			
		}
		
		
		System.out.println("Map elements after checking : " + map);
		
		System.out.println("Printing strings with duplicate chars : ");
		
		List<String> listOfStrings = map.entrySet().stream()
			.filter( (entryset) -> entryset.getValue() == true)
			.map( (entryset) -> entryset.getKey())
			.collect(Collectors.toList());
		
		System.out.println(listOfStrings);
		
		
		SortedMap<String, Integer> sortedMap = new TreeMap<>();
		
		sortedMap.put("Sonia", 37);
		sortedMap.put("Lalit", 39);
		sortedMap.put("Sarah", 7);
		sortedMap.put("Tanya", 1);

		System.out.println("Printing sorted map elements on basis of keys : ");
		for(Map.Entry<String, Integer> entry : sortedMap.entrySet()) {
			System.out.println(entry);
		}
		
		LinkedHashMap<String, Integer> resultMap = sortedMap.entrySet().stream()
			.sorted( Map.Entry.comparingByValue(Comparator.reverseOrder())) 
			//.sorted( Map.Entry.<String, Integer>comparingByValue( (age1, age2) -> age1>age2?-1:1 ) )
			.collect(Collectors.toMap(
							Map.Entry::getKey, 
							Map.Entry::getValue,
							(oldValue, newValue) -> oldValue,
							LinkedHashMap::new) );
		
		System.out.println("Elements in map sorted by value i.e. age : " + resultMap);
		
		System.out.println("Printing the elements i.e. kids : ");
		
		sortedMap.entrySet().stream()
			.sorted(Map.Entry.comparingByValue())
			.filter( (entry) -> entry.getValue() < 30)
			.forEach(System.out::println);
	
		/**************** Map *********************/
		
		
		/**************** Synchronized List *********************/
		
		Collection<Integer> synCollection = Collections.synchronizedCollection(new ArrayList<Integer>());
		
		Thread t1 = new Thread( () -> synCollection.addAll(Arrays.asList(1,2,3,4,5)));
		Thread t2 = new Thread( () -> synCollection.addAll(Arrays.asList(6,7,8,9,10)));
		
		t1.start();
		System.out.println(synCollection);
		t2.start();
		System.out.println(synCollection);
		
		/**************** Synchronized List *********************/
		
	}

}

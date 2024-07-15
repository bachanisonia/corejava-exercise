package com.learnjava.corejava;

import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

public class WeakHashMapExample {

	public static void main(String[] args) throws InterruptedException {
		
		Thing thing1 = new Thing(1, "Bat");
		Thing thing2 = new Thing(2, "Ball");
		Thing thing3 = new Thing(3, "Stumps");
/*
		Map<Thing, Attendance> hashmapThings = new HashMap<>();
		
		hashmapThings.put(thing1, Attendance.PRESENT);
		hashmapThings.put(thing2, Attendance.PRESENT);
		hashmapThings.put(thing3, Attendance.ABSENT);
		
		// So that it can be GC in the WeakHashMap
		thing3 = null;
		System.gc();

		// Hashmap dominates over GC and hence does not remove the element from the map
		System.out.println("Printing Hashmap Elements : ");
		for(Map.Entry<Thing, Attendance> entry: hashmapThings.entrySet()) {
			System.out.println(entry.getKey().getName() + "-" + entry.getValue());
		}
		
*/	
		WeakHashMap<Thing, Attendance> weakhashmapThings = new WeakHashMap<>();
		
		weakhashmapThings.put(thing1, Attendance.PRESENT);
		weakhashmapThings.put(thing2, Attendance.PRESENT);
		weakhashmapThings.put(thing3, Attendance.ABSENT);
			
		// So that it can be GC in the WeakHashMap
		thing3 = null;
		System.gc();
	
		System.out.println("Printing WeakHashmap Elements : ");
		for(Map.Entry<Thing, Attendance> entry: weakhashmapThings.entrySet()) {
			System.out.println(entry.getKey().getName() + "-" + entry.getValue());
		}
	
	}

}


enum Attendance {
	
	PRESENT,
	ABSENT;
}
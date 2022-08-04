package com.aayush.tavant.training;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class SortingDemo {

	public static void main(String[] args) {
		

		List<String> listOfNames = new ArrayList<>();
		listOfNames.add("Hanan");
		listOfNames.add("Ayush");
		listOfNames.add("Jagruti");
		listOfNames.add("Vaishali");
		listOfNames.add("Amruta");
		
		System.out.println("We have the following names stored : ");
		
//		Traverse through the list:
//		System.out.println(listOfNames);
		
//		Or by an iterator:
//		Iterator<String> theIterator = listOfNames.iterator();
//		while(theIterator.hasNext()) {
//			System.out.println(theIterator.next());
//		}
		
//		Or by java 5's enhanced for loop
//		for(String name : listOfNames) {
//			System.out.println(name);
//		}
		
//		Or with the traditional for loop
//		for(int index = 0; index < listOfNames.size(); index++) {
//			System.out.println(listOfNames.get(index));
//		}
		
//		Or with the Java 8's forEach()
//		listOfNames.forEach(System.out::println);
		
//		Sort the collection
		Collections.sort(listOfNames);
		
		System.out.println("After sorting the list looks like:");
		listOfNames.forEach(System.out::println);
		
		
	}

}

package com.aayush.tavant.training;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class CustomSortDemo {

	public static void main(String[] args) {
		ArrayList<Cricketer> listOfCricketers = new ArrayList<>();
		
		Cricketer theCricketer = new Cricketer("Jasprit Bumrah", "India", 23);
		
		listOfCricketers.add(new Cricketer("Rohit Sharma", "India", 34));
		listOfCricketers.add(new Cricketer("Kane Williamson", "New Zealand", 32));
		listOfCricketers.add(theCricketer);
		listOfCricketers.add(new Cricketer("Tim Southee", "New Zealand", 34));
		listOfCricketers.add(new Cricketer("David Warner", "Australia", 35));
		
		System.out.println("We have the following cricketers : ");
		listOfCricketers.forEach(System.out::println);
		
//		Sort the list
//		Collections.sort(listOfCricketers);
		
//		Sort by Comparator
//		Collections.sort(listOfCricketers, new SortByAge());
		
//		Sort Java 8 way:
		listOfCricketers.sort(new SortByName());
		
		
		System.out.println();
		System.out.println("-------------------------------------");
		
		System.out.println("After sorting, list looks like:");
		listOfCricketers.forEach(System.out::println);
		
	}

}

class SortByName implements Comparator<Cricketer>{

	@Override
	public int compare(Cricketer o1, Cricketer o2) {
		return o1.name().compareTo(o2.name());
	}
	
}


class SortByCountry implements Comparator<Cricketer>{

	@Override
	public int compare(Cricketer o1, Cricketer o2) {
		return o1.country().compareTo(o2.country());
	}
	
}

class SortByAge implements Comparator<Cricketer>{

	@Override
	public int compare(Cricketer o1, Cricketer o2) {
		return o1.age().compareTo(o2.age());
	}
	
}

// Java 16's record
record Cricketer(String name, String country, Integer age) {}




//implements Comparable<Cricketer> {

//	@Override
//	public int compareTo(Cricketer o) {
//		return this.name().compareTo(o.name());
//	}}


//	Comparator
//		- compare(Object o1, Object o2)



//1. ENter new Cricketer details
//	- ENter name: Virat Kohli
//	- Enter country: India
//	- ENter age: 32
//2. View All Cricketers
//3. Delete Cricketer by name
//4. Search for a Cricketer
//5. Sort by
//	a. First Name
//	b. Last Name
//	c. Country
//	d. age








package com.tavant.aayush.training;

import java.util.List;
import java.util.function.Supplier;

public class UsingSupplier {

	public static void main(String[] args) {
		System.out.println("Footballers : " +getLearnerNames.get());
		

	}

//	A Supplier doesn't take arguments but just supplies
	static Supplier<List<String>> getLearnerNames = () ->
		List.of("Ashutosh", "Amruta", "Nirmal", "Jagruti");
	
	
}

package com.tavant.aayush.training;

import java.util.function.BiConsumer;

public class UsingBiConsumer {

	public static void main(String[] args) {
//		getFootballerDetails.accept(new Footballer("Ronaldo", 9898777537l), false);
		getFootballerDetails.accept(new Footballer("Gerrard", 9988907656l), true);

	}
	
//	A BiConsumer takes two arguments and produces nothing
	static BiConsumer<Footballer, Boolean> getFootballerDetails = 
			(theFootballer, showOrHidePhoneNumber) ->
	System.out.println("Hi " + theFootballer.name() + 
			", we also have your phone number : " + (showOrHidePhoneNumber ? theFootballer.phoneNumber() : "*********"));

}

record Footballer(String name, Long phoneNumber) {}

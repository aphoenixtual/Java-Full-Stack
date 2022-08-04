package com.tavant.aayush.training;

import java.util.function.Consumer;

public class UsingConsumer {

	public static void main(String[] args) {
		
//		oldWayOfGettingLearnerDetails(new Learner("Nihal", "Pune"));
		getLearnerDetails.accept(new Learner("Jagruti", "Bangalore"));

	}
	
//	static void oldWayOfGettingLearnerDetails(Learner theLearner) {
//	System.out.println("Hello " + theLearner.name()
//		+ ", nice to know you are from " + 
//			theLearner.location());	
//	}
	
	// A Consumer takes an argument and produces nothing
	static Consumer<Learner> getLearnerDetails = 
			theLearner -> System.out.println(
					"Hello " + theLearner.name());

}


record Learner(String name, String location) {}

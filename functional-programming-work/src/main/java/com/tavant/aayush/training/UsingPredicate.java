package com.tavant.aayush.training;

import java.util.function.Predicate;

public class UsingPredicate {

	public static void main(String[] args) {
		
		System.out.println(isLearnerNameValid.test("Messi"));
		System.out.println(isLearnerNameValid.test("Mbappe_Footballer"));
		System.out.println(isLearnerNameValid.test("Ro"));
	}
	
//	A Predicate takes one argument and produces a boolean result
	static Predicate<String> isLearnerNameValid = name -> name.length() >=3
			&& name.endsWith("_Footballer");

}

package com.tavant.aayush.training;

import java.util.function.BiFunction;

public class BiFunctionDemo {

	public static void main(String[] args) {
		
System.out.println(incrementAndMultiplyBiFunction.apply(5, 2));
	}
	
//	A BiFunction takes two input and produces a result
	static BiFunction<Integer, Integer, Integer> incrementAndMultiplyBiFunction = 
						(incrementValue, multiplyBy) ->
						++incrementValue * multiplyBy;

}

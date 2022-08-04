package com.tavant.aayush.training;

import java.util.function.Function;

public class FunctionDemo 
{
    public static void main( String[] args )
    {
//       int incremenetedValue = incrementFunction(56);
//       System.out.println("Incremented value : " + incremenetedValue);
    	
//    	int incrementedValue = incrementFunction.apply(34);
//    	System.out.println("Value incremented is : " + incrementedValue);
//    	
//    	String convertedValue = convertIntoToString.apply(incrementedValue);
//    	System.out.println("String equivalent of the value is : " + convertedValue);
    	
    	Function<Integer, String> incrementAndConvert = incrementFunction.andThen(convertIntoToString);
    	System.out.println(incrementAndConvert.apply(456));
    }
    
//    static int incrementFunction(int value) {
//    	return ++value;
//    }
    
   static Function<Integer, Integer> incrementFunction = value -> ++value;
   
   static Function<Integer, String> convertIntoToString = value -> value.toString();
		   
		   
		   
		   
		   
		   
		   
		   
}

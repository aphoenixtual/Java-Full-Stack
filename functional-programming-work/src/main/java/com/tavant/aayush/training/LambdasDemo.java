package com.tavant.aayush.training;


public class LambdasDemo {

	public static void main(String[] args) {
		
//		new Thread(new Runnable() {
//			@Override
//			public void run() {
//				System.out.println(Thread.currentThread().getName() + " working...");
//				
//			}
//		}).start();
		
//		Runnable ref = () -> System.out.println(Thread.currentThread().getName() + " running...");
//		new Thread(ref).start();
		
		
		
		
		

//		Lambda  expression syntax:
//		FunctionalInterfaceName refVariable = () -> Statement;
		
//		1. Through the normal verbose way:
//		new Sub().doSomething();
		
//		2. Through less verbose Inner Classes way:
//		new Work() {
//			@Override
//			public void doSomething() {
//				System.out.println("Works...");
//				
//			}
//		}.doSomething();
		
//		3. Through Java 8 ridiculously succinct Lambda expression way:
//		Work theWork = () -> System.out.println("This is fabulous!");
//		theWork.doSomething();
		
//		If the overriding method has multiple lines
//		Work theWork = () -> {
//			System.out.println("Method with multiple lines");
//			System.out.println("Yes it reduces code drastically...");
//		};
//		theWork.doSomething();
		
		Calculate theCalculate = (first, second) -> first + second;
		System.out.println(theCalculate.add(45,20));
		
//		Using Inner classes
//		new Thread(new Runnable() {
//			
//			@Override
//			public void run() {
//				LambdasDemo.displayMessage();
//				
//			}
//		}).start();
		
//		Using the Java 8 lambda code
//		 new Thread(()-> LambdasDemo.displayMessage()).start();
		
//		Or using Method References 
		new Thread(new LambdasDemo()::displayMessage).start();
		
	}
	
	void displayMessage() {
		System.out.println("Lambdas are absolutely great!");
	}

}

//class Sub implements Work{
//	@Override
//	public void doSomething() {
//		System.out.println("Inside Sub's doSomething()...");
//		
//	}
//}

// Lambda expressions > Java 8
//	- Annonymous functions
//	- Short, precise and smarter code
//	- Work with only functional interfaces

@FunctionalInterface
interface Work{
	void doSomething();
}

@FunctionalInterface
interface Calculate{
	int add(int first, int second);
}




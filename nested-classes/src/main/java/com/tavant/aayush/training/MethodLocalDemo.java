package com.tavant.aayush.training;

public class MethodLocalDemo {
	public static void main(String[] args) {
		new AnotherOuter().doSomething();
	}
}

class AnotherOuter{
	void doSomething() {
		int var = 98; //Effectively final after Java 8
		class Inner{
			void in() {
				System.out.println("Inside Inner's in...");
				System.out.println(var);//We can only access final or effectively variables of the enclosing method here...
			}
		}
		new Inner().in();
	}
}

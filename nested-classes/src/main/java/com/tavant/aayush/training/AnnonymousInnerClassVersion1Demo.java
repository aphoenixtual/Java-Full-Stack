package com.tavant.aayush.training;

public class AnnonymousInnerClassVersion1Demo {
	public static void main(String[] args) {
		
//		I have a requirement of calling Remote's work()
		Remote ref = new Remote() {
			@Override
			public void work() {
				System.out.println("Superior way of coding this...");
				
			}
		};
		ref.work();
		
	}
}

//1. Creating a new method-local class
//2. This class is nameless, hence called Annonymous
//3. This class is a sub class of Remote
//4. Overriring work()
//5. Closing work()
//6. Closing the class body
//7. Creating an object of that annonymous sub-class of Remote
//8. Creating a reference variable of Remote
//9. Assigning the object reference to ref
//10. Terminating the line at 13

interface Remote{
	void work();
}

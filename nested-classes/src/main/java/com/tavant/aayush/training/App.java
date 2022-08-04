package com.tavant.aayush.training;

public class App 
{
    public static void main( String[] args )
    {
//       Outer out = new Outer();
//       out.func();
    	
//    	Outer out = new Outer();
//    	Outer.Inner in = out.new Inner();
//    	Outer.Inner in = new Outer().new Inner();
    	new Outer().new Inner().met();
    }
}


class Outer{
	private int v;
	class Inner{
		int v;
		boolean flag;
		void met() {
			int v = 0;
System.out.println("Inside Inner's met..., v : " + v);
System.out.println("Instance v : " + this.v);
System.out.println("Outer's Instance v : " + Outer.this.v);
		}
	}
	
	void func() {
		v = 90;
//		Create an Inner Class object here
		Inner in = new Inner();
		in.met();
	}
}



//Nested Classes
//	- Inner Classes
//		- Regular Inner Class
//	- Static Classes

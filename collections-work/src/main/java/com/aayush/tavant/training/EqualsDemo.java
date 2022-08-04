package com.aayush.tavant.training;

public class EqualsDemo {
	public static void main(String[] args) {
		Suit first = new Suit("blue", "female", 42);
		Suit second = new Suit("pink", "female", 44);
		
		if(first.equals(second)) {
			System.out.println("Same suits...");
		}
		else
			System.out.println("Different suits...");
	}
}

//Java 16 records 
record Suit(String color, String gender, Integer size) {
	
	@Override
	public boolean equals(Object ref) {
		return this.gender().equals(((Suit)ref).gender());
	}
}

//class Suit{
//	private String color;
//	private String gender;
//	private int size;
//	
//	public Suit() {
//		
//	}
//
//	@Override
//	public String toString() {
//		return "Suit [color=" + color + ", gender=" + gender + ", size=" + size + "]";
//	}
//
//	public Suit(String color, String gender, int size) {
//		super();
//		this.color = color;
//		this.gender = gender;
//		this.size = size;
//	}
//
//	public String getColor() {
//		return color;
//	}
//
//	public void setColor(String color) {
//		this.color = color;
//	}
//
//	public String getGender() {
//		return gender;
//	}
//
//	public void setGender(String gender) {
//		this.gender = gender;
//	}
//
//	public int getSize() {
//		return size;
//	}
//
//	public void setSize(int size) {
//		this.size = size;
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		return this.getColor().equals(((Suit)obj).getColor());
//	}
//	
//	
//	
//	
//}

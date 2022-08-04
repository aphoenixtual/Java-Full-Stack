package com.aayush.tavant.training;

public class App 
{
    public static void main( String[] args )
    {
    	Participant theParticipant = new Participant(45, "Aayush", "FSD");
    	Participant anotherParticipant = new Participant(32, "Patel", "UI");
    	
    	System.out.println(theParticipant);
    	System.out.println(anotherParticipant);
    }
}

class Participant{
	private int id;
	private String name;
	private String domain;
	
	public Participant() {
		
	}
	
	
	public Participant(int id, String name, String domain) {
		this.id = id;
		this.name = name;
		this.domain = domain;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	@Override
	public String toString() {
		return "Participant [id=" + id + ", name=" + name + ", domain=" + domain + "]";
	}
	
	
	
	
}

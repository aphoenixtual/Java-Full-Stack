package com.tavant.aayush.training;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class UsingStreams {

	public static void main(String[] args) {
		
	List<Employee> listOfStudents = List.of(
			new Employee("Hanan", 240000L, Gender.MALE),
			new Employee("Rashmi", 220000L, Gender.FEMALE),
			new Employee("Namitha", 250000L, Gender.FEMALE),
			new Employee("Aayush", 200000L, Gender.MALE),
			new Employee("Jagruti", 260000L, Gender.FEMALE)
			);
	
//	listOfStudents.stream()
//	.map(theEmployee -> theEmployee.name())
//	.collect(Collectors.toSet())
//	.forEach(System.out::println);
	
//	Sort the list with using streams :
//	listOfStudents.stream()
//	.sorted(Comparator.comparing(Employee::name).reversed())
//	.collect(Collectors.toList())
//	.forEach(System.out::println);
	
//	Using a Predicate
	listOfStudents.stream()
	.filter(theStudent -> theStudent.theGender().equals(Gender.FEMALE))
	.collect(Collectors.toList())
	.forEach(System.out::println);
	
//	Using Any match
	boolean anyMatch = listOfStudents.stream()
	.anyMatch(theStudent -> theStudent.name().startsWith("J"));
	System.out.println(anyMatch);
	
//	Using All match
	boolean allMatch = listOfStudents.stream()
			.allMatch(theStudent -> theStudent.name().startsWith("J"));
	System.out.println(allMatch);
	
//	Using none match
	boolean noneMatch = listOfStudents.stream()
			.noneMatch(theStudent -> theStudent.name().startsWith("J"));
	System.out.println(noneMatch);
	
//	Min
	listOfStudents.stream()
	.min(Comparator.comparing(Employee::salary))
	.ifPresent(System.out::println);
	
//	Max
	listOfStudents.stream()
	.max(Comparator.comparing(Employee::salary))
	.ifPresent(System.out::println);
	
//	Grouping multiple operations
	listOfStudents.stream()
	.collect(Collectors.groupingBy(Employee::theGender))
	.forEach((gender, listByGender)->{
		System.out.println(gender);
		listByGender.forEach(System.out::println);
	});
	
System.out.println("Chaining:--------------------");

listOfStudents.stream()
.filter(theEmployee->theEmployee.theGender().equals(Gender.MALE))
.max(Comparator.comparing(Employee::salary))
.map(Employee::name)
.ifPresent(System.out::println);
	
	

	}
	

	
	
	
	
	

}

record Employee(String name, Long salary, Gender theGender) {}

enum Gender{MALE, FEMALE}

package com.tavant.aayush.training;

import java.util.ArrayList;
import java.util.List;

public class LambdaDemoTwo {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("John", 3000));
        employees.add(new Employee("Alice", 4000));
        employees.add(new Employee("Bob", 2500));
        employees.add(new Employee("Emily", 4500));

        /* Before lambda expression or Java 8 we're using this
        // Using an anonymous inner class to filter employees earning more than 3000
        List<Employee> highEarners = filterEmployees(employees, new Condition() {
            @Override
            public boolean test(Employee e) {
                return e.getSalary() > 3000;
            }
        });
        */

        // Using lambda expression to filter employees earning more than 3000
        List<Employee> highEarners = filterEmployees(employees, e -> e.getSalary() > 3000);

        System.out.println("High earners:");
        for (Employee e : highEarners) {
            System.out.println(e.getName() + " earns $" + e.getSalary());
        }
    }

    // Method to filter employees based on a condition
    public static List<Employee> filterEmployees(List<Employee> employees, Condition condition) {
        List<Employee> result = new ArrayList<>();
        for (Employee e : employees) {
            if (condition.test(e)) {
                result.add(e);
            }
        }
        return result;
    }
}

// Functional interface representing a condition
interface Condition {
    boolean test(Employee e);
}

class Employee {
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }
}

package com.tavant.aayush.training;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class App 
{
	public static final String URLTOCONNECT = "jdbc:mysql://localhost:3306/tavant_nov21";
	
	public static final String USERNAME = "root";
	
	public static final String USERPASSWORD = "";
	
	String qry;
	
	Connection dbCon;
	
	Statement theStatement;
	
	PreparedStatement thePreparedStatement;
	
	ResultSet theResultSet;
	
	
	App(){
		try {
//          Load the DB Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			dbCon = DriverManager.getConnection(URLTOCONNECT, USERNAME, USERPASSWORD);
			
			theStatement = dbCon.createStatement();
			
//			System.out.println("Connected to the database now...");
			
			
			
		} catch (ClassNotFoundException e) {
			System.out.println("Can't load the driver : " + e.getMessage());
		} catch (SQLException e) {
			System.out.println("Can't connect to the database : " + e.getMessage());
		}
	}
	
	
	
    public static void main( String[] args )
    {
    	App theApp = new App();
//    	theApp.getAllUserDetails();
//    	System.out.println("Count of users : " + theApp.getCountOfUsers());
    	
//    	theApp.addNewUser();
    	
    	
    	Scanner theScan = new Scanner(System.in);
//    	System.out.println("Enter name, location and salary of the new user to be added:");
    	
//    	theApp.addNewUserFromRuntime(theScan.nextLine(), theScan.nextLine(), theScan.nextInt());
//    	theApp.addNewUserUsingPreparedStatement(theScan.nextLine(), theScan.nextLine(), theScan.nextInt());
    	
    	System.out.println("Enter the id for which you want to update: ");
    	int id = theScan.nextInt();
    	theScan.nextLine();
    	System.out.println("Enter name :");
    	String userNameToUpdate = theScan.nextLine();
    	
    	theApp.updateUserDetails(id, userNameToUpdate);
    	
    }
    
//    Fetch all details of all users from the table:userdetails
    void getAllUserDetails() {
//    	Write the query
    	qry = "select * from userdetails";
    	

    	try {
//        	Execute the query
			theResultSet = theStatement.executeQuery(qry);
			
			System.out.println("We have the following names stored : ");
			
//			Traverse through the results
			while(theResultSet.next()) {
				System.out.println(theResultSet.getString("userName")
						+ " draws : "
						+ theResultSet.getString("userSalary")
						+ " INR."
						);
			}
			
			
		} catch (SQLException e) {
			System.out.println("Can't execute the query : " + e.getMessage());
		}
    	
    }
    
    
//    Fetch the count of total users from table:userdetails
    int getCountOfUsers() {
    	int count = 0;
    	qry = "select count(*) as countUsers from userdetails";
    	

    	try {
//        	Execute the query
			theResultSet = theStatement.executeQuery(qry);
			while(theResultSet.next()) {
				count = theResultSet.getInt("countUsers");
			}
			
		} catch (SQLException e) {
			System.out.println("Problems with count query : " + e.getMessage());
		}
		return count;
    }
    
    
//   Add a new User
    void addNewUser() {
    	qry = "insert into userdetails(userName, userLocation, userSalary) values('John', 'London, UK', 125000)";
    	
    	try {
//    		Execute the query
			if(theStatement.executeUpdate(qry) > 0)
				System.out.println("New User details added!");
		} catch (SQLException e) {
			System.out.println("Issues with insert query : " + e.getMessage());
		}
    }
    
// Add new User with getting runtime values
    void addNewUserFromRuntime(String userName, String userLocation, Integer userSalary)
    {
qry="insert into userdetails(userName, userLocation, userSalary) values("
		+ "'"
		+ userName + "', '"
		+ userLocation + "', '" 
		+ userSalary + "')";

try {
	if(theStatement.executeUpdate(qry) > 0)
		System.out.println("User added!");
} catch (SQLException e) {
	System.out.println("Issues with dynamic added user query : " + e.getMessage());
}
    }
    
    
//    Using PreparedStatement to add a new Record
    void addNewUserUsingPreparedStatement(String userName, String userLocation, Integer userSalary) {
    	qry = "insert into userdetails(userName, userLocation, userSalary) values(?, ?, ?)";
    	
    	try {
//        	Get the PreparedStatement object
			thePreparedStatement = dbCon.prepareStatement(qry);

//			Put the values for ?
			thePreparedStatement.setString(1, userName);
			thePreparedStatement.setString(2, userLocation);
			thePreparedStatement.setInt(3, userSalary);
			
//			Execute the query
			if(thePreparedStatement.executeUpdate() > 0)
				System.out.println("User added successfully...");
		} catch (SQLException e) {
			System.out.println("Issues with PreparedStatement insert query : " + e.getMessage());
		}
    }
    
//    Updating an already existing record by using PreparedStatement
    void updateUserDetails(Integer id, String userName) {
    	qry = "update userdetails set userName = ? where userId = ?";
    	
    	try {
			thePreparedStatement = dbCon.prepareStatement(qry);
			
//			Map the values to ?
			thePreparedStatement.setString(1, userName);
			thePreparedStatement.setInt(2, id);
			
			if(thePreparedStatement.executeUpdate() > 0)
				System.out.println("User details successfully updated!");
		} catch (SQLException e) {
			System.out.println("Issues with the update query : " + e.getMessage());
		}
    	
    	
    	
    }
    
    
    
    
    
    
//    For Update and Delete
    
    
    
    
    
    
    
    
    
}

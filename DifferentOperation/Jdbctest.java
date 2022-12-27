package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

// Read the data from the data base 
public class Jdbctest {
   public static void main(String[] args) {
	try {
		// register the driver step 1
		Class.forName("com.mysql.cj.jdbc.Driver");
		// get connection step 2
		Connection conn=DriverManager.getConnection
				("jdbc:mysql://localhost:3306/abhisekdb","root","Abhiwork@123");
	   // create statement step no 3 
		Statement stmt=conn.createStatement();
		
		// execute query fetch data from database step no 4
	ResultSet rs=stmt.executeQuery("select * from customer");
	// iteration
	while(rs.next()) {
		System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "
				+rs.getString(4));
	}
	// close database connection step no 5
	conn.close();
	}
	catch(Exception e) {
		System.out.println(e);
	}
	
   }
}

// if we run the code then we will get the customer table values 

package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class Insertjdbc {
	public static void main(String[] args) {
		try {
			// register the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			// connection the driver manager
			 Connection conn=DriverManager.getConnection
					 ("jdbc:mysql://localhost:3306/abhisekdb","root","Abhiwork@123");
		  // now create the statement step 3
			 Statement stmt=conn.createStatement(); 
			 // now insertion the data into the database 
			 stmt.executeUpdate("insert into customer values('A07','Romio','Sen','KP',5825274,'1999-07-23',2000.50)");
		      System.out.println("Successfully inserted the values");	
		      conn.close();
			 }
		catch (Exception e) {
			// TODO: handle exception
		 System.out.println(e);
		}
		
		
	}
}

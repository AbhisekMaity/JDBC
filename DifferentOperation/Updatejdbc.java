package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Updatejdbc {
   public static void main(String[] args) {
	try {
		// register the driver 
		Class.forName("com.mysql.cj.jdbc.Driver");
		// create connection 
		Connection conn= DriverManager.getConnection
				("jdbc:mysql://localhost:3306/abhisekdb","root","Abhiwork@123");
		// create statement 
		
		Statement stmt=conn.createStatement();
		
		// now updating the existing records
		
	  stmt.executeUpdate("update customer set fname ='Abhisek' where cust_id='A02'");
	 System.out.println("Successfully update the values");
	 conn.close();
	}
	catch (Exception e) {
		// TODO: handle exception
		System.out.println(e);
	}
	
  }
}

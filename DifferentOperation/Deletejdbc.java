package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Deletejdbc {
  public static void main(String[] args) {
	try {
		//  at first register the driver 
		Class.forName("com.mysql.cj.jdbc.Driver");
		// now create the connection 
		Connection conn=DriverManager.getConnection
				("jdbc:mysql://localhost:3306/abhisekdb","root","Abhiwork@123");
		// now create the statement 
		Statement stmt= conn.createStatement();
		// delete the records 
		stmt.executeUpdate("delete from customer where cust_id='A03'");
		System.out.println("Successfully deleted the values");
		// execute query fetch data from database step no 4
		ResultSet rs=stmt.executeQuery("select * from customer");
		// iteration
		while(rs.next()) {
			System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "
					+rs.getString(4));
		}
		conn.close();
	}
	catch (Exception e) {
		// TODO: handle exception
		System.out.println(e);
	}
}
}

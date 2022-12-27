package com.menudriven;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Helper {
  static {
	  try {
		  // register the driver
		  
		  Class.forName("com.mysql.cj.jdbc.Driver");
		  
	  }
	  catch (Exception e) {
		// TODO: handle exception
		  System.out.println(e);
	}
  }
  public static Connection con() throws SQLException{
	  return DriverManager.getConnection
			  ("jdbc:mysql://localhost:3306/abhisekdb","root","Abhiwork@123");
  }
}

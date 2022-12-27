package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class ScannerInputjdbc {
  public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	// user Input
	
	System.out.println("Enter the id");  // id
	Integer id=sc.nextInt();
	
	System.out.println("Enter name"); // name
	String ename=sc.next();
	
	System.out.println("Enter phoneno");  //phone
	Integer ephone=sc.nextInt();
	
	System.out.println("Enter address ");  // address
	String eaddr=sc.next();
	
	System.out.println("Enter department");  // department
	String sedept=sc.next();
	
	System.err.println("Enter salary");  // salary  
	Double esalary=sc.nextDouble();
	
	try {
		// register the driver step 1
		Class.forName("com.mysql.cj.jdbc.Driver");
		// creating the connection 
		
		Connection conn = DriverManager.getConnection
				("jdbc:mysql://localhost:3306/abhisekdb","root","Abhiwork@123");
		// create statement
		
		PreparedStatement stm;
		
		String sql ="insert into employee values(?,?,?,?,?,?)";
		stm=conn.prepareStatement(sql);
		stm.setInt(1,id);
		stm.setString(2, ename);
		stm.setInt(3, ephone);
		stm.setString(4, eaddr);
		stm.setString(5, sedept);
		stm.setDouble(6,esalary);
		stm.execute();
		System.out.println("Successfully inserted the values ");
		
	}
	catch (Exception e) {
		// TODO: handle exception
	System.out.println(e);
	}
	
    }
}

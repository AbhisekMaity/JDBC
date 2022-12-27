package com.student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.menudriven.Helper;

public class Student {
   Scanner sc = new Scanner(System.in);
 
   // Saving the student details in the database 
   
   public void saveMenudriven() throws SQLException{
	   System.out.println("Enter the id");  // id
		Integer id=sc.nextInt();
		
		System.out.println("Enter name"); // name
		String ename=sc.next();
		
		System.out.println("Enter phoneno");  //phone
		Long ephone=sc.nextLong();
		
		System.out.println("Enter address ");  // address
		String eaddr=sc.next();
		
		System.out.println("Enter department");  // department
		String sedept=sc.next();
		
		System.err.println("Enter salary");  // salary  
		Double esalary=sc.nextDouble();
		
		Connection conn = Helper.con();
		
		PreparedStatement stmt = conn.prepareStatement
				("insert into employee values(?,?,?,?,?,?)");
		stmt.setInt(1,id);
		stmt.setString(2, ename);
		stmt.setLong(3, ephone);
		stmt.setString(4, eaddr);
		stmt.setString(5, sedept);
		stmt.setDouble(6,esalary);
		stmt.executeUpdate();
		System.out.println("Successfully inserted the values ");
   }
   // fatching student details in the database (display)
    public void fetchMenudriven() throws SQLException {
    	Connection conn =Helper.con();
    	Statement stmt = conn.createStatement();
    	// execute query fetch data from database
    	ResultSet rs = stmt.executeQuery("select * from employee");
    	// iteration
    	
    	while(rs.next()) {
			System.out.println("ID : "+rs.getInt(1)+"  Name : "+rs.getString(2)+"  Phone : "+rs.getLong(3)+"  Address : "
					+rs.getString(4)+"  Department : "+rs.getString(5)+"   Salary : "+rs.getDouble(6));
			System.out.println("-----------------------------------------------------------------------------------------------------------");
		}
    	
    }
    
    // updating student details 
    
    public void updateMenudriven() throws SQLException{
    	Connection conn=Helper.con();
    	Statement stmt=conn.createStatement(); // created the statement 
    	System.out.println("Enter the enter the new name ");
		String ename=sc.nextLine();
		System.out.println("Enter the id");
		int id=sc.nextInt();
		stmt.executeUpdate
		("update employee set ename = '"+ename+"' where id = "+id);
    	
    }
    
    // deleting the student details from the database 
     public void deleteMenudriven() throws SQLException{
    	 Connection conn = Helper.con();
    	 Statement stmt=conn.createStatement(); // create statement
    	 System.out.println("Enter the id which we want to delete");
    	 int id=sc.nextInt();
    	 stmt.executeUpdate
    	 ("delete from employee where id= "+id);
     }
    
}

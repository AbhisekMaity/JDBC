package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class JdbcCURD {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		while(true) {
			System.out.println("Press 1 for Insert the values :");
			System.out.println("Press 2 for update the values :");
			System.out.println("Press 3 for delete the values :");
			System.out.println("Press 4 for Display the values :");
			System.out.println("Press 5 for Exit :");
			System.out.println("=================================================================");
			
			int x=sc.nextInt();
			if(x==1) {
				// insert
				 
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
					stm.setLong(3, ephone);
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
			else if(x==2) {
				//update
				try {
					// register the driver 
					Class.forName("com.mysql.cj.jdbc.Driver");
					// create connection 
					Connection conn= DriverManager.getConnection
							("jdbc:mysql://localhost:3306/abhisekdb","root","Abhiwork@123");
					// create statement 
					
					Statement stmt=conn.createStatement();
					
					// now updating the existing records
					
				  stmt.executeUpdate("update employee set ename ='Priyanka' where id=4");
				 System.out.println("Successfully update the values");
				 conn.close();
				}
				catch (Exception e) {
					// TODO: handle exception
					System.out.println(e);
				}
			}
			else if(x==3) {
				//	delete
				try {
					//  at first register the driver 
					Class.forName("com.mysql.cj.jdbc.Driver");
					// now create the connection 
					Connection conn=DriverManager.getConnection
							("jdbc:mysql://localhost:3306/abhisekdb","root","Abhiwork@123");
					// now create the statement 
					Statement stmt= conn.createStatement();
					// delete the records 
					stmt.executeUpdate("delete from employee where id=5");
					System.out.println("Successfully deleted the values");
					conn.close();
				}
				catch (Exception e) {
					// TODO: handle exception
					System.out.println(e);
				}
			}
			else if(x==4) {
				// display
				try {
					// register the driver step 1
					Class.forName("com.mysql.cj.jdbc.Driver");
					// get connection step 2
					Connection conn=DriverManager.getConnection
							("jdbc:mysql://localhost:3306/abhisekdb","root","Abhiwork@123");
				   // create statement step no 3 
					Statement stmt=conn.createStatement();
					
					// execute query fetch data from database step no 4
				ResultSet rs=stmt.executeQuery("select * from employee");
				// iteration
				while(rs.next()) {
					System.out.println(rs.getInt(1)+"    "+rs.getString(2)+"    "+rs.getLong(3)+"    "
							+rs.getString(4)+"    "+rs.getString(5)+"    "+rs.getDouble(6));
				}
				// close database connection step no 5
				conn.close();
				}
				catch(Exception e) {
					System.out.println(e);
				}
			}
			else if(x==5) {
				//exit
				break;
			}
			else {
				// if you will put wrong input then automatically exit from the app
				System.out.println("Sorry You will put worng input ");
				break;
			}
		}

	}

}

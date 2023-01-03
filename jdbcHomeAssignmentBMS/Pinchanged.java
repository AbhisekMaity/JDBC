package com.loaderclass;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.bms.Helper;

public class Pinchanged {
  long db_acc;
  int db_pin;
  Scanner sc= new Scanner(System.in);
  public void pinChange(long acc_no,int pin) throws SQLException{
	  Connection conn = Helper.con();
	  // create Statement method of Connection interface
	  // is used to create statement and store
   //inside the object of statement interface 
   
   Statement stmt = conn.createStatement();
   System.out.println("Enter the New pin ");
   int newPin=sc.nextInt();
   ResultSet rs  = stmt.executeQuery("select * from bank1 where account_no = "+acc_no);
   while(rs.next()) {  // getting the column of each record in the table 
		  
		  db_acc=rs.getLong(1);
		  db_pin=rs.getInt(7);
   }	
		  if(db_acc != acc_no) {
			  System.out.println("Wrong account no ");
		  }
		  if(db_pin != pin) {
			  System.out.println("Wrong pin no");
		  }
		  else {
			  stmt.executeUpdate("update bank1 set pin="+newPin+" where account_no = "+acc_no);
			  System.out.println("Successfully reset the pin");
		  }
  
   }
}

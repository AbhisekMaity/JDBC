package com.loaderclass;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.bms.Helper;

public class DepositeBalance {
   int db_pin;
   long db_acc;
   double previous_bal;
   Scanner sc = new Scanner(System.in);
   
   public void depositBal(Long acc_no,int pin )throws SQLException {
	   Connection conn = Helper.con();
	   
	   // create Statement method of Connection interface
		  // is used to create statement and store
	   //inside the object of statement interface 
	   
	   Statement stmt1 = conn.createStatement();
	   Statement stmt2 = conn.createStatement();
	   Statement stmt3 = conn.createStatement();


	   
	// executeQuery() mehtod of statement interface is used to used execute queries to the database
		  // iniside the object of Result set interface 
	   
	   ResultSet rs = stmt1.executeQuery
			   ("select * from bank1 where account_no="+acc_no+" and pin = "+pin);
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
				  System.out.println("Enter the ammount which you want to deposite :");
				  double depo=sc.nextDouble();
				  ResultSet rs2 = stmt2.executeQuery
						  ("select balance from bank1 where account_no ="+acc_no+" and pin = "+pin);
				  while(rs2.next()) {
					  previous_bal=rs2.getDouble(1);
					  System.out.println("Your previous balance was :" +previous_bal);
					  
					  stmt3.executeUpdate("update bank1 set balance= "+(previous_bal+depo)+" where pin = "+pin);
					  System.out.println("Now your new total balance is "+(previous_bal+depo));
					  System.out.println("=================================================");
				  }
				  rs2.close();
			  }
	   
	   rs.close();
   }
}

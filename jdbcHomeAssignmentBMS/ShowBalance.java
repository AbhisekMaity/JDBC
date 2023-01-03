package com.loaderclass;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.bms.Helper;

public class ShowBalance {
  long db_acc;
  int db_pin;
  public void showAccountDetails(long acc_no,int pin) throws SQLException{
	  Connection conn=Helper.con();
	  // create statement method of conncetion interface is used to create 
	  //  statement and store inside the object of statement interface 
	  
	  Statement stmt1 = conn.createStatement();
	  Statement stmt2 = conn.createStatement();

	  
	  ResultSet rs = stmt1.executeQuery
			  ("select * from bank1 where account_no ="+acc_no+" and pin= "+pin);
	  
	  // executeQuery() method of statement interface is used to execute queries 
	  // to the database, inside object of RsultSet interface.
	  
	  while(rs.next()) {  // getting the column of each record in the table 
		  
		  db_acc=rs.getLong(1);
		  db_pin=rs.getInt(7);
	  }
		  if(db_acc != acc_no) {
			  System.out.println("Wrong account no/ ");
		  }
		  if(db_pin!=pin) {
			  System.out.print("Wrong pin no\n");
		  }
		  else {
			  System.out.println("=============================");
			  System.out.println("Details of your Account: ");
			  
			  ResultSet rs1 = stmt2.executeQuery("select * from bank1 where pin= "+pin);
			  while(rs1.next()) {
				  System.out.println("Account Number   :"+rs1.getLong(1));
				  System.out.println("Account Holder   :"+rs1.getString(2));
				  System.out.println("Account IFSC   :"+rs1.getString(3));
				  System.out.println("Branch Name   :"+rs1.getString(4));
				  System.out.println("Account Type   :"+rs1.getString(5));
				  System.out.println("Account Balance   :"+rs1.getDouble(6));
				  System.out.println("Account Pin No   :"+rs1.getInt(7));
				  
				  System.out.println("=======================================");

			  }
			  rs1.close();
		  }
		  
	 
	  
rs.close();
  }
}

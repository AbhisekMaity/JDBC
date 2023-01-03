package com.loaderclass;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.bms.Helper;

public class ClosedAccount {
  int db_pin;
  long db_acc;
  public void closeac(long acc_no,int pin) throws SQLException{
	  Connection conn=Helper.con();
	// create statement method of connection interface is used to create 
		  //  statement and store inside the object of statement interface 
		  
		  Statement stmt1 = conn.createStatement();
		  Statement stmt2 = conn.createStatement();

		  
		  
		   ResultSet rs = stmt1.executeQuery
				   ("select * from bank1 where account_no="+acc_no+" and pin = "+pin);
		   while(rs.next()) {  // getting the column of each record in the table 
				  
				  db_acc=rs.getLong(1);
				  db_pin=rs.getInt(7);
		   }
				  if(db_acc!=acc_no) {
					  System.out.println("!!!Wrong account no ");
				  }
				  if(db_pin!=pin) {
					  System.out.println("Wrong pin no");
				  }
				  else {
					  stmt2.executeUpdate("delete from bank1 where account_no = "+acc_no+" and pin = "+pin);
					  System.out.println("=========Account Closed=========");
	  
    }
  }
}

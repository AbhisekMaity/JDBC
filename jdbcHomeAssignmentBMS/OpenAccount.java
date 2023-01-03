package com.loaderclass;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.bms.Helper;

public class OpenAccount {
long acc_no,db_acc;
  int pin,db_pin;
  String acc_holder,acc_type, ifsc_code, branch,db_ifsc;
  Double balance;
  Scanner sc = new Scanner(System.in);
  public void OpenNewAccount(long acc_no,String ifsc_code,int pin) throws SQLException{
	  Connection conn=Helper.con();
	  // create Statement method of Connection interface
	  // is used to create statement and store inside the object of statement interface 
	  
	  Statement stmt=conn.createStatement();
	  
	  // executeQuery() mehtod of statement interface is used to used execute queries to the database
	  // iniside the object of Result set interface 
	  
	  ResultSet rs = stmt.executeQuery
			  ("select * from bank1");
	  
	  // now getting the column of each record in the table of the table1 database
	  
	  while(rs.next()) {
		  db_acc=rs.getLong(1);
		  db_ifsc=rs.getString(3);
		  db_pin=rs.getInt(7);
		  
	  
	  if(acc_no==db_acc) {
		  
		  System.out.println("Opp this account is alread exists ");
			break;
	  }
//	  if(db_ifsc==ifsc_code) {
//		  System.out.println("Opps this ifsc code is already exists!!!");
//	  }
	  else {
		  System.out.println("Enter your name :");
		  acc_holder=sc.nextLine();
		  System.out.println("Enter Branch name :");
		  branch=sc.nextLine();
		  System.out.println("Enter Account typpe ");
		  acc_type=sc.next();
		  System.out.println("Enter the opening balance :");
		  balance=sc.nextDouble();
		  
		  // prepared statement 
		  
		  PreparedStatement stmt2=conn.prepareStatement
				  ("insert into bank1 values (?,?,?,?,?,?,?)");
		  stmt2.setLong(1, acc_no);
		  stmt2.setString(2, acc_holder);
		  stmt2.setString(3, ifsc_code);
		  stmt2.setString(4, branch);
		  stmt2.setString(5, acc_type);
		  stmt2.setDouble(6, balance);
		  stmt2.setInt(7, pin);
		  stmt2.executeUpdate();
		  
		  System.out.println("Congratulation Your New Account Created Successfully ");
		  break;
	  }
  }}
}

package com.menudriven;

import java.sql.SQLException;
import java.util.Scanner;

import com.student.Student;

public class CURD_operation {
  public static void main(String[] args) throws SQLException {
	Student e = new Student();
	Scanner sc = new Scanner(System.in);
	int ch;
	
	do {
	System.out.println(" 1.  INSERT \n 2.  Display \n 3.  Update \n 4.  delete \n 5.  exit \n ");
	System.out.println("Enter your choice from 1-5 ");
	ch=sc.nextInt();
	System.out.println("===============thanks=========================");
	
	switch (ch) {
case 1:
	e.saveMenudriven();
	break;
case 2:
	e.fetchMenudriven();
	break;
case 3:
	e.updateMenudriven();
	break;
case 4:
	e.deleteMenudriven();
	break;
case 5:
	System.exit(0);
	break;

	default:
		break;
	}
	}while(ch!=5);
	
   }
}

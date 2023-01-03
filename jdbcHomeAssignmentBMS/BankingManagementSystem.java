package com.bms;

import java.util.Scanner;

import com.loaderclass.ClosedAccount;
import com.loaderclass.DepositeBalance;
import com.loaderclass.OpenAccount;
import com.loaderclass.Pinchanged;
import com.loaderclass.ShowBalance;
import com.loaderclass.WithdrawBalance;

public class BankingManagementSystem {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
    	int variable;
    	do {
    		System.out.println("========>>>  Welcome to our Banking Service  <<<=========        ");
    		 System.out.println("Please Enter Your choice");
 		    System.out.println("Press 1 for Create An Account :");
 		    System.out.println("Press 2 for Display the balance :");
 			System.out.println("Press 3 for deposit amount :");
 			System.out.println("Press 4 for  withdrawal amount :");
 			System.out.println("Press 5 for change the pin :");
 			System.out.println("Press 6 for close an account :");
 			System.out.println("Press 7 for Exit from the program :");
 			
 			variable = sc.nextInt();
 			System.out.println("======================================");
 			switch (variable) {
			case 1:
				System.out.println("Enter 10 digit to create a new Account number ");
				long acc_no=sc.nextLong();
				System.out.println("Enter the Branch IFSC code ");
				String ifsc_code=sc.next();
				System.out.println("Enter 4 digit Account pin");
				int pin = sc.nextInt();
				OpenAccount op=new OpenAccount();
				op.OpenNewAccount(acc_no, ifsc_code, pin);
//				System.out.println("=======New Account created Successfully======");
				
				break;
			case 2:
				System.out.println("Enter your account number :");
				long a =sc.nextLong();
				System.out.println("Enter your pin :");
				int p = sc.nextInt();
				ShowBalance sb=new ShowBalance();
				sb.showAccountDetails(a, p);
				break;
			case 3:
				System.out.println("Enter your acc no: ");
				long c = sc.nextLong();
				System.out.println("Enter your pin: ");
				int b = sc.nextInt();
				DepositeBalance db = new DepositeBalance();
				db.depositBal(c, b);
				System.out.println();
				break;
			case 4:
				System.out.println("Enter your acc no: ");
				long k = sc.nextLong();
				System.out.println("Enter your pin: ");
				int d = sc.nextInt();
				WithdrawBalance wb = new WithdrawBalance();
				wb.withdrawBal(k, d);
				System.out.println();
				break;
			case 5:
				System.out.println("Enter your acc no: ");
				long e = sc.nextLong();
				System.out.println("Enter your current pin: ");
				int f = sc.nextInt();
				Pinchanged pc = new Pinchanged();
				pc.pinChange(e, f);
				System.err.println("_PIN HAS BEEN CHANGED__");
				break;
			case 6:
				System.out.println("Enter your acc no: ");
				long g = sc.nextLong();
				System.out.println("Enter your current pin: ");
				int h = sc.nextInt();
				ClosedAccount ca = new ClosedAccount();
				ca.closeac(g, h);
				System.out.println();
				break;
			case 7:
				System.err.println("You have sucessfully logged out");
				System.out.println("__THANK YOU__");
				System.out.println();
				System.exit(0);
				break;

			}
    	}while(variable > 0 && variable < 8);
		
	}
}

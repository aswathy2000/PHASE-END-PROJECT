package com.phaseendproject.camerarentalapp;

import java.util.Scanner;

public class loginPage{

	public static void loginDisplay()
	{
		
		String validUsername = "admin";
		String validPassword = "admin123";

		String userName, passWord;

		System.out.printf("+--------------------------------------+%n");
		System.out.printf("|      WELCOME TO CAMERA RENTAL APP    |%n");
		System.out.printf("+--------------------------------------+%n");

		boolean flag = true;
		
		do {

			System.out.println("\nPLEASE LOGIN TO CONTINUE - ");
			Scanner sc = new Scanner(System.in);
			System.out.print("USERNAME - ");
			userName = sc.next();
			System.out.print("PASSWORD - ");
			passWord = sc.next();


			if ( (userName.equals(validUsername)) && ( passWord.equals(validPassword)  ) )
			{
				System.out.println("\nLogin successfull!");
				System.out.println("Developer Name: Aswathy P K \n");
				flag = false;
			}
			
			else 
			{
				System.out.println("\n Invalid Credentials! Try Again");
				flag = true;
			}

		}while(flag);

		cameraClass.main(null);
		
	}
}

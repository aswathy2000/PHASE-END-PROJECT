package com.phaseendproject.camerarentalapp;

import java.util.InputMismatchException;
import java.util.Scanner;

public class walletClass {

	private double amtBalance = 10000;


	public double getAmtBalance() {
		return amtBalance;
	}


	public void setAmtBalance(double amtBalance) {
		this.amtBalance = amtBalance;
	}

	void walletMethod()
	{

		int option;
		System.out.println("YOUR CURRENT WALLET BALANCE IS - INR." + amtBalance );

		Scanner sc = new Scanner(System.in);

		try {

			System.out.print("DO YOU WANT TO DEPOSIT MORE AMOUNT TO YOUR WALLET? (1.YES 2.NO) - ");
			option = sc.nextInt();

			switch(option)
			{
			case 1: 	System.out.print("ENTER THE AMOUNT (INR) - ");
						double creditAmount = sc.nextDouble();
						amtBalance += creditAmount;
						System.out.println("YOUR WALLET BALANCE UPDATED SUCCESSFULLY. CURRENT WALLET BALANCE - INR." + amtBalance );
						break;

			case 2: 	break;

			default: 	System.out.println("INVALID CHOICE!!! TRY AGAIN");
			}
		}
		catch(InputMismatchException e)
		{
			System.out.println("INVALID INPUT DATA!!! ENTER VALID OPTION");
			e.getStackTrace();
		}
	}

}


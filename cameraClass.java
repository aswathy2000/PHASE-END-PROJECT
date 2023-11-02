package com.phaseendproject.camerarentalapp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class cameraClass {


	public static void main(String[] args)
	{
		try
		{
			cameraMethods();
		}
		catch(InputMismatchException e){
			System.out.println("INVALID INPUT DATA!!! ENTER VALID OPTION");
		}

	}

	public static void cameraMethods()
	{

		// Sample list of Cameras		

		ArrayList<cameraDetails> listCameras = new ArrayList<>();

		listCameras.add(new cameraDetails("Sony", "DSC-W800","Available" ,300));
		listCameras.add(new cameraDetails("Samsung", "WB350F","Rented" ,1500));
		listCameras.add(new cameraDetails("Sony", "A7","Available" ,5000));
		listCameras.add(new cameraDetails("Canon", "EOS 90D", "Rented" ,2500));
		listCameras.add(new cameraDetails("Samsung", "NX MINI","Available" ,1700));
		listCameras.add(new cameraDetails("Canon", "EOS R5","Available" ,3500));
		
		

		//CAMERA METHODS

		boolean wantTOExit = false;
		int choice,option;
		Scanner sc = new Scanner(System.in);
		walletClass objWallet = new walletClass();


		do {	

			System.out.println("1. MY CAMERA");
			System.out.println("2. RENT A CAMERA");
			System.out.println("3. VIEW ALL CAMERAS");
			System.out.println("4. MY WALLET");
			System.out.println("5. EXIT");

			choice = sc.nextInt();

			switch(choice)
			{
			case 1:		{
							System.out.println("1. ADD");
							System.out.println("2. REMOVE");
							System.out.println("3. VIEW MY CAMERAS");
							System.out.println("4. GO TO PREVIOUS MENU");
							option = sc.nextInt();
			
							switch(option)
							{
							case 1: addCameratoList(listCameras);
									break;
			
							case 2: removeCameratoList(listCameras);									
									break;
			
							case 3: viewMyCameraFromList(listCameras);
									break;
			
							case 4: 
									break;
								
							default: System.out.println("INVALID CHOICE!!! TRY AGAIN");
							}		
						}
						break;

			case 2:		rentCameraFromList(listCameras,objWallet);
						break;

			case 3:		
						displayCameraList(listCameras);
						break;

			case 4:		objWallet.walletMethod();							
						break;

			case 5:		exitingApplication();
						wantTOExit = true;
						break;

			default: 	System.out.println("INVALID CHOICE!!! TRY AGAIN");

			}

		}while(wantTOExit!=true);
	}


	//DIFFERENT OPERATIONS FOR CAMERA RENTAL
	
	
	//TO ADD A NEW CAMERA TO THE CAMERAS LIST

	private static void addCameratoList(ArrayList<cameraDetails> listCameras)
	{
		cameraDetails objCamera = new cameraDetails();
		listCameras.add(objCamera);
		System.out.println("YOUR CAMERA HAS BEEN SUCCESSFULLY ADDED TO THE LIST.");
	}	

	//TO REMOVE A CAMERA FROM THE CAMERAS LIST
	
	private static void removeCameratoList(ArrayList<cameraDetails> listCameras)
	{
		if( listCameras.isEmpty()==false)
		{
			Scanner sc = new Scanner(System.in);
			int cameraid;
			cameraDetails removeCam = null;
			displayCameraList(listCameras);
			System.out.print("ENTER THE CAMERA ID TO REMOVE - ");
			cameraid = sc.nextInt();


			boolean flag = false;

			//Searching for Camera-ID in Cameras List


			for( cameraDetails camera :  listCameras  )
			{
				if(camera.getCameraID() == cameraid)
				{
					removeCam = camera;
					flag = true;					
				}
			}		
			if(flag) 
			{
				listCameras.remove(removeCam);
				System.out.println("CAMERA SUCCESSFULLY REMOVED FROM THE LIST.");
			}
			else
			{
				System.out.println("INVALID CAMERA-ID!!! NO DATA FOR CAMERA-ID: " + cameraid + " .");
			}
		}
		else
		{
			System.out.println("NO CAMERA DATA TO REMOVE, NO DATA PRESENT AT THIS MOMENT");
		}
	}


	//TO RENT A CAMERA FROM THE CAMERAS LIST
	
	private static void rentCameraFromList(ArrayList<cameraDetails> listCameras, walletClass objWallet)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("FOLLOWING IS THE LIST OF AVAILABLE CAMERA(S) - ");

		ArrayList<cameraDetails> camList =  new ArrayList<>();
		String a = "Available";


		for( cameraDetails camera :  listCameras  )
		{
			String s = camera.getStatus();
			if (s.equals(a))
			{
				camList.add(camera);	
			}
		}
		displayCameraList(camList);


		System.out.println("ENTER THE CAMERA ID YOU WANT TO RENT - ");
		int cameraid = sc.nextInt();

		cameraDetails rentCamera = null;

		boolean flag = false;

		//Searching for Camera-ID in Cameras List

		for( cameraDetails camera :  listCameras  )
		{
			if(camera.getCameraID() == cameraid && (camera.getStatus()).equals(a))
			{
				rentCamera = camera;
				flag = true;					
			}
		}	

		if(flag) 
		{
			if(objWallet.getAmtBalance() > rentCamera.getPricePerDay())
			{
				objWallet.setAmtBalance(objWallet.getAmtBalance() - rentCamera.getPricePerDay());
				rentCamera.setStatus("Rented");
				System.out.println("YOUR TRANSACTION FOR CAMERA - " + rentCamera.getBrand()+ " - " + rentCamera.getModel() + " WITH RENT INR." + rentCamera.getPricePerDay() + " HAS SUCCESSFULLY COMPLETED.");

			}
			else 
			{
				System.out.println("ERROR : TRANSACTION FAILED DUE TO INSUFFIENT WALLET BALANCE. PLEASE DEPOSIT THE AMOUNT TO YOUR WALLET.");
			}
		}
		else
		{
			System.out.println("INVALID CAMERA-ID, CAMERA NOT AVAILABLE FOR RENT ");
		}

	}
	
	
	//	TO DISPLAY CAMERAS IN THE MY CAMERAS LIST
	
	private static void viewMyCameraFromList(ArrayList<cameraDetails> listCameras)
	{
		
		System.out.println("FOLLOWING IS MY LIST OF CAMERA(S) - ");

		ArrayList<cameraDetails> camList =  new ArrayList<>();
		String a = "Rented";


		for( cameraDetails camera :  listCameras  )
		{
			String s = camera.getStatus();
			if (s.equals(a))
			{
				camList.add(camera);	
			}
		}
		displayCameraList(camList);
	}
	

	//	TO DISPLAY ALL CAMERAS IN THE CAMERAS LIST
	
	private static void displayCameraList(ArrayList<cameraDetails> listCameras)
	{
		if( listCameras.isEmpty()==false)
		{
			System.out.println("=============================================================================================");  
			System.out.printf("%8s %12s %18s %22s %12s ", "CAMERA ID", "BRAND", "MODEL", "PRICE(PER DAY)", "STATUS"); 
			System.out.println();  
			System.out.println("============================================================================================="); 

			
			
			for(cameraDetails camera: listCameras)	
			{
				System.out.format("%6s %15s %18s %15s %20s ", camera.getCameraID(),camera.getBrand(), camera.getModel(),camera.getPricePerDay(),camera.getStatus());  
				System.out.println();  	  
			}
			System.out.println("=============================================================================================");
		}

		else
		{
			System.out.println("NO DATA PRESENT AT THIS MOMENT");
		}
	}
	
	
	//	TO EXIT THE CAMERA RENTAL APP

	private static void exitingApplication() 
	{
		System.out.println("Exiting Camera Rental App... \nThank you!");
	}
}

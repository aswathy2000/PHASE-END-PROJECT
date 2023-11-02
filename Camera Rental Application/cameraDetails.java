package com.phaseendproject.camerarentalapp;

import java.util.InputMismatchException;
import java.util.Scanner;

public class cameraDetails {

	private int cameraID;
	private static int counter=1;
	private String brand;
	private String model;
	private String status;
	private double pricePerDay;


	public cameraDetails(String brand, String model, String status, double pricePerDay) 
	{
		this.cameraID = counter++;
		this.brand = brand;
		this.model = model;
		this.status = status;
		this.pricePerDay = pricePerDay;
	}

	public cameraDetails() {

		try {
			this.cameraID = counter++;
			Scanner sc = new Scanner(System.in);
			System.out.print("\nENTER THE CAMERA BRAND - ");
			this.brand = sc.nextLine();
			System.out.print("ENTER THE MODEL -  ");
			this.model = sc.nextLine();
			System.out.print("ENTER THE PER DAY PRICE (INR) - ");
			this.pricePerDay = sc.nextDouble();
			this.status = "Available";
		}
		catch(InputMismatchException e)
		{
			System.out.println("INVALID INPUT DATA!!! ENTER VALID DATA");
			e.getStackTrace();
		}

	}

	@Override
	public String toString() {
		return "cameraDetails [cameraID=" + cameraID + ", brand=" + brand + ", model=" + model + ", status=" + status
				+ ", pricePerDay=" + pricePerDay + "]";
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setPricePerDay(double pricePerDay) {
		this.pricePerDay = pricePerDay;
	}

	public int getCameraID() {
		return cameraID;
	}

	public static int getCounter() {
		return counter;
	}

	public String getBrand() {
		return brand;
	}

	public String getModel() {
		return model;
	}

	public String getStatus() {
		return status;
	}

	public double getPricePerDay() {
		return pricePerDay;
	}

}

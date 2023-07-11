package controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Main {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		String departmentName;
		String workerName;
		String wl;
		
		Date date = null;
		Date dateMonthAndYear = null;
		String stringDate;
		String stringDateMonthAndYear;
		Double hoursValue;
		Integer hours;
		
		HourContract c1;
		
		
		int numberContracts;
		WorkerLevel wLevel;
		double baseSalary;
		Scanner scan = new Scanner(System.in);
		System.out.println("Department's name:");
		
		departmentName = scan.nextLine();
		Department d1 = new Department(departmentName); 
		
		System.out.println("Worker's name:");
		workerName = scan.nextLine();
		
		System.out.println("Worker's level:");
		wl = scan.nextLine();
		
		wLevel = WorkerLevel.valueOf(wl);
		
		System.out.println("Worker's base salary:");
		baseSalary = scan.nextDouble();
		
		Worker work1 = new Worker(workerName, wLevel, baseSalary, d1);
		
		System.out.println("How many contracts to this worker?");
		numberContracts = scan.nextInt();
		scan.nextLine();
		
		for(int i = 0; i < numberContracts; i++) {
			
			System.out.println("Date:");
			stringDate = scan.nextLine();
			try {
			date = new SimpleDateFormat("dd/MM/yyyy").parse(stringDate);
			}catch(Exception e1) {
				System.out.println("Insert a string.");
			}
			
			System.out.println("Value:");
			hoursValue = scan.nextDouble();
			
			System.out.println("Number of hours:");
			hours = scan.nextInt();
			scan.nextLine();
			
			c1 = new HourContract(date, hoursValue, hours);
			
			work1.addContract(c1);
	
			
			
		}
		
		System.out.println("Enter month and year to calculate income (MM/YYYY):");
		stringDateMonthAndYear = scan.nextLine();
		
		try {
			dateMonthAndYear = new SimpleDateFormat("MM/yyyy").parse(stringDateMonthAndYear);
			}catch(Exception e1) {
				System.out.println("Insert a string.");
			}
		
		Integer monthInserted;
		Integer yearInserted;
		
		monthInserted = dateMonthAndYear.getMonth();
		
		yearInserted = dateMonthAndYear.getYear();
		
		System.out.println("Name:" + work1.getName());
		System.out.println("Department:" + work1.getDepartment().getName());
		System.out.println("Income for " + stringDateMonthAndYear + ": " + String.format("%.2f", work1.income(yearInserted, monthInserted)));
		
		
		
		
		
		
		
		
		
		
		
		

	}

}

package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Main {

	public static void main (String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter department's name: ");
		String dep = sc.next();		
		System.out.println("Enter worker data: ");
		System.out.print("Name: ");
		String name = sc.next();		
		System.out.print("Level: ");
		String level = sc.next();
		WorkerLevel wl = null;
		if (level.equalsIgnoreCase("junior")) {
			wl = WorkerLevel.JUNIOR;
		} else if (level.equalsIgnoreCase("mid_level")) {
			wl = WorkerLevel.MID_LEVEL;
		} else if (level.equalsIgnoreCase("senior")) {
			wl = WorkerLevel.SENIOR;
		} else {
			System.out.println("Invalid Worker Level: ");
		}
		System.out.print("Base Salary: ");
		double salary = sc.nextDouble();
		Worker worker = new Worker(name, wl, salary, new Department(dep));
		
		System.out.print("How many contracts to this worker? ");
		int cont = sc.nextInt();
		for (int i=0; i<cont; i++) {
			System.out.println("Enter contract #"+(i+1)+" data:");
			System.out.print("Date (DD/MM/YYYY): ");
			String date = sc.next();
			Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(date);
			
			System.out.print("Value per hour: ");
			double valuePerHour = sc.nextDouble();
			
			System.out.print("Duration (hours): ");
			int hours = sc.nextInt();	
			
			HourContract hourContract = new HourContract(date1, valuePerHour, hours);
			worker.addContract(hourContract);
		}
		
		
		System.out.println();
		System.out.print("Enter month and year to calculate income (MM/YYYY): ");
		String dateMY = sc.next();
		int month = Integer.parseInt(dateMY.substring(0, 2));
		int year = Integer.parseInt(dateMY.substring(3));
	
		
		
		System.out.println("Name: "+worker.getName());
		System.out.println("Department: "+worker.getDepartment().getName());
		System.out.println("Income for "+dateMY+": "+worker.income(year, month));
		
		sc.close();
	}
}

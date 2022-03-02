
import java.util.Scanner;

public class SchneegassKayleeAssignment2 {

	public static void main(String[] args) {
		/* Name: Kaylee Schneegass
		   Class: CS1150 - Principles of Computer Science
		   Due: 2 FEB
		   Description: Assignment 2
		   The program will take user input for the road trip information and the details
		   for each rental car and output to a table. It will compute fuel cost, rental cost, and
		   total cost for each rental car, and the cost difference between the two.
		   User enters # of miles and days. Car format: Single word name for the car, followed by cost to rent per day (decimal points allowed),
		   followed by miles per gallon of the car.
		*/
		
		final double FUEL_PRICE = 3.20;
		
		Scanner input = new Scanner(System.in);
		
		//trip info
		System.out.println("Road Trip Information:\n"
				+ "--------------------------------------------");
		System.out.print("Enter the number of miles you will be driving: ");
		Integer tripMiles = input.nextInt();
		System.out.print("Enter the number of days for the road trip: ");
		Integer tripDays = input.nextInt();
		
		//car1
		System.out.println("\nRental Car #1 Information:\n"
				+ "--------------------------------------------");
		System.out.print("Enter the name of the first vehicle: ");
		String rentalCar1 = input.next();
		System.out.print("First car: " + rentalCar1);
		System.out.print("Enter the cost to rent the vehicle per day: ");
		Double car1CostPerDay = input.nextDouble();
		System.out.print("Enter the miles per gallon: ");
		Integer car1MPG = input.nextInt();
		
		//car2
		System.out.println("\nRental Car #2 Information:\n"
				+ "--------------------------------------------");
		System.out.print("Enter the name of the second vehicle: ");
		String rentalCar2 = input.next();
		System.out.print("Enter the cost to rent the vehicle per day: ");
		Double car2CostPerDay = input.nextDouble();
		System.out.print("Enter the miles per gallon: ");
		Integer car2MPG = input.nextInt();
		
		//closing the scanner
		input.close();
		
		//calculating fuel cost, rental cost, and total cost per car
		Double fuelCostCar1 = (tripMiles / car1MPG) * FUEL_PRICE;
		Double fuelCostCar2 = (tripMiles / car2MPG) * FUEL_PRICE;
		
		Double rentalCostCar1 = car1CostPerDay * tripDays;
		Double rentalCostCar2 = car2CostPerDay * tripDays;
		
		Double totalCostCar1 = fuelCostCar1 + rentalCostCar1;
		Double totalCostCar2 = fuelCostCar2 + rentalCostCar2;
		
		//Table print out Road Trip Details and Rental Car Costs
		System.out.println("\n******************************************************\n"
				+ "Road Trip Details:");
		System.out.printf("Number of miles = %5d\nNumber of Days = %5d\n", tripMiles, tripDays);
		System.out.println("\n******************************************************\n"
				+ "Road Trip Rental Car Costs\n"
				+ "******************************************************\n");
		System.out.printf("%-20s %-20s %-20s %-20s %-20s", "Vehicle", "Mile/Gallon", "Fuel Cost", "Rental Cost", "Total Cost");
		System.out.println("\n------------------------------------------------------------------------------------------------------------------");
		System.out.printf("%-20s %-20d %-20.2f %-20.2f %-20.2f\n", rentalCar1, car1MPG, fuelCostCar1, rentalCostCar1, totalCostCar1);
		System.out.printf("%-20s %-20d %-20.2f %-20.2f %-20.2f", rentalCar2, car2MPG, fuelCostCar2, rentalCostCar2, totalCostCar2);
		System.out.println("\n\n---------------------------------------------------------------------------------------------------------------");
		System.out.printf("%-20s %-20d %-20.2f %-20.2f %-20.2f\n\n", "Difference", Math.abs(car1MPG - car2MPG), Math.abs(fuelCostCar1 - fuelCostCar2), Math.abs(rentalCostCar1 - rentalCostCar2), Math.abs(totalCostCar1 - totalCostCar2));
		
	} // main

} // Assignment2
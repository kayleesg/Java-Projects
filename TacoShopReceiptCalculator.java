
import java.util.Scanner;

public class SchneegassKayleeAssignment3 {

	public static void main(String[] args) {
		/* Name: Kaylee 
		   Class: 
		   Due: 9 FEB
		   Description: Assignment 3
		   The program is the receipt printing program for a Taco Shop. It takes user input for number of tacos and the filling wanted to
		   calculate the total price of the order. If the customer orders 6 or more tacos, a discount is added. The program also adds tax.
		*/
		
		
		// Declaring constant values
		final double TAX = 8.5/100;
		final double DISCOUNT = .1;
		final double VEGGIEPRICE = 3.19;
		final double CHICKENPRICE = 3.59;
		final double BEEFPRICE = 3.99;
		final double AL_PASTORPRICE = 4.09;
		final double SHRIMPPRICE = 4.19;
		
		// The yesDiscount variable will turn 'true' if the customer asks for 6 or more tacos
		boolean yesDiscount = false;
		
		// Setting these values to 0 so I can manipulate them later
		double tacoPrice = 0;
		double totalPrice = 0;
		double taxAdded = 0;
		double discountAdded = 0;
		String textTacoFilling = "";
		
		// Opening the scanner for user INPUT
		Scanner input = new Scanner(System.in);
		
		// Welcome screen and menu
		System.out.println("\t\t\tWelcome to Hel Taco");
		System.out.println("\tTaco ordering courtesy of Java!");
		System.out.println("\tPlease follow the directions below to place your order:\n");
		System.out.println("\t\t\t\tMENU\n"
				+ "\n\t\tOption     Filling     Price\n"
				+ "\t----------------------------------------------\n"
				+ "\t\t   1       Veggie       " + VEGGIEPRICE
				+ "\n\t\t   2       Chicken      " + CHICKENPRICE
				+ "\n\t\t   3       Beef         " + BEEFPRICE
				+ "\n\t\t   4       Al Pastor    " + AL_PASTORPRICE
				+ "\n\t\t   5       Shrimp       " + SHRIMPPRICE);
		
		System.out.print("\nEnter your name for the order: ");
		String customerName = input.next();
		System.out.print("Enter the option number for the filling you want: ");
		Integer filling = input.nextInt();
		
		
		// Test user input on the filling selection
		if (filling >= 1 && filling <= 5) {
			switch (filling) {
			case 1: tacoPrice = VEGGIEPRICE;
					textTacoFilling = "Veggie";
					break;
			case 2: tacoPrice = CHICKENPRICE;
					textTacoFilling = "Chicken";
					break;
			case 3: tacoPrice = BEEFPRICE;
					textTacoFilling = "Beef";
					break;
			case 4: tacoPrice = AL_PASTORPRICE;
					textTacoFilling = "Al Pastor";
					break;
			case 5: tacoPrice = SHRIMPPRICE;
					textTacoFilling = "Shrimp";
					break;
			}
				
			// Reading input for number of tacos and testing if it's in the acceptable range
			System.out.print("Enter the number of tacos from 1 - 10: ");
			Integer numTacos = input.nextInt();
			if (numTacos >= 1 & numTacos <= 10) {
				// Setting the yesDiscount to 'true' so it will add a 10% discount onto the receipt
				if (numTacos >= 6) {
					yesDiscount = true;
				}
				
				// Printing the receipt and calculating the discount, taxes, and total price of the order
				System.out.printf("\nCustomer: %s", customerName);
				System.out.printf("\nTacos ordered: %d %s @ %3.2f", numTacos, textTacoFilling, tacoPrice);
				if (yesDiscount) {
					totalPrice = numTacos * tacoPrice;
					System.out.printf("\nSUBTOTAL: $%5.2f", totalPrice);
					discountAdded = totalPrice * DISCOUNT;
					System.out.printf("\nDiscount: -$%3.2f", discountAdded);
					totalPrice -= discountAdded;
					taxAdded = totalPrice * TAX;
					System.out.printf("\nTax: $%3.2f", taxAdded);
					totalPrice += taxAdded;
					System.out.printf("\nTotal Cost: $%5.2f", totalPrice);
				} else {
					totalPrice = numTacos * tacoPrice;
					System.out.printf("\nSUBTOTAL: $%3.2f", totalPrice);
					taxAdded = totalPrice * TAX;
					System.out.printf("\nTax: $%3.2f", taxAdded);
					totalPrice += taxAdded;
					System.out.printf("\nTotal Cost: $%5.2f", totalPrice);
					}
			} else {
				System.out.printf("%d is not a valid option. Please run again and enter a number from 1 - 10.", numTacos);
				}
		} else {
				System.out.printf("%d is not a valid option. Please run again and enter a number from 1 - 5.", filling);
		}
		
		// Closing the scanner
		input.close();
		
	} // main

} // Assignment 3

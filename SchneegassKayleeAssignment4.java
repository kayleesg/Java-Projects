
import java.util.Scanner;

public class SchneegassKayleeAssignment4 {

	public static void main(String[] args) {
		/* Name: Kaylee Schneegass
		   Class: CS1150 - Principles of Computer Science
		   Due: 16 FEB
		   Description: Assignment 4
		   The program take a 2 character user input and generates gift cards. The first character represents the company the card is from, the second character represents
		   the amount that the gift card is for. A randomly generated gift card number is printed.
		*/
		
		//Menu
		System.out.println("Enter two characters in one line");
		System.out.println("C: Chipotle  D: Dominos  M: McDonalds");
		System.out.println("1: $15 gift card  2: $20 gift card  3: 4-Pak of $10.00");
		
		// open scanner
		Scanner input = new Scanner(System.in);
		
		// user input
		String userInput = input.nextLine();
		
		// closing the scanner
		input.close();
		
		// extract and store each value
		char companyChoice = userInput.charAt(0);
		char giftCardAmount = userInput.charAt(1);
		int cardAmount = (int)giftCardAmount - 48;  // converting character to integer.
		
		// Test 1: Company choice
		if (companyChoice == 'C' || companyChoice == 'D' || companyChoice == 'M') {
			
			// Test 2: Gift Card Amount. Runs the rest of the code.
			if (cardAmount == 1 || cardAmount == 2 || cardAmount == 3) {
				String company;
				
				
				switch (companyChoice) {
				case 'C': company = "Chipotle";
				System.out.printf("%s: ", company);
				for (int i=0; i<2; i++) {
					int randomInt = (int)(Math.random() * 10);
					System.out.printf("%d", randomInt);
				}
				System.out.print("-");
				for (int j=0; j<3; j++) {
					char randomChar = (char)(65 + Math.random() * 25);
					System.out.printf("%c", randomChar);
				}
				System.out.print("-");
				for (int i=0; i<3; i++) {
					int randomInt = (int)(Math.random() * 10);
					System.out.printf("%d", randomInt);
				}
				break;
				
				case 'D': company = "Dominos";
				System.out.printf("%s: ", company);
				for (int i=0; i<1; i++) {
					int randomInt = (int)(Math.random() * 10);
					System.out.printf("%d", randomInt);
				}
				System.out.print(" ");
				for (int j=0; j<2; j++) {
					int randomInt = (int)(Math.random() * 10);
					System.out.printf("%d", randomInt);
				}
				System.out.print(" ");
				for (int i=0; i<3; i++) {
					int randomInt = (int)(Math.random() * 10);
					System.out.printf("%d", randomInt);
				}
				System.out.print("DM");
				break;
				
				case 'M': company = "McDonalds";
				System.out.printf("%s: ", company);
				for (int i=0; i<3; i++) {
					char randomChar = (char)(65 + Math.random() * 25);
					System.out.printf("%c", randomChar);
				}
				for (int j=0; j<3; j++) {
					int randomInt = (int)(Math.random() * 10);
					System.out.printf("%d", randomInt);
				}
				for (int i=0; i<3; i++) {
					char randomChar = (char)(65 + Math.random() * 25);
					System.out.printf("%c", randomChar);
				}
				break;
				} // end switch companyChoice
				
				
				switch (cardAmount) {
				case 1: System.out.println(" ($15.00 gift card)"); break;
				case 2: System.out.println(" ($20.00 gift card)"); break;
				case 3: System.out.println(" (4-pak of $10.00)"); break;
				} // end switch cardAmount
				
				
			} /* end-if for card amount */ else {
				System.out.println("Invalid input for amount selected");
			} // end-else for card amount
		} /* end-if for Choice */ else {
			System.out.println("Invalid input for company selected");
		} // end-else for Choice
		
	} // main

} // Assignment 4

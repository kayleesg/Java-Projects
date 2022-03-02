
import java.util.Scanner;

public class SchneegassKayleeQuiz1 {
	
	public static void main(String[] args) {
		/* Name: Kaylee Schneegass
		   Class: CS1150 - Principles of Computer Science
		   Due: 21 FEB
		   Description: Quiz 1
		   This program will determine the price for a cruise.
		   The program will take user input about the cruise line and the number of days on the cruise
		   to calculate the total cruise cost.
		*/
		//opening the scanner
		Scanner input = new Scanner(System.in);
		
		// STEP 1
		System.out.println("Enter ONE character for the cruise line - H: Holland,  N: Norwegian,  R: Royal Caribbean");
		String cruiseLine = input.next();
		
		if (cruiseLine.equalsIgnoreCase("H") || cruiseLine.equalsIgnoreCase("N") || cruiseLine.equalsIgnoreCase("R")) {
			
			String shipSailing = "";
			switch (cruiseLine){
			case "H": shipSailing = "Holland Cruise Line"; break;
			case "N": shipSailing = "Norwegian Cruise Line"; break;
			case "R": shipSailing = "Royal Caribbean Cruise Line"; break;
			}
			
			//STEP 2
			System.out.println("Selected " + shipSailing);
			
			//STEP 3
			System.out.println("Enter number of days to cruise - 1 to 20:");
			int numDaysSailing = input.nextInt();
			
			//done with the scanner
			input.close();
			
			if (numDaysSailing >= 1 && numDaysSailing <= 20) {
				
				// STEP 4
				double totalCost;
				int pricePerDay;
				switch (numDaysSailing) {
				case 1:
				case 2:
				case 3: totalCost = numDaysSailing * 200; pricePerDay = 200; break;
				case 4:
				case 5:
				case 6:
				case 7: totalCost = numDaysSailing * 180; pricePerDay = 180; break;
				default: totalCost = numDaysSailing * 150; pricePerDay = 150; break;
				}
				System.out.printf("At $%d per day, total cruise cost is $%4.2f", pricePerDay, totalCost);
				
			} else {
				System.out.println("Invalid number of days - good bye");
			}
		} else {
			System.out.println("Invalid cruise line - good bye");
		}
	} //main
} //Quiz 1
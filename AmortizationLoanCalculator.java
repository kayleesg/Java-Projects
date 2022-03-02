
import java.util.Scanner;

public class AmortizationLoanCalculator {

	public static void main(String[] args) {
		/* Name: Kaylee
		   Class: 
		   Due: 2 MAR
		   Description: Assignment 6
		   This program takes user input to calculate the Amortization schedule for the loan.
		   It takes input for loan amount, length (in years), and interest rate (in percentage).
		*/
		
		System.out.println("Welcome to CS1150 Federal Credit Union");
		System.out.print("Enter a loan amount between $5000 and $1000000: ");
		final int MIN_LOAN = 5000;
		final int MAX_LOAN = 1000000;
		
		// open scanner
		Scanner input = new Scanner(System.in);
		float loanAmount = input.nextFloat();
		
		if (MIN_LOAN <= loanAmount && loanAmount <= MAX_LOAN) {
			
			System.out.print("\nEnter number of years between 1 and 30: ");
			int years = input.nextInt();
			
			if (1 <= years && years <= 30) {
				
				System.out.print("\nEnter annual interest rate between 2.5 and 9.5: ");
				float percentInterestRate = input.nextFloat();
				//close scanner
				input.close();
				
				if (2.5 <= percentInterestRate && percentInterestRate <= 9.5) {
					
					int payments = years * 12;
					
					//calculating monthlyPayment
					double monthlyInterestRate = percentInterestRate / 1200;
					double monthlyPayment = (1 + monthlyInterestRate);
					for (int i = 0; i < payments-1; i++) {
						monthlyPayment = monthlyPayment * (1 + monthlyInterestRate);
					}
					monthlyPayment = 1 - (1 / monthlyPayment);
					monthlyPayment = (loanAmount * monthlyInterestRate) / monthlyPayment;
					
					double totalPaymentsDue = monthlyPayment * 12 * years;
					double balance = loanAmount;
					
					// Loan Details print statements
					System.out.println("\nLOAN DETAILS");
					System.out.println("----------------------------------------------------");
					System.out.printf("Monthly Payment: $%6.2f", monthlyPayment);
					System.out.printf("\nTotal Payments: $%6.2f", totalPaymentsDue);
					System.out.println("\n\nAmortization Schedule");
					System.out.println("----------------------------------------------------");
					System.out.println("Payment      Interest      Principal      Balance");
					System.out.println("----------------------------------------------------");
					
					// calculates and prints the Amortization schedule
					int i = 1;
					while (1 <= balance) {
						double interestPaid = balance * monthlyInterestRate;
						double principalPaid = monthlyPayment - interestPaid;
						balance = balance - principalPaid;
						System.out.printf("%4d %15.2f %15.2f %15.2f \n", i, interestPaid, principalPaid, balance);
						i++;
					} // while loop
					
				} /* percentInterestRate test */ else {
					System.out.println(percentInterestRate + " is not a valid loan percentage");
				}
			} /* years test */ else {
				System.out.println(years + " is not a valid number of years");
			}
		} /* loanAmount test */ else {
			System.out.println(loanAmount + " is not a valid loan amount");
		}
		
	} // main
} // Assignment 6

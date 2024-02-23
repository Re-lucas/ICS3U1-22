/*
	File Name: SimpleInterestAmount.java
	Name: Lucas Wu
   	Class: ICS3U1-01
	Date: Feb 23,2024
	Description: With simple interest, the amount of the 
    deposit remains the same, and the amount of interest is paid at the 
    end of a time interval. For example is $1,000 is deposited for 7 years 
    at an interest rate of 6% per year, $60 will be deposited at the end of 
    each year, for a total of $1420 after 7 years. The value of the amount 
    after the term is calculated using the formula:
    Amount = Principal * (1 + years * interest rate)
    Write a program that prompts the user for the principal, number of 
    years, and the interest rate and then calculates the total amount with 
    interest after the term.
*/

import java.util.Scanner;

public class SimpleInterestAmount {

    public static void main(String[] args) {
        // Create a scanner object to read user input
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for the principal, number of years, and interest rate
        System.out.print("Enter the principal: $");
        double principal = scanner.nextDouble();
        System.out.print("Enter the number of years: ");
        int years = scanner.nextInt();
        System.out.print("Enter the interest rate (as a decimal): ");
        double rate = scanner.nextDouble();

        // Calculate the amount using the formula
        double amount = principal * (1 + years * rate);

        // Display the amount with interest
        System.out.printf("The amount with interest after %d years is: $%.2f\n", years, amount);

        // Close the scanner object
        scanner.close();
    }
}

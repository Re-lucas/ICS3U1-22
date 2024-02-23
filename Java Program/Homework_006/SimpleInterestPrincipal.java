/*
	File Name: SimpleInterestPrincipal.java
	Name: Lucas Wu
   	Class: ICS3U1-01
	Date: Feb 23, 2024
	Description: SimpleInterestPrincipal.java The formula in part a) can be adjusted 
    to calculate what principal will need to be invested in order to have a 
    certain amount of money after a specified term and interest rate. Write 
    a program to prompt the user for the desired amount, number of years, 
    and interest rate, and then calculate the principal that will need to be 
    invested.
*/

import java.util.Scanner;

public class SimpleInterestPrincipal {

    public static void main(String[] args) {
        // Create a scanner object to read user input
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for the desired amount, number of years, and interest rate
        System.out.print("Enter the desired amount: $");
        double amount = scanner.nextDouble();
        System.out.print("Enter the number of years: ");
        int years = scanner.nextInt();
        System.out.print("Enter the interest rate (as a decimal): ");
        double rate = scanner.nextDouble();

        // Calculate the principal using the formula
        // Amount = Principal * (1 + years * interest rate)
        // Principal = Amount / (1 + years * interest rate)
        double principal = amount / (1 + years * rate);

        // Display the principal
        System.out.printf("The principal that will need to be invested is: $%.2f\n", principal);

        // Close the scanner object
        scanner.close();
    }
}

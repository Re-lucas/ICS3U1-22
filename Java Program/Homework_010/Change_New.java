/*
	File Name: OutputPrintf3.java
	Name: Lucas Wu
   	Class: ICS3U1-01
	Date: Feb 29, 2024
	Description:Create a program that prompts the user for an amount in 
    dollar and then displays the minimum number of coins necessary to make the 
    change. The change can be made up of toonies ($2), loonies ($1), quarters 
    (25 cents), dimes (10 cents), nickels (5 cents), and pennies (1 cent). The 
    program output should look similar to :
    Enter the amount (in dollar): 5.34
    The minimum number of coins is:
    Toonies: 2
    Loonies: 1
    Quarters: 1
    Dimes: 0
    Nickels: 1
    Pennies: 4
*/

import java.util.Scanner;

public class Change_New {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Prompt the user for the amount in dollars
        System.out.print("Enter the amount (in dollars): ");
        double amountInDollars = sc.nextDouble();

        // Convert the amount to cents
        int amountInCents = (int) (amountInDollars * 100);

        // Calculate the number of coins
        int toonies = amountInCents / 200;
        int remainingAmount = amountInCents % 200;

        int loonies = remainingAmount / 100;
        remainingAmount %= 100;

        int quarters = remainingAmount / 25;
        remainingAmount %= 25;

        int dimes = remainingAmount / 10;
        remainingAmount %= 10;

        int nickels = remainingAmount / 5;
        int pennies = remainingAmount % 5;

        // Display the result
        System.out.println("The minimum number of coins is:");
        System.out.println("Toonies: " + toonies);
        System.out.println("Loonies: " + loonies);
        System.out.println("Quarters: " + quarters);
        System.out.println("Dimes: " + dimes);
        System.out.println("Nickels: " + nickels);
        System.out.println("Pennies: " + pennies);

        // Close the scanner
        sc.close();
    }
}

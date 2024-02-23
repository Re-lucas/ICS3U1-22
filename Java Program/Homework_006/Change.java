/*
	File Name: Change.java
	Name: Lucas Wu
   	Class: ICS3U1-01
	Date: Feb 23,2024
    Description: Create a program that prompts the user for an amount in cent 
    and then displays the minimum number of coins necessary to make the 
    change. The change can be made up of toonies ($2), loonies ($1), quarters
    (25 cents), dimes (10 cents), nickels (5 cents), and pennies (1 cent). The 
    program output should look similar to :
    Enter the amount (in cent): 534
    The minimum number of coins is:
    Toonies: 2
    Loonies: 1
    Quarters: 1
    Dimes: 0
    Nickels: 1
    Pennies: 4

*/
import java.util.Scanner;

public class Change {

    public static void main(String[] args) {
        // Create a scanner object to read user input
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for an amount in cent
        System.out.print("Enter the amount (in cent): ");
        int amount = scanner.nextInt();

        // Initialize the variables for the number of coins
        int toonies = 0;
        int loonies = 0;
        int quarters = 0;
        int dimes = 0;
        int nickels = 0;
        int pennies = 0;

        // Calculate the minimum number of coins using a greedy algorithm
        // Start with the largest coin and subtract it from the amount until it is not possible
        // Then move on to the next largest coin and repeat the process
        // Keep track of the number of coins for each denomination
        while (amount >= 200) {
            amount -= 200;
            toonies++;
        }
        while (amount >= 100) {
            amount -= 100;
            loonies++;
        }
        while (amount >= 25) {
            amount -= 25;
            quarters++;
        }
        while (amount >= 10) {
            amount -= 10;
            dimes++;
        }
        while (amount >= 5) {
            amount -= 5;
            nickels++;
        }
        while (amount >= 1) {
            amount -= 1;
            pennies++;
        }

        // Display the minimum number of coins
        System.out.println("The minimum number of coins is:");
        System.out.println("Toonies: " + toonies);
        System.out.println("Loonies: " + loonies);
        System.out.println("Quarters: " + quarters);
        System.out.println("Dimes: " + dimes);
        System.out.println("Nickels: " + nickels);
        System.out.println("Pennies: " + pennies);

        // Close the scanner object
        scanner.close();
    }
}


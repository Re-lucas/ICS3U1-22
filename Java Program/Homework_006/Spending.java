/*
	File Name: Spending.java
	Name: Lucas Wu
   	Class: ICS3U1-01
	Date: Feb 23,2024
	Description: Write a program to help examine the spending patterns of a 
    user. The program should prompt the user for the amount spent last month 
    on food, clothing, entertainment, and rent, and then displays a table showing 
    the percentage of expenditures in each category. The program output should 
    look similar to:
    Enter the amount spent last month on the following item:
    Food: $250
    Clothing: $250
    Entertainment: $250
    Rent: $1250
    Category Budget
    Food 12.50%
    Clothing 12.50%
    Entertainment 12.50%
    Rent 62.50%
*/

import java.util.Scanner;

public class Spending {

    public static void main(String[] args) {
        // Create a scanner object to read user input
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for the amount spent last month on each item
        System.out.println("Enter the amount spent last month on the following item:");
        System.out.print("Food: $");
        double food = scanner.nextDouble();
        System.out.print("Clothing: $");
        double clothing = scanner.nextDouble();
        System.out.print("Entertainment: $");
        double entertainment = scanner.nextDouble();
        System.out.print("Rent: $");
        double rent = scanner.nextDouble();

        // Calculate the total amount and the percentage of each item
        double total = food + clothing + entertainment + rent;
        double foodPercent = food / total * 100;
        double clothingPercent = clothing / total * 100;
        double entertainmentPercent = entertainment / total * 100;
        double rentPercent = rent / total * 100;

        // Display the table showing the percentage of expenditures in each category
        System.out.println("Category\tBudget");
        System.out.printf("Food\t\t%.2f%%\n", foodPercent);
        System.out.printf("Clothing\t%.2f%%\n", clothingPercent);
        System.out.printf("Entertainment\t%.2f%%\n", entertainmentPercent);
        System.out.printf("Rent\t\t%.2f%%\n", rentPercent);

        // Close the scanner object
        scanner.close();
    }
}

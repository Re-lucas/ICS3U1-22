/*
	File Name: OutputPrintf3.java
	Name: Lucas Wu
   	Class: ICS3U1-01
	Date: Feb 29, 2024
	Description:Write a program that asks user for the price of an item, then output 
    the amount of HST for the item, followed by the total cost of the item. 
*/

import java.util.Scanner;

public class Cost {
    public static void main(String[] args) {
        final double HST_RATE = 0.13; // HST rate (13%)
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the price of the item: $");
        double itemPrice = scanner.nextDouble();

        double hstAmount = itemPrice * HST_RATE;
        double totalCost = itemPrice + hstAmount;

        System.out.printf("HST amount: $%.2f%n", hstAmount);
        System.out.printf("Total cost: $%.2f%n", totalCost);
        
        scanner.close();
    }
}

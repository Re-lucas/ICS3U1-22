/*
	File Name: OutputPrintf3.java
	Name: Lucas Wu
   	Class: ICS3U1-01
	Date: Feb 29, 2024
	Description:Write a program that asks for an amount of United States 
    money and then prints the Canadian equivalent. Canadian = U.S * 1.8
*/

import java.util.Scanner;

public class Currency {
    public static void main(String[] args) {
        final double EXCHANGE_RATE = 1.8; // Canadian dollar exchange rate
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter an amount in United States dollars: $");
        double usDollars = scanner.nextDouble();

        double canadianDollars = usDollars * EXCHANGE_RATE;

        System.out.printf("Equivalent amount in Canadian dollars: %.2f CAD%n", canadianDollars);

        scanner.close();
    }
}

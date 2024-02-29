/*
	File Name: OutputPrintf3.java
	Name: Lucas Wu
   	Class: ICS3U1-01
	Date: Feb 29, 2024
	Description:There are 2.54 cm in one inch. Write a program to input the 
    users height in inches and output their height in centimeters. Use a constant 
    for the conversion factor. Be sure to prompt fro the input and to label the 
    output
*/

import java.util.Scanner;

public class Height {
    public static void main(String[] args) {
        final double INCHES_TO_CM = 2.54; // Conversion factor: inches to centimeters
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your height in inches: ");
        double heightInInches = scanner.nextDouble();

        double heightInCm = heightInInches * INCHES_TO_CM;

        System.out.printf("Your height in centimeters: %.2f cm%n", heightInCm);

        scanner.close();
    }
}

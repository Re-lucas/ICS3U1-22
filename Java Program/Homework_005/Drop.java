/*
	File Name: Average.java
	Name: Lcuas Wu
   	Class: ICS3U1-01
	Date: Feb 15, 2024
	Description:  The height of an object at any given time dropped from a starting 
    height of 100 meters is given by the equation h = 100 – 4.9t2 where t is the 
    time in seconds. Write a program that prompts the user for a time less than 
    4.5 seconds and then displays the height of the object at that time. 
*/

import java.util.Scanner;

public class Drop {
        public static void main(String[] args) {
        // Constants
        final double GRAVITY = 4.9;

        // Input
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a time less than 4.5 seconds: ");
        double time = scanner.nextDouble();
        scanner.close();

        // Check if time is within the valid range
        if (time >= 0 && time < 4.5) {
            // Calculate height using the given equation
            double height = 100 - GRAVITY * Math.pow(time, 2);

            // Display the result
            System.out.println("At time " + time + " seconds, the height of the object is: " + height + " meters");
        } else {
            System.out.println("Please enter a valid time less than 4.5 seconds.");
        }
    } 
}

/*
	File Name: TimeConversion.java
	Name: Lucas Wu
   	Class: ICS3U1-01
	Date: Feb 23, 2024
	Description: Write a program that prompts the user for a time in 
    minutes and then display the time in hours and minutes. Be sure to consider 
    times whether the number of minutes left over is less than 10. For example, 
    184 minutes in hour:minute format is 3:04. (Hint: printf to zero padded the 
    value)
*/

import java.util.Scanner;

public class TimeConversion {

    public static void main(String[] args) {
        // Create a scanner object to read user input
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for a time in minutes
        System.out.print("Enter a time in minutes: ");
        int minutes = scanner.nextInt();

        // Calculate the hours and minutes using integer division and modulo
        int hours = minutes / 60;
        int minutesLeft = minutes % 60;

        // Display the time in hours and minutes using printf to zero pad the minutes
        System.out.printf("The time in hours and minutes is: %d:%02d\n", hours, minutesLeft);

        // Close the scanner object
        scanner.close();
    }
}

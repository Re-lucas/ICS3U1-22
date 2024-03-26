/*
	File Name: ConvertDate.java
	Name: Lucas Wu
   	Class: ICS3U1-01
	Date: Mar 21, 2024
	Description: 
*/

import java.util.Scanner;

public class ConvertDate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read input from the user
        System.out.print("Enter the year: ");
        int year = scanner.nextInt();

        System.out.print("Enter the month (1-12): ");
        int month = scanner.nextInt();

        System.out.print("Enter the day: ");
        int day = scanner.nextInt();

        // Define an array of month names
        String[] monthNames = {
                "January", "February", "March", "April",
                "May", "June", "July", "August",
                "September", "October", "November", "December"
        };

        // Validate month input
        if (month < 1 || month > 12) {
            System.out.println("Invalid month. Please enter a valid month (1-12).");
            scanner.close();
            return;
        }

        // Print the formatted date
        System.out.println(monthNames[month - 1] + " " + day + ", " + year);

        // Close the scanner
        scanner.close();
    }
}

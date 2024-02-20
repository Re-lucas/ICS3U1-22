/*
	File Name: Alive.java
	Name: Lucas Wu
   	Class: ICS3U1-01
	Date: Feb 20,2024
	Description: Write a program that calculates the number of hours of your life 
    that you have spent sleeping. Assume that you sleep 8 hours each night. To 
    simplify the problem, assume that there are 30 days in each month and 365 
    days in each year. The program output should look similar to:
        Enter your birthdate:
        Year: 1990
        Month: 9
        Day: 8
        Enter today’s date:
        Year: 2006
        Month: 2
        Day: 12
        You have been alive for 5634 days.
        You have slept 45072 hours.
*/
import java.util.Scanner;

public class Alive {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        // Variables
        int birthdate_year;
        int birthdate_month;
        int birthdate_day;

        int current_year;
        int current_month;
        int current_day;

        // Input
        System.out.println("Enter your birthdate: ");
        System.out.print("Year: ");
        birthdate_year = myScanner.nextInt();
        System.out.print("Month: ");
        birthdate_month = myScanner.nextInt();
        System.out.print("Day: ");
        birthdate_day = myScanner.nextInt();

        System.out.println("Enter today’s date: ");
        System.out.print("Year: ");
        current_year = myScanner.nextInt();
        System.out.print("Month: ");
        current_month = myScanner.nextInt();
        System.out.print("Day: ");
        current_day = myScanner.nextInt();

        // Calculation
        int year = current_year - birthdate_year;
        int month = current_month - birthdate_month;
        int day = current_day - birthdate_day;

        if (day < 0) {
            month--;  // Decrement month if the day is negative
            day += 30;  // Assume 30 days in a month
        }

        if (month < 0) {
            year--;  // Decrement year if the month is negative
            month += 12;  // Assume 12 months in a year
        }

        int convert_days_alive = year * 365 + month * 30 + day;
        int convert_hours_sleep = convert_days_alive * 8;

        // Output
        System.out.println("You have been alive for " + convert_days_alive + " days.");
        System.out.println("You have slept " + convert_hours_sleep + " hours.");

        myScanner.close();
    }
}

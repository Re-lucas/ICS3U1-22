/*
	File Name: Salary.java
	Name: Lucas Wu
   	Class: ICS3U1-01
	Date: Mar 5, 2024
	Description: Salary.java At Jackson boutique, a salesperson makes a monthly base 
    salary of $1000. If the person has made more than 10 sales during the 
    month, then s/he receives an extra commission equal to the sales percentage 
    of the base salary, e.g., a salesperson who makes 15 sales during the month 
    receives an extra commission of 15% of the base salary. Write a program 
    that prompt for the number of sales and determines the total salary for that 
    month.
*/

import java.util.Scanner;

public class Salary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Base salary
        double baseSalary = 1000.0;

        // Prompt the user for the number of sales
        System.out.print("Enter the number of sales: ");
        int numSales = scanner.nextInt();

        // Calculate the extra commission (if applicable)
        double commission = 0.0;
        if (numSales > 10) {
            // Commission percentage (15% in this example)
            double commissionPercentage = 0.15;
            commission = baseSalary * commissionPercentage;
        }

        // Calculate the total salary
        double totalSalary = baseSalary + commission;

        // Display the result
        System.out.println("Total salary for the month: $" + totalSalary);

        // Close the scanner
        scanner.close();
    }
}

/*
	File Name: PizzaCost.java
	Name: Lucas Wu
   	Class: ICS3U1-01
	Date: Feb 20,2024
	Description: The cost of making a pizza at a local shop is as follows:
    • Labour cost is $0.75 per pizza, regardless of size
    • Rent cost is $1.00 per pizza, regardless of size
    • Materials is $0.05*diameter*diameter (diameter is measured in inches)
    Write a program that prompts that user for the size of a pizza and then display the cost of making the pizza.
*/

import java.util.Scanner;

public class PizzaCost {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        // Constants
        final double labourCost = 0.75;
        final double rentCost = 1.00;
        final double materialsCostFactor = 0.05;

        // Variables
        double diameter;
        double materialsCost;
        double totalCost;

        // Asking the user for the diameter for the pizza
        System.out.println("Labour cost is $0.75 per pizza");
        System.out.println("Rent cost is $1.00 per pizza");
        System.out.println("Materials cost is $0.05 * diameter * diameter");

        System.out.print("Please enter the size (inch) of the pizza you want: ");
        diameter = myScanner.nextDouble();

        System.out.print("Please enter the materials cost of your pizza: ");
        materialsCost = myScanner.nextDouble();

        // Equation
        double materialsCostCalculation = materialsCostFactor * diameter * diameter;
        totalCost = materialsCost + labourCost + rentCost + materialsCostCalculation;

        // Display the total cost formatted to two decimal places
        System.out.printf("Here is the total cost of %.2f inch pizza: $%.2f%n", diameter, totalCost);

        myScanner.close();
    }
}

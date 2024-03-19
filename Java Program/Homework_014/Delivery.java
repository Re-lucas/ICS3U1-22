/*
	File Name: Delivery.java
	Name: Lucas Wu
   	Class: ICS3U1-01
	Date: Mar 19
	Description:  Delivery.java Jackson Delivery Service charges based on the weight of the package. 
    Up to 5 kg $3.00 per kg
    Over 5 to12 kg $3.50 per kg
    Over 12 to 20 kg $4.00 per kg
    Over 20 to 27 kg $4.50 per kg
    The company does not accept packages over 27 kilograms or large than 0.1 
    cubic meters (100,000 cubic centimeters). Write a program that prompts the 
    user for the weight of a package and its dimensions (length, width, and 
    height), and then displays an appropriate error message (too heavy, too 
    large) or the price to deliver the package.
*/

import java.util.Scanner;

public class Delivery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the weight of the package (in kilograms): ");
        double weight = scanner.nextDouble();

        System.out.print("Enter the length of the package (in centimeters): ");
        double length = scanner.nextDouble();

        System.out.print("Enter the width of the package (in centimeters): ");
        double width = scanner.nextDouble();

        System.out.print("Enter the height of the package (in centimeters): ");
        double height = scanner.nextDouble();

        double volume = length * width * height / 1000000.0; // Convert to cubic meters

        if (weight > 27 || volume > 0.1) {
            System.out.println("Error: Package is too heavy or too large.");
        } else {
            double cost;
            if (weight <= 5) {
                cost = weight * 3.00;
            } else if (weight <= 12) {
                cost = weight * 3.50;
            } else if (weight <= 20) {
                cost = weight * 4.00;
            } else {
                cost = weight * 4.50;
            }
            System.out.printf("Delivery cost: $%.2f%n", cost);
        }

        scanner.close();
    }
}


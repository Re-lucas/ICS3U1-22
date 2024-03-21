/*
	File Name: FoodOrder.java
	Name: Lucas Wu
   	Class: ICS3U1-01
	Date: Mar 21, 2024
	Description: 
*/

import java.util.Scanner;

public class FoodOrder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Display the menu
        System.out.println("Menu:");
        System.out.println("1) juice, muffin, coffee");
        System.out.println("2) cereal, toast, milk");
        System.out.println("3) egg, toast, coffee");
        System.out.println("4) banana, granola, milk");
        System.out.println("5) grapefruit, bacon, eggs, coffee");

        // Ask for user's choice
        System.out.print("Enter your choice (1-5): ");
        int choice = scanner.nextInt();

        // Validate user's choice
        while (choice < 1 || choice > 5) {
            System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            System.out.print("Enter your choice (1-5): ");
            choice = scanner.nextInt();
        }

        // Calculate the cost based on the user's choice
        double cost;
        
        switch (choice) {
            case 1:
            case 2:
                cost = 2.50;
                break;
            case 3:
                cost = 3.00;
                break;
            case 4:
                cost = 3.50;
                break;
            case 5:
                cost = 5.00;
                break;
            default:
                System.out.println("You did not select an appropriate number.");
                return;
        }

        // Display the cost
        System.out.println("Cost: $" + cost);

        // Close the scanner
        scanner.close();
    }
}

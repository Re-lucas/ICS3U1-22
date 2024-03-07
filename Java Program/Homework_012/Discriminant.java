/*
	File Name: Discriminant.java
	Name: Lucas Wu
   	Class: ICS3U1-01
	Date: Mar 7,2024
	Description: 
*/

import java.util.Scanner;

public class Discriminant {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user for coefficients
        System.out.print("Enter the value of a: ");
        double a = scanner.nextDouble();
        System.out.print("Enter the value of b: ");
        double b = scanner.nextDouble();
        System.out.print("Enter the value of c: ");
        double c = scanner.nextDouble();

        // Calculate the discriminant
        double discriminant = b * b - 4 * a * c;

        // Determine the number of roots
        if (discriminant < 0) {
            System.out.println("No roots");
        } else if (discriminant == 0) {
            System.out.println("One root");
        } else {
            System.out.println("Two roots");
        }

        scanner.close();
    }
}

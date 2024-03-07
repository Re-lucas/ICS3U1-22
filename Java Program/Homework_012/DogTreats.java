/*
	File Name: DogTreats.java
	Name: Lucas Wu
   	Class: ICS3U1-01
	Date: Mar 7,2024
	Description: 
*/

import java.util.Scanner;

public class DogTreats {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user for the number of small, medium, and large treats
        System.out.print("Enter the number of small treats (S): ");
        int smallTreats = scanner.nextInt();
        System.out.print("Enter the number of medium treats (M): ");
        int mediumTreats = scanner.nextInt();
        System.out.print("Enter the number of large treats (L): ");
        int largeTreats = scanner.nextInt();

        // Calculate happiness score
        int happinessScore = 1 * smallTreats + 2 * mediumTreats + 3 * largeTreats;

        // Determine Barley's mood
        if (happinessScore > 20) {
            System.out.println("Barley is happy!");
        } else if (happinessScore < 10) {
            System.out.println("Barley is sad.");
        } else {
            System.out.println("Barley is OK.");
        }

        scanner.close();
    }
}

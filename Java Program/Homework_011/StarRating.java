/*
	File Name: Delivedroid.java
	Name: Lucas Wu
   	Class: ICS3U1-01
	Date: Mar 5, 2024
	Description: StarRating.java In the Jackville kickball league, star ratings of players are
    based on the number of points that they score and the number of fouls that 
    they commit. Specifically, they are awarded 5 stars for each points scored, 
    and 3 stars are taken away for each foul committed. Players with star rating 
    greater than 40 are considered Gold Stars. Write a program that prompts for 
    the number of points and the number of fouls of a player and determine if he / 
    she is a Gold Star or not

*/

import java.util.Scanner;

public class StarRating {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt for the number of points scored
        System.out.print("Enter the number of points scored: ");
        int points = scanner.nextInt();

        // Prompt for the number of fouls committed
        System.out.print("Enter the number of fouls committed: ");
        int fouls = scanner.nextInt();

        // Calculate star rating
        int stars = 5 * points - 3 * fouls;

        // Determine if the player is a Gold Star
        if (stars > 40) {
            System.out.println("Congratulations! You are a Gold Star.");
        } else {
            System.out.println("Keep playing! You are not a Gold Star yet.");
        }

        // Close the scanner
        scanner.close();
    }
}


/*
	File Name: Delivedroid.java
	Name: Lucas Wu
   	Class: ICS3U1-01
	Date: Mar 5, 2024
	Description: Delivedroid.java In the game, Deliv-e-droid, a robot droid has to deliver 
    packages while avoiding obstacles. At the end of the game, the final score is 
    calculated based on the following point system: 
    • Gain 50 points for every package delivered.
    • Lose 10 points for every collision with an obstacle.
    • Earn a bonus 500 points if the number of packages delivered is greater 
    than the number of collisions with obstacles. 
    Write a program to determine the final score at the end of a game. The 
    program should prompt for the number of packages delivered and the number 
    of collisions with obstacles, the calculates and outputs the final score. (CCC
    2023 J1)

*/

import java.util.Scanner;

public class Delivedroid {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt for the number of packages delivered
        System.out.print("Enter the number of packages delivered: ");
        int numPackagesDelivered = scanner.nextInt();

        // Prompt for the number of collisions with obstacles
        System.out.print("Enter the number of collisions with obstacles: ");
        int numCollisions = scanner.nextInt();

        // Calculate points
        int packagePoints = numPackagesDelivered * 50;
        int collisionPoints = numCollisions * (-10);
        int bonusPoints = (numPackagesDelivered > numCollisions) ? 500 : 0;

        // Calculate final score
        int finalScore = packagePoints + collisionPoints + bonusPoints;

        // Display the result
        System.out.println("Final Score: " + finalScore);

        // Close the scanner
        scanner.close();
    }
}

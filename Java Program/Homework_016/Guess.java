/*
	File Name: Guess.java
	Name: Lucas WU
   	Class: ICS3U1-01
	Date: Mar 28, 2024
	Description: 
*/

import java.util.Scanner;

public class Guess {
    public static void main(String[] args) {
        final int CORRECT_NUMBER = 10; // Change this to the desired correct number
        Scanner scanner = new Scanner(System.in);
        int guess;

        do {
            System.out.print("Guess a number between 1 and 20: ");
            guess = scanner.nextInt();

            if (guess < 1 || guess > 20) {
                System.out.println("Invalid input. Please guess a number between 1 and 20.");
            } else if (guess == CORRECT_NUMBER) {
                System.out.println("Congratulations! You guessed the correct number.");
            } else {
                System.out.println("Try again!");
            }
        } while (guess != CORRECT_NUMBER);

        scanner.close();
    }
}

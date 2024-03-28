/*
	File Name: Age.java
	Name: Lucas WU
   	Class: ICS3U1-01
	Date: Mar 28, 2024
	Description: 
*/


import java.util.Scanner;

public class Age {
    public static void main(String[] args) {
        final int YOUR_AGE = 30; // Change this to your actual age
        Scanner scanner = new Scanner(System.in);
        int userGuess;

        do {
            System.out.print("Guess my age: ");
            userGuess = scanner.nextInt();

            if (userGuess == YOUR_AGE) {
                System.out.println("Correct! You guessed my age.");
            } else {
                System.out.println("Try again!");
            }
        } while (userGuess != YOUR_AGE);

        scanner.close();
    }
}

/*
	File Name: Pass.java
	Name: Lucas Wu
   	Class: ICS3U1-01
	Date: Mar 5, 2024
	Description:  Pass.java: Write a program which displays a random math addition question, 
    asks the user for the answer and tells them whether they are correct or not.
*/

import java.util.Scanner;
import java.util.Random;

public class Pass {
    public static void main(String[] args) {

        //Creat two variable for Scanner and Random
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Generate two random numbers for the addition question
        int num1 = random.nextInt(100); // Random number between 0 and 99
        int num2 = random.nextInt(100);

        // Calculate the correct answer
        int correctAnswer = num1 + num2;

        // Display the question to the user
        System.out.println("What is the sum of " + num1 + " and " + num2 + "?");

        // Get the user's answer
        System.out.print("Enter your answer: ");
        int userAnswer = scanner.nextInt();

        // Check if the user's answer is correct
        if (userAnswer == correctAnswer) {
            System.out.println("Correct! Well done.");
        } else {
            System.out.println("Incorrect. The correct answer is " + correctAnswer + ".");
        }

        // Close the scanner
        scanner.close();
    }
}

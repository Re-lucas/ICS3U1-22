/*
	File Name: Capital.java
	Name: Lucas Wu
   	Class: ICS3U1-01
	Date: Mar 19
	Description:Attempt to do this question, but don’t spend too much time if it does not work, 
    but I want you to know WHY it does not work.
    Capital.java Ask the user to enter the capital of Canada. Tell them if they 
    are correct or not.
*/

import java.util.Scanner;

public class Capital {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the capital of Canada: ");
        String userAnswer = scanner.nextLine().trim();

        // Convert user input to lowercase for case-insensitive comparison
        String correctAnswer = "ottawa";

        if (userAnswer.equalsIgnoreCase(correctAnswer)) {
            System.out.println("Correct! Ottawa is the capital of Canada.");
        } else {
            System.out.println("Incorrect. The capital of Canada is Ottawa.");
        }

        scanner.close();
    }
}

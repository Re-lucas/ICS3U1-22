/*
	File Name: AgeCkeck.java
	Name: Lucas WU
   	Class: ICS3U1-01
	Date: Mar 5, 2024
	Description: AgeCheck.java: Write a program that asks the user’s age. If the age is 
   eighteen or more, the program should print “OLD ENOUGH TO VOTE”. 
   Otherwise it should print the number of years before voting is possible.

*/

import java.util.Scanner;

public class AgeCheck {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for their age
        System.out.print("Enter your age: ");
        int age = scanner.nextInt();

        // Check if the user is old enough to vote
        if (age >= 18) {
            System.out.println("OLD ENOUGH TO VOTE");
        } else {
            int yearsUntilVoting = 18 - age;
            System.out.println("You need to wait " + yearsUntilVoting + " years before voting is possible.");
        }

        // Close the scanner
        scanner.close();
    }
}

/*
	File Name: Tip.java
	Name: Lucas WU
   	Class: ICS3U1-01
	Date: Mar 21, 2024
	Description: 
*/

import java.util.Scanner;

public class Tip {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for their letter grade
        System.out.print("Enter your letter grade (A, B, C, D, F): ");
        char grade = scanner.next().charAt(0);

        // Provide study tips based on the grade
        switch (grade) {
            case 'A':
                System.out.println("Great job! Keep up the good work!");
                break;
            case 'B':
                System.out.println("You're doing well. Focus on understanding concepts.");
                break;
            case 'C':
                System.out.println("Work harder to improve. Seek additional resources.");
                break;
            case 'D':
                System.out.println("Consider seeking help from your instructor or classmates.");
                break;
            case 'F':
                System.out.println("Don't give up! Review material and seek tutoring.");
                break;
            default:
                System.out.println("Invalid grade. Please enter A, B, C, D, or F.");
        }

        // Close the scanner
        scanner.close();
    }
}

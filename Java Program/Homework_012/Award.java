/*
	File Name: Award.java
	Name: Lucas Wu
   	Class: ICS3U1-01
	Date: Mar 7,2024
	Description: 
*/

import java.util.Scanner;

public class Award {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user for letter grades
        System.out.print("Enter the grade for essay 1 (A, B, C, or D): ");
        String grade1 = scanner.next();
        System.out.print("Enter the grade for essay 2 (A, B, C, or D): ");
        String grade2 = scanner.next();
        System.out.print("Enter the grade for essay 3 (A, B, C, or D): ");
        String grade3 = scanner.next();
        System.out.print("Enter the grade for essay 4 (A, B, C, or D): ");
        String grade4 = scanner.next();

        // Calculate total score
        int totalScore = getNumericScore(grade1) + getNumericScore(grade2)
                + getNumericScore(grade3) + getNumericScore(grade4);

        // Determine the award type
        if (totalScore >= 8) {
            System.out.println("Distinction award");
        } else if (totalScore > 0) {
            System.out.println("Participation award");
        } else {
            System.out.println("No award");
        }

        scanner.close();
    }

    // Helper method to convert letter grade to numeric score
    public static int getNumericScore(String grade) {
        switch (grade) {
            case "A":
                return 3;
            case "B":
                return 2;
            case "C":
                return 1;
            default:
                return 0;
        }
    }
}

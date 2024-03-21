/*
	File Name: LastDigit.java
	Name: Lucas Wu
   	Class: ICS3U1-01
	Date: Mar 21, 2024
	Description: 
*/

import java.util.Scanner;

public class LastDigit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the integer input
        System.out.print("Enter an integer: ");
        int number = scanner.nextInt();

        // Get the last digit
        int lastDigit = Math.abs(number) % 10;

        // Convert the last digit to a word
        String word;
        switch (lastDigit) {
            case 0:
                word = "zero";
                break;
            case 1:
                word = "one";
                break;
            case 2:
                word = "two";
                break;
            case 3:
                word = "three";
                break;
            case 4:
                word = "four";
                break;
            case 5:
                word = "five";
                break;
            case 6:
                word = "six";
                break;
            case 7:
                word = "seven";
                break;
            case 8:
                word = "eight";
                break;
            case 9:
                word = "nine";
                break;
            default:
                word = "unknown";
        }

        // Print the result
        System.out.println("The last digit of " + number + " is " + word);

        // Close the scanner
        scanner.close();
    }
}

/*
	File Name: CheckInt.java
	Name: Lucas Wu
   	Class: ICS3U1-01
	Date: Mar 7,2024
	Description: 
*/

import java.util.Scanner;

public class CheckInt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int number = scanner.nextInt();
        scanner.close();

        // Check if the number is positive or negative
        if (number > 0) {
            System.out.println(number + " is positive.");
        } else if (number < 0) {
            System.out.println(number + " is negative.");
        } else {
            System.out.println(number + " is neither positive nor negative.");
        }

        // Check if the number is even or odd
        if (number % 2 == 0) {
            System.out.println(number + " is even.");
        } else {
            System.out.println(number + " is odd.");
        }

        // Check if the number is a multiple of 7
        if (number % 7 == 0) {
            System.out.println(number + " is a multiple of 7.");
        } else {
            System.out.println(number + " is not a multiple of 7.");
        }
    }
}


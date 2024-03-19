/*
	File Name: Stages.java
	Name: Lucas Wu
   	Class: ICS3U1-01
	Date: Mar 19,2024
	Description:  Write a program that prompts user for an age. For an age over 
    18, adult is displayed. For an age less than or equal to 18, toddler is 
    displayed when the age is less than or equal to 5, child when the age is less 
    than or equal to 10, preteen when the age is less than or equal to 12, and 
    teen when the age is over 12.

*/

import java.util.Scanner;

public class Stages {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter an age: ");
        int age = scanner.nextInt();

        if (age > 18) {
            System.out.println("Adult");
        } else if (age <= 5) {
            System.out.println("Toddler");
        } else if (age <= 10) {
            System.out.println("Child");
        } else if (age <= 12) {
            System.out.println("Preteen");
        } else {
            System.out.println("Teen");
        }

        scanner.close();
    }
}
